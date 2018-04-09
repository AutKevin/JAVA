import java.io.File;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 下载图片
 */
public class BaiDuMapDownload {
    static volatile Integer c = 0;//成功数
    static volatile Integer fail = 0;//失败数量
    public static void main(String[] args)
            throws Exception {
        String link =
                "http://online3.map.bdimg.com/onlinelabel/?qt=tile&x={x}&y={y}&z={z}&styles=pl&udt=20170712&scaler=1&p=1";
        int z = 12;//18;//层级
        int xmin = 808;//51757; //x最小值
        int xmax = 814;//52146;//x最大值
        int ymin = 230;//14720;//y最小值
        int ymax = 239;//15400;//y最大值
        long start = System.currentTimeMillis();    //开始时间
            for (int i = xmin; i <= xmax; i++) {   //循环X
                for (int j = ymin; j <= ymax; j++) {    //循环Y
                    try {
                        URL url = new URL(link.replace("{x}", i + "").replace("{y}", j + "").replace("{z}", z + ""));
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        //conn.setRequestProperty("","");
                        conn.setConnectTimeout(100);
                        conn.connect();
                        InputStream in = conn.getInputStream();
                        File dir = new File("d:/mybaidumapdownload1/tiles/" + z + "/" + i);
                        if (!dir.exists()) {
                            dir.mkdirs();
                        }
                        File file = new File("d:/mybaidumapdownload1/tiles/" + z + "/" + i + "/" + j + ".jpg");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        OutputStream out = new FileOutputStream(file);
                        byte[] bytes = new byte[1024 * 20];
                        int len = 0;
                        while ((len = in.read(bytes)) != -1) {
                            out.write(bytes, 0, len);
                        }
                        out.close();
                        in.close();
                        //System.out.println("已成功下载:" + z + "_" + i + "_" + j + ".jpg");
                        c++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        fail++;
                    }
                }    //循环Y结束
            }   //循环X结束
        System.out.println("-------用时-------:" + (System.currentTimeMillis() - start));
        System.out.println("共下载:   " + c + "   张");
        System.out.println("失败:   " + fail + "   张");
    }
}

/**
 * 线程池下载图片
 */
class BDTask implements Runnable{
    String link;
    int i;  //x坐标
    int j;  //y坐标
    int z;  //缩放级别

    static volatile Integer c = 0;//成功数
    static volatile Integer fail = 0;//失败数量

    public BDTask(String link, int i, int j, int z) {
        this.link = link;
        this.i = i;
        this.j = j;
        this.z = z;

    }
    public static void main(String[] args)
            throws Exception {
        String link =
                "http://online3.map.bdimg.com/onlinelabel/?qt=tile&x={x}&y={y}&z={z}&styles=pl&udt=20170712&scaler=1&p=1";
        int z = 12;//18;//层级
        int xmin = 808;//51757; //x最小值
        int xmax = 814;//52146;//x最大值
        int ymin = 230;//14720;//y最小值
        int ymax = 239;//15400;//y最大值
        long start = System.currentTimeMillis();    //开始时间
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,4,500, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = xmin; i <= xmax; i++) {   //循环X
            for (int j = ymin; j <= ymax; j++) {    //循环Y
                threadPoolExecutor.execute(new BDTask(link,i,j,z));
                //new Thread(new BDTask(link,i,j,z)).start();    //此种方法会一直创建线程导致死机
                    /*try {
                        URL url = new URL(link.replace("{x}", i + "").replace("{y}", j + "").replace("{z}", z + ""));
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setConnectTimeout(100);
                        conn.connect();
                        InputStream in = conn.getInputStream();
                        File dir = new File("d:/mybaidumapdownload1/tiles/" + z + "/" + i);
                        if (!dir.exists()) {
                            dir.mkdirs();
                        }
                        File file = new File("d:/mybaidumapdownload1/tiles/" + z + "/" + i + "/" + j + ".jpg");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        OutputStream out = new FileOutputStream(file);
                        byte[] bytes = new byte[1024 * 20];
                        int len = 0;
                        while ((len = in.read(bytes)) != -1) {
                            out.write(bytes, 0, len);
                        }
                        out.close();
                        in.close();
                        //System.out.println("已成功下载:" + z + "_" + i + "_" + j + ".jpg");
                        c++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        fail++;
                    }*/
            }    //循环Y结束
        }   //循环X结束
        threadPoolExecutor.shutdown();   //关闭线程池
        while (!threadPoolExecutor.isTerminated()){}     //所有任务被执行完毕时继续往下执行
        System.out.println("-------用时-------:" + (System.currentTimeMillis() - start));
        System.out.println("共下载:   " + c + "   张");
        System.out.println("失败:   " + fail + "   张");
    }

    public void run() {
        try {
            URL url = new URL(link.replace("{x}", i + "").replace("{y}", j + "").replace("{z}", z + ""));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(100);
            conn.connect();
            InputStream in = conn.getInputStream();
            File dir = new File("d:/mybaidumapdownload1/tiles/" + z + "/" + i);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File("d:/mybaidumapdownload1/tiles/" + z + "/" + i + "/" + j + ".jpg");
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream out = new FileOutputStream(file);
            byte[] bytes = new byte[1024 * 20];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
            out.close();
            in.close();
            synchronized (fail) {
                c++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            synchronized (c) {
                fail++;
            }
        }
    }
}
