package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
 * A CyclicBarrier in Java is a synchronization aid that allows a set of threads to wait for each other 
 * at a predefined barrier point before continuing execution. It's called "cyclic" because it can be reused 
 * after the waiting threads are released, unlike other synchronization constructs like CountDownLatch.
 * 
 */

/*
 * CyclicBarrier Class Main Methods:
 * 
 * CyclicBarrier:
 *      ├── await()
 *      ├── await(long timeout, TimeUnit unit)
 *      ├── reset()
 *      ├── getParties()
 *      ├── isBroken()
 *      └── getNumberWaiting()
 */


public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // Create a CyclicBarrier with a count of 3
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("All threads have reached the barrier"));

        // Create and start three worker threads
        Thread worker1 = new Thread(new WorkerRunnable("Worker 1", barrier));
        Thread worker2 = new Thread(new WorkerRunnable("Worker 2", barrier));
        Thread worker3 = new Thread(new WorkerRunnable("Worker 3", barrier));

        worker1.start();
        worker2.start();
        worker3.start();

        try {
            // should not be reset until after all threads have crossed the barrier.
            // Wait for all threads to finish
            worker1.join();
            worker2.join();
            worker3.join();

            // Reset the barrier for reuse
            barrier.reset();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class WorkerRunnable implements Runnable {
        private final CyclicBarrier barrier;

        public WorkerRunnable(String name, CyclicBarrier barrier) {
            super(name);
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " is performing its task...");
                Thread.sleep((long) (Math.random() * 1000)); // Simulate task execution time
                System.out.println(Thread.currentThread().getName() + " has reached the barrier");
                barrier.await(); // Wait at the barrier
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier and proceeding");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
