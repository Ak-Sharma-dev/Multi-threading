public class JoinExample {
    public static void main(String[] args) {
        // Create two threads
        Thread thread1 = new Thread(new Worker("Thread 1"));
        Thread thread2 = new Thread(new Worker("Thread 2"));

        // Start both threads
        thread1.start();
        thread2.start();

        try {
            // Use join to make the main thread wait for thread1 to finish
            thread1.join();
            System.out.println("Thread 1 has finished.");

            // Use join again to make the main thread wait for thread2 to finish
            thread2.join();
            System.out.println("Thread 2 has finished.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread has finished.");
    }

    static class Worker implements Runnable {
        private String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " is starting.");
            try {
                // Simulate some work
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

