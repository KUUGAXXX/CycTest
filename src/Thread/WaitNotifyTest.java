package Thread;

public class WaitNotifyTest {
    public synchronized void before(){
        System.out.println("before");
        notifyAll();
    }
    public synchronized void after(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {

        WaitNotifyTest result=new WaitNotifyTest();

        result.
    }
}
