/**
 * Three philosophers, thinking and eating sushi
 */

import java.util.concurrent.locks.*;

class Philosopher extends Thread {

    private Lock firstChopstick, secondChopstick;
    private static int sushiCount = 500_000;

    public Philosopher(String name, Lock firstChopstick, Lock secondChopstick) {
        this.setName(name);
        this.firstChopstick = firstChopstick;
        this.secondChopstick = secondChopstick;
    }

    public void run() {
        while(sushiCount > 0) { // eat sushi until it's all gone

            // pick up chopsticks
            firstChopstick.lock();
            secondChopstick.lock();

//            // take a piece of sushi
//            if (sushiCount > 0) {
//                sushiCount--;
//                System.out.println(this.getName() + " took a piece! Sushi remaining: " + sushiCount);
//            }
//
//            // put down chopsticks
//            secondChopstick.unlock();
//            firstChopstick.unlock();

            // Here in case an exception occurs and thread is not able to complete we release the locks using finally in order to avoid deadlock
            try {
                if (sushiCount > 0) {
                    sushiCount--;
                    System.out.println(this.getName() + " took a piece! Sushi remaining: " + sushiCount);
                }

                if (sushiCount == 10) {
                    throw new RuntimeException("Exception Occurred at Sushi " + sushiCount);
                }
            } finally {
                // put down chopsticks
                secondChopstick.unlock();
                firstChopstick.unlock();
            }
        }
    }
}

public class DeadlockDemo {
    public static void main(String[] args) {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();
        new Philosopher("Barron", chopstickA, chopstickB).start();
        new Philosopher("Olivia", chopstickB, chopstickC).start();
        new Philosopher("Steve", chopstickA, chopstickC).start();
    }
}