
public class Multithreading {

    public static void main(String[] args) {
        Thread t1 = new Thread(new B(), "t1");
        Thread t2 = new Thread(new B(), "t2");
        System.out.println("Starting Runnable threads");
        t1.start();
        t2.start();
        System.out.println("Class B Threads has been started");
        Thread t3 = new A("t3");
        Thread t4 = new A("t4");
        System.out.println("Starting Thread class");
        t3.start();
        t4.start();
        System.out.println("Class A has been started");
    }

    // 1st way to create thread by extending the Thread class
    static class A extends Thread {

        public A(String name) {
            super(name);
        }

        public void run() {
            System.out.println("MyThread - START "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                //Get database connection, delete unused data from DB
                doDBProcessing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyThread - END "+Thread.currentThread().getName());
        }

        private void doDBProcessing() throws InterruptedException {
            Thread.sleep(5000);
        }
    }

    // 2nd way to create thread by implementing the runnable interface
    static class B implements Runnable {

        @Override
        public void run() {
            System.out.println("MyThread - START "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                //Get database connection, delete unused data from DB
                doDBProcessing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyThread - END "+Thread.currentThread().getName());
        }

        private void doDBProcessing() throws InterruptedException {
            Thread.sleep(5000);
        }
    }

}
