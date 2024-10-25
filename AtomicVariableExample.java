import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableExample {

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new AtomicVariableThread());
        Thread B = new Thread(new AtomicVariableThread());
        A.start();
        B.start();
        A.join();
        B.join();
        System.out.println("The count is: "+ AtomicVariableThread.atomicCount);
    }

    public static class AtomicVariableThread implements Runnable {

        public static AtomicInteger atomicCount = new AtomicInteger();

        @Override
        public void run() {
            for(int i=0; i<10_00_000; i++) {
                atomicCount.incrementAndGet();
            }
        }
    }

}
