package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * If the queue is full, the put() operation in the Producer thread will block until there is space available.
 * The take() operation in the Consumer thread blocks if the queue is empty, waiting for items to become available.
 * 
 * BlockingQueue Main Concrete Implementation Classes:
 * 
 * (I) java.util.concurrent.BlockingQueue
 *     ├── (C) LinkedBlockingQueue
 *     ├── (C) ArrayBlockingQueue
 *     ├── (C) PriorityBlockingQueue
 *     └── (C) SynchronousQueue
 */


public class ProducerConsumerWithBlockingQueue {
    public static void main(String[] args) throws Exception {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(20); // Buffer size

        Thread producerThread = new Thread(new Producer(queue), "PRODUCER");
        Thread consumerThread = new Thread(new Consumer(queue), "CONSUMER");

        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {
        private BlockingQueue<Integer> queue;

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int randomInt = new java.util.Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " -> Buffer ADDED: " + randomInt);
                    queue.put(randomInt);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + " -> Buffer REMOVE: " + queue.take());
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
