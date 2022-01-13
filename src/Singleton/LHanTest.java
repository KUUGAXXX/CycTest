package Singleton;

public class LHanTest {
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        MyThread t3=new MyThread();
        Thread result1=new Thread(t1);
        Thread result2=new Thread(t2);
        Thread result3=new Thread(t3);
        result1.start();
        result2.start();
        result3.start();
    }
//用volatile来防止指令重排序（有人说是用了volatile的线程可见性，是错的，是运用了他的防止指令重排序的特点）
//volatile是用来同步各个线程之间instance是否存在
    private volatile static LHanTest instance;
    private LHanTest(){}

    //整个方法被上锁
//    synchronized public static LHanTest getInstance(){
    public static LHanTest getInstance(){
        try {
            if(instance==null) {
                synchronized (MyThread.class) {
                    if (instance == null) {
                        Thread.sleep(3000);
                        instance = new LHanTest();
                    }
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return instance;
    }
}

class MyThread implements Runnable{
    public void run(){
        System.out.println(LHanTest.getInstance().hashCode());
    }
}
