package multithreading;

/*
 * This will print output in monotonically increasing order.
 * 
 * When a thread calls lock.wait(), it releases the lock associated with the object lock and enters the waiting state. 
 * It will remain in the waiting state until another thread calls lock.notify() or lock.notifyAll() on the same object, 
 * which notifies the waiting thread and allows it to wake up and try to reacquire the lock.
 * */
public class EvenOddWithTwoThreadOrdered {

    static class EvenPrinter implements Runnable {
        private final int limit;
        private int number = 0;
        private final Object lock;

        public EvenPrinter(int limit, Object lock) {
            this.limit = limit;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (number < limit) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number += 2;
                    lock.notifyAll(); // Notify the other thread
                    try {
                        if (number < limit) {
                            lock.wait(); // Wait for the other thread to finish printing
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class OddPrinter implements Runnable {
        private final int limit;
        private int number = 1;
        private final Object lock;

        public OddPrinter(int limit, Object lock) {
            this.limit = limit;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (number < limit) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number += 2;
                    lock.notifyAll();// Notify the other thread
                    try {
                        if (number < limit) {
                            lock.wait(); // Wait for the other thread to finish printing
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        EvenPrinter evenPrinter = new EvenPrinter(100, lock);
        OddPrinter oddPrinter = new OddPrinter(100, lock);

        Thread t1 = new Thread(evenPrinter, "EvenThread");
        Thread t2 = new Thread(oddPrinter, "OddThread");

        t1.start();
        t2.start();
    }

}
