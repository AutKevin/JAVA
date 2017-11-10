public class Counter {
    public static void main(String[] args) {
    	long time_s=System.currentTimeMillis();
        //同时启动1000个线程，去进行i++计算，看看实际结果
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    CounterSingleton.getInstance().inc();
                }
            }).start();
        }
 
        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:CounterSingleton.count=" + CounterSingleton.getInstance().getCount());
        System.out.println("耗时:"+(System.currentTimeMillis()-time_s));
    }
}