import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    // Shared counter
    private static int counter = 0;

    public static void main(String[] args) {
        // Create a ReentrantLock instance
        Lock lock = new ReentrantLock();

        // Create and start three threads
        Thread thread1 = new Thread(new Worker(lock, "Thread 1"));
        Thread thread2 = new Thread(new Worker(lock, "Thread 2"));
        Thread thread3 = new Thread(new Worker(lock, "Thread 3"));
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final counter value
        System.out.println("Final counter value: " + counter);
    }

    static class Worker implements Runnable {
        private Lock lock;
        private String name;

        public Worker(Lock lock, String name) {
            this.lock = lock;
            this.name = name;
        }

        @Override
        public void run() {
            // Acquire the lock
            lock.lock();
            try {
                // Critical section: access the shared resource (increment counter)
                System.out.println(name + " acquired the lock");
                counter++; // Increment the shared counter

                // Simulate some work
                Thread.sleep(1000);

                // Release the lock
                System.out.println(name + " releasing the lock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); // Ensure the lock is always released
            }
        }
    }
}
