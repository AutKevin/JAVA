package com.qy.zip;

import java.io.*;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

class ZipCompress
{
    private String zipFileName;      // 目的地Zip文件
    private String sourceFileName;   //源文件（带压缩的文件或文件夹）
    
    public ZipCompress(String zipFileName,String sourceFileName)
    {
        this.zipFileName=zipFileName;
        this.sourceFileName=sourceFileName;
    }
    
    public void zip() throws Exception
    {
        //File zipFile = new File(zipFileName);
        System.out.println("压缩中...");
        //创建zip输出流
        ZipOutputStream out = new ZipOutputStream( new FileOutputStream(zipFileName));
        out.setEncoding("gbk");   //解决文件名乱码
        //创建缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(out);
        //源文件
        File sourceFile = new File(sourceFileName);
        //调用函数
        compress(out,bos,sourceFile,sourceFile.getName());
        
        //bos.close();
        out.close();
        System.out.println("压缩完成");
        
    }
    
    /**
     * 将每个文件/文件夹压缩进压缩文件
     * @param out 压缩流
     * @param bos 包装的压缩流
     * @param sourceFile 源文件
     * @param base 源文件名(包含至压缩文件夹的路径)
     * @throws Exception
     */
    public void compress(ZipOutputStream out,BufferedOutputStream bos,File sourceFile,String base) throws Exception
    {
        //如果路径为目录（文件夹）
        if(sourceFile.isDirectory())
        {
            //取出文件夹中的文件（或子文件夹）
            File[] flist = sourceFile.listFiles();
            if(flist.length==0)//如果文件夹为空，则只需在目的地zip文件中写入一个目录进入点
            {
                System.out.println(base+"/");
                out.putNextEntry(  new ZipEntry(base+"/") );//只要有文件就可以,文件夹没有内容
            }
            else//如果文件夹不为空，则递归调用compress，文件夹中的每一个文件（或文件夹）进行压缩
            {
                for(int i=0;i<flist.length;i++)
                {
                    compress(out,bos,flist[i],base+"/"+flist[i].getName());
                }
            }
        }
        else//如果不是目录（文件夹），即为文件，则先写入目录进入点，之后将文件写入zip文件中
        {
            out.putNextEntry( new ZipEntry(base) );//生成文件,但是无内容!!!
            //读取目标文件,将文件写入到指定文件中
            FileInputStream fis = new FileInputStream(sourceFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] temparray = new byte[1024];
            int len;
            System.out.println(base);
            //将源文件写入到zip文件中
            while((len=bis.read(temparray))!=-1)
            {   
            	if (len<1024) {
                	System.out.println(len);
				}
                bos.write(temparray,0,len);
            }
            bos.flush();    //文件结束,这句一定要写!!!!!(否则会输出到下一个文件)
            bis.close();
            fis.close();
            
        }
    }
}
