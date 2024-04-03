public class DeadLockCreaterDemo implements Runnable {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadLockCreaterDemo deadLockCreater = new DeadLockCreaterDemo();
        Thread thread01 = new Thread(() -> deadLockCreater.run());
        Thread thread02 = new Thread(() -> deadLockCreater.run());

        thread01.start();
        thread02.start();
    }

    @Override
    public void run() {
        while (true) {
            method01();
            method02();
        }
    }

    public void method01() {
        synchronized (lock1) {
            System.out.println("method01 : Lock on lock1 " + Thread.currentThread().getName());
            synchronized (lock2) {
                System.out.println("method01 : Lock on lock2 " + Thread.currentThread().getName());
            }
        }
    }

    public void method02() {
        synchronized (lock2) {
            System.out.println("method02 : Lock on lock2 " + Thread.currentThread().getName());
            synchronized (lock1) {
                System.out.println("method02 : Lock on lock1 " + Thread.currentThread().getName());
            }
        }
    }
}
