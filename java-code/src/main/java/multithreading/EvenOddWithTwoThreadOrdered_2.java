package multithreading;

public class EvenOddWithTwoThreadOrdered_2 {

    static class NumberPrinter {
        private static int limit;
        private volatile int number = 1;
        private final Object lock;

        public NumberPrinter(int limit) {
            NumberPrinter.limit = limit;
            this.lock = new Object();
        }

        private void printEven() {
            while (number < limit) {
                synchronized (lock) {
                    // wait if odd number
                    while (number % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    ++number;
                    lock.notifyAll();
                }
            }
        }

        private void printOdd() {
            while (number < limit) {
                synchronized (lock) {
                    // wait if even number
                    while (number % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    ++number;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter(100);
        Thread t1 = new Thread(printer::printEven, "EvenThread");
        Thread t2 = new Thread(printer::printOdd, "OddThread");

        t1.start();
        t2.start();
    }

}
