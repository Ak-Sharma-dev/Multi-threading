import java.util.concurrent.*;

class FutureTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(5000);
        return 10;
    }
}

public class FutureExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        System.out.println("Calling callable to get value");
        Future<Integer> future = service.submit(new FutureTask());
        // We can perform other tasks future will get the value once is received from callable asynchronously
        System.out.println("Waiting for callable to get value");
        try {
            System.out.println("The value is " + future.get());
            service.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
