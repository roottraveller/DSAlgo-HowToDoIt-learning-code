package multithreading;

/*
* This will print output in the random order. This is because threads are not synchronized with each other.
* To ensure that the output is in the correct sequence (even numbers followed by odd numbers), you should
* synchronize the threads themselves. You can achieve this by either synchronizing the run method or by
* using a shared lock object.
*
* Check EvenOddWithTwoThreadOrdered for this.
* */
public class EvenOddWithTwoThreadRandom {

    static class EvenPrinter implements Runnable {
        private final int limit;
        private int number = 0;

        public EvenPrinter(int limit) {
            this.limit = limit;
        }

        @Override
        public void run() {
            while (number < limit) {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number += 2;
                }
            }
        }
    }

    static class OddPrinter implements Runnable {
        private final int limit;
        private int number = 1;

        public OddPrinter(int limit) {
            this.limit = limit;
        }

        @Override
        public void run() {
            while (number < limit) {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number += 2;
                }
            }
        }
    }

    public static void main(String[] args) {
        EvenPrinter evenPrinter = new EvenPrinter(100);
        OddPrinter oddPrinter = new OddPrinter(100);

        Thread t1 = new Thread(evenPrinter, "EvenThread");
        Thread t2 = new Thread(oddPrinter, "OddThread");

        t1.start();
        t2.start();
    }

}
