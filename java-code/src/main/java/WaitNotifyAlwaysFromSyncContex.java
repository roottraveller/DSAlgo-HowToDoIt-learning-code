/**
 * In Java, the wait() and notifyAll() methods are used for inter-thread communication and synchronization. 
 * They are typically called from within a synchronized block or method to ensure proper thread coordination 
 * and mutual exclusion. Here's why they are commonly used from within synchronized blocks:
 * 
 * - Mutual Exclusion: Ensures that only one thread can execute synchronized code on the object at a time.
 * - Preventing IllegalMonitorStateException: Guarantees that the thread owns the lock before performing wait() or notifyAll().
 * - Ensuring Correct Thread State Changes: Allows atomic condition checks and wait operations to prevent race conditions.
 * - Coordinated Synchronization: Ensures effective communication and mutual exclusion among threads synchronized on the same object.
 */

/* 
 * Object class
 *     ├── wait()
 *     ├── notify()
 *     └── notifyAll()
 */

public class WaitNotifyAlwaysFromSyncContex {
    public static void main(String[] args) {
        Thread threadA = new Thread(new ThreadA());
        Thread threadB = new Thread(new ThreadB());

        threadA.start();
        threadB.start();

        synchronized (threadB) { //IMP: NOTE HERE
            try {
                System.out.println(Thread.currentThread().getName() + " Wait() Called. Waiting for threadB to complete.");
                threadB.wait(); //IMP: NOTE HERE,  Wait for threadB to complete
            } catch (InterruptedException e) {
                System.out.println("Exception thrown " + Thread.currentThread().getName() + "  ");
                e.printStackTrace();
            } finally {
                System.out.println("Wait() ended.");
            }
        }
    }
}

class ThreadA implements Runnable {
    @Override
    public void run() {
        //stuff
        synchronized (this) {
            for (int i = 0; i < 99; ++i) {
                //do nothing just waste time
                System.out.println(Thread.currentThread().getName() + " Running...");
            }
            notifyAll();
        }
    }
}

class ThreadB implements Runnable {
    @Override
    public void run() {
        //stuff
        synchronized (this) {
            for (int i = 0; i < 99; ++i) {
                //do nothing just waste time
                System.out.println(Thread.currentThread().getName() + " Running...");
            }
            notifyAll();
        }
    }
}
