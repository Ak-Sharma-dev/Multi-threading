import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

class CellPhone implements Runnable {

    private String name;

    private static Semaphore charger = new Semaphore(4);

    public CellPhone(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            charger.acquire();
            System.out.println(name + " is charging");
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name + " is done charging");
            charger.release();
        }
    }
}


public class SemaphoreExample {
    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            CellPhone runnable = new CellPhone("Phone-" + i);
            new Thread(runnable).start();
        }
    }
}
