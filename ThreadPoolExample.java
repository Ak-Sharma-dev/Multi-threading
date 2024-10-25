import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadPool implements Runnable {

    private final String name;

    public ThreadPool(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " is executing.");
    }
}

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);
        for(int i=0; i<100; i++) {
            service.submit(new ThreadPool("Thread " + i));
        }
        service.shutdown();
    }
}
