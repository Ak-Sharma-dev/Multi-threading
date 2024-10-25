public class SynchronizedMethodDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new SynchronizedThread());
        Thread B = new Thread(new SynchronizedThread());
        A.start();
        B.start();
        A.join();
        B.join();
        System.out.println("The count is: " + SynchronizedThread.count);
    }

    public static class SynchronizedThread implements Runnable {

        static int count = 0;

        // Here in incrementCount() method if I don't add static it will not work as thread will create their own instance of method and run the code and will have their own lock
        private static synchronized void incrementCount() {
            count++;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10_00_000; i++) {
//                incrementCount();
                // This will synchronize the block of code
                synchronized (SynchronizedThread.class) {
                    count++;
                }
            }
        }
    }

}
