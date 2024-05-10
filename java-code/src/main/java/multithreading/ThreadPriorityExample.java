import java.lang.Thread;

/* Thread Priority 
  We can use the setPriority(int priority) method to set the priority of a thread. 
      public static final int MIN_PRIORITY = 1;
      public static final int NORM_PRIORITY = 5;
      public static final int MAX_PRIORITY = 10;
*/

public class ThreadPriorityExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable(), "Thread 1");
        Thread thread2 = new Thread(new MyRunnable(), "Thread 2");
        
        // Set higher priority for Thread 1
        thread1.setPriority(Thread.MAX_PRIORITY);
        
        // Start the threads
        thread1.start();
        thread2.start();
    }
    
    static class MyRunnable implements Runnable {
      
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    // Introduce some delay to simulate work
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
