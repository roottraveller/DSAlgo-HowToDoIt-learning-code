import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // Create a CyclicBarrier with a count of 3
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("All threads have reached the barrier"));

        // Create and start three worker threads
        WorkerThread worker1 = new WorkerThread("Worker 1", barrier);
        WorkerThread worker2 = new WorkerThread("Worker 2", barrier);
        WorkerThread worker3 = new WorkerThread("Worker 3", barrier);

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

    static class WorkerThread extends Thread {
        private final CyclicBarrier barrier;

        public WorkerThread(String name, CyclicBarrier barrier) {
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
