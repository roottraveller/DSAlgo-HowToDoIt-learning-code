//Output: T1, T2, T3, T1, T2, T3, T1, T2, T3, T1, T2, T3...
public class ThreadPrintInLoop {

    public static void main(String[] args) {
        new ThreadPrintInLoop().test();
    }

    private void test() {
        Dummy dummy = new Dummy(10);
        Thread thread1 = new Thread(dummy, "T1");
        Thread thread2 = new Thread(dummy, "T2");
        Thread thread3 = new Thread(dummy, "T3");
        Thread thread4 = new Thread(dummy, "T4");

        // Start threads (thread.start() can only be called once)
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    class Dummy implements Runnable {
        private final Object lock = new Object();
        private int count = 0;
        private final int maxCount;

        public Dummy(int maxCount) {
            this.maxCount = maxCount;
        }

        @Override
        public void run() {
//            System.out.println(Thread.currentThread().getName());
            while (count < maxCount) {
                synchronized (lock) {
                    try {
                        // wait all other threads which is not equal to count
                        while (count % 4 != Integer.parseInt(Thread.currentThread().getName().substring(1)) - 1) {
                            // Wait for the turn of this thread
                            lock.wait();
                        }
                        // Allow thread with count equal name postfix to critical section
                        // do something
                        Thread.sleep(1000); // 1sec
                        System.out.println(Thread.currentThread().getName() + ", ");
                        ++count;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        // Notify the waiting thread to proceed
                        lock.notifyAll();
                    }
                }
            }
        }
    }
}
