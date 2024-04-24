import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Executor Framework Hierarchy:
 * 
 * java.util.concurrent.Executor
 *             |
 *    __________|________________
 *   |                            |
 *   |             (I) ExecutorService
 *   |                    |
 *   |      ______________|________________
 *   |     |                              |
 *   |     |                              |
 * (C) ThreadPoolExecutor     (I) ScheduledExecutorService
 *                                  |
 *                     _____________|_____________________
 *                    |                                   |
 *       (C) ThreadPoolExecutor       (C) ScheduledThreadPoolExecutor
 */

/*
 * Executors
 *     ├── newCachedThreadPool
 *     ├── newFixedThreadPool
 *     │       └── newSingleThreadExecutor
 *     ├── newScheduledThreadPool
 *     └── newWorkStealingPool
 */

public class ThreadPoolDemo {
    private static final int THREAD_COUNT = 10;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 1; i <= 100; ++i) {
            service.submit(new MyThreadClass(i));
        }

        // Shutdown the executor when all tasks are completed
        service.shutdown();
        System.out.println("\n\nFor loop terminated. Now terminating - " + Thread.currentThread().getName());
    }
}

class MyThreadClass implements Runnable {
    private int id;

    MyThreadClass(int idIn) {
        this.id = idIn;
    }

    @Override
    public void run() {
        // Simulate some task
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Current Thread = " + Thread.currentThread().getName() + ", MyThreadClass.id = " + this.id);
    }
}
