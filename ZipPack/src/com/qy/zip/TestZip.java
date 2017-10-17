package com.qy.zip;

public class TestZip 
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ZipCompress zipCom = new ZipCompress("D:\\Users\\Autumn\\Downloads\\电影.zip","D:\\Programmer_QY\\apache-tomcat-7.0.78\\webapps\\ShebaoProtocol\\declare_attached\\814379857\\glgzzd");
        
        try
        {
            zipCom.zip();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}