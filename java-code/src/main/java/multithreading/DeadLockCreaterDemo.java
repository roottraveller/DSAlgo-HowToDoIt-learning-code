package multithreading;/*
 * Deadlock Scenario:
 * 
 * Thread 1 locks Resource A and waits to lock Resource B.
 * Thread 2 locks Resource B and waits to lock Resource A.
 * 
 * This situation creates a cyclic dependency where each thread is waiting for the other to release 
 * a lock, resulting in a deadlock.
 */


public class DeadLockCreaterDemo {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new TaskARunnable("Thread-1", resource1, resource2));
        Thread thread2 = new Thread(new TaskBRunnable("Thread-2", resource1, resource2));

        thread1.start();
        thread2.start();
    }

    static class TaskARunnable implements Runnable {
        private final Object resource1;
        private final Object resource2;

        TaskARunnable(String name, Object resource1, Object resource2) {
            super(name);
            this.resource1 = resource1;
            this.resource2 = resource2;
        }

        @Override
        public void run() {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " acquired resource1");

                // Simulate some processing time
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " is waiting to acquire resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " acquired resource2");
                }
            }
        }
    }

    static class TaskBRunnable implements Runnable {
        private final Object resource1;
        private final Object resource2;

        TaskBRunnable(String name, Object resource1, Object resource2) {
            super(name);
            this.resource1 = resource1;
            this.resource2 = resource2;
        }

        @Override
        public void run() {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " acquired resource2");

                // Simulate some processing time
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " is waiting to acquire resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " acquired resource1");
                }
            }
        }
    }
}
