import java.util.concurrent.*;

public class AllWaysToCreateThreads {

    // Way 1: Extending the Thread class
    static class MyThread extends Thread {
        public void run() {
            System.out.println("Thread created by extending Thread class");
        }
    }

    // Way 2: Implementing the Runnable interface
    static class MyRunnable implements Runnable {
        public void run() {
            System.out.println("Thread created by implementing Runnable interface");
        }
    }

    public static void main(String[] args) throws Exception {
        // Way 1: Creating and starting thread by extending Thread class
        MyThread thread1 = new MyThread();
        thread1.start();

        // Way 2: Creating and starting thread by implementing Runnable interface
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();

        // Way 3: Creating and starting thread using lambda expression
        Thread thread3 = new Thread(() -> {
            System.out.println("Thread created using lambda expression");
        });
        thread3.start();

        // Way 4: Using ExecutorService with Runnable
        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        executor1.submit(() -> {
            System.out.println("Thread created using ExecutorService with Runnable");
        });
        executor1.shutdown();

        // Way 5: Using ExecutorService with Callable
        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> {
            System.out.println("Thread created using ExecutorService with Callable");
            return "Result";
        };
        Future<String> future = executor2.submit(callable);
        String result = future.get();
        System.out.println("Result from Callable: " + result);
        executor2.shutdown();

        // Way 6: Using CompletableFuture
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Thread created using CompletableFuture");
        });
        completableFuture.get(); // Wait for completion
    }
}
