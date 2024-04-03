import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLock {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();
        int bufferSize = 20; // Buffer size

        Lock lock = new ReentrantLock();
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();

        Producer producerThread = new Producer(queue, bufferSize, "PRODUCER", lock, notFull, notEmpty);
        Consumer consumerThread = new Consumer(queue, "CONSUMER", lock, notFull, notEmpty);

        producerThread.start();
        consumerThread.start();
    }

    static class Producer extends Thread {
        private Queue<Integer> queue;
        private int bufferSize;
        private Lock lock;
        private Condition notFull;
        private Condition notEmpty;

        public Producer(Queue<Integer> queue, int bufferSize, String threadName, Lock lock, Condition notFull, Condition notEmpty) {
            super(threadName);
            this.queue = queue;
            this.bufferSize = bufferSize;
            this.lock = lock;
            this.notFull = notFull;
            this.notEmpty = notEmpty;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == bufferSize) {
                        System.out.println(Thread.currentThread().getName() + " -> Buffer FULL: waiting......");
                        notFull.await();
                    }

                    int randomInt = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " -> Buffer ADDED: " + randomInt);
                    queue.add(randomInt);
                    notEmpty.signalAll();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer extends Thread {
        private Queue<Integer> queue;
        private Lock lock;
        private Condition notFull;
        private Condition notEmpty;

        public Consumer(Queue<Integer> queue, String threadName, Lock lock, Condition notFull, Condition notEmpty) {
            super(threadName);
            this.queue = queue;
            this.lock = lock;
            this.notFull = notFull;
            this.notEmpty = notEmpty;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.isEmpty()) {
                        System.out.println(Thread.currentThread().getName() + " -> Buffer EMPTY: waiting......");
                        notEmpty.await();
                    }

                    System.out.println(Thread.currentThread().getName() + " -> Buffer REMOVE: " + queue.remove());
                    notFull.signalAll();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
