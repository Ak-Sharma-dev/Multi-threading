import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutualExclusionExample {

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new MutualExclusionThread());
        Thread B = new Thread(new MutualExclusionThread());
        A.start();
        B.start();
        A.join();
        B.join();
        System.out.println("The count is: "+ MutualExclusionThread.count);
    }

    public static class MutualExclusionThread implements Runnable {

        static int count = 0;
        static Lock myLock = new ReentrantLock();

        @Override
        public void run() {

            for(int i=0; i<5; i++) {
                myLock.lock();
                count++;
                myLock.unlock();
                System.out.println(Thread.currentThread().getName() + " is thinking.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
