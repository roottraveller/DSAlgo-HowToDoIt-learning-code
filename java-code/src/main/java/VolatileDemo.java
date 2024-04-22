
/*
 * The 'volatile' keyword in Java ensures that changes made to a variable are immediately visible to other threads.
 * It prevents the compiler or runtime environment from caching the variable's value locally, ensuring that updates
 * are immediately visible across threads. This is particularly useful for variables that are accessed and modified
 * by multiple threads concurrently.
 *
 * Additionally, volatile variables are stored in main memory (RAM) instead of thread-local memory, ensuring that 
 * their values are always up-to-date and visible to all threads.
 */

public class VolatileDemo extends Thread {
    volatile boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo demo = new VolatileDemo();
        demo.start();
        Thread.sleep(1000);
        demo.isRunning = false;
        System.out.println("isRunning set to false.");
    }

    @Override
    public void run() {
        long counter = 0;
        while (isRunning) {
            System.out.println("Count: " + ++counter);
        }

        System.out.println("Thread terminated. Count: " + counter);
    }
}
