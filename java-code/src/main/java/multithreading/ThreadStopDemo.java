package multithreading;

import java.util.concurrent.TimeUnit;

// This code demonstrates how to stop a thread gracefully in Java.
public class ThreadStopDemo {
    public static void main(String[] args) throws InterruptedException {
        ServerThread stObj = new ServerThread();
        Thread td = new Thread(stObj, "Server Thread");
        td.start();

        System.out.println(Thread.currentThread().getName() + " calling stop() on Server Thread");
        TimeUnit.MILLISECONDS.sleep(10); // Let's wait in milliseconds and see server thread stopped
        stObj.stopThread(); // Call the method to stop the thread
    }
}

class ServerThread implements Runnable {
    private volatile boolean isExit = false;

    @Override
    public void run() {
        while (!isExit) {
            System.out.println(Thread.currentThread().getName() + " running...");
        }

        System.out.println(Thread.currentThread().getName() + " stopped.");
    }

    // Method to stop the thread
    public void stopThread() {
        this.isExit = true;
    }
}
