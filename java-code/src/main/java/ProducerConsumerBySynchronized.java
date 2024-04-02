import java.util.*;

public class ProducerConsumerBySynchronized {
	public static void main(String[] args) throws Exception {
		Queue<Integer> queue = new LinkedList<>();
		int bufferSize = 20; // Buffer size

		Producer producerThread = new Producer(queue, bufferSize, "PRODUCER");
		Consumer consumerThread = new Consumer(queue, "CONSUMER");

		producerThread.start();
		consumerThread.start();
	}

	static class Producer extends Thread {
		private Queue<Integer> queue;
		private int bufferSize;

		public Producer(Queue<Integer> queue, int bufferSize, String threadName) {
			super(threadName);
			this.queue = queue;
			this.bufferSize = bufferSize;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					while (queue.size() == bufferSize) {
						try {
							System.out.println(Thread.currentThread().getName() + " -> Buffer FULL: waiting......");
							queue.wait();
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}

					int randomInt = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() + " -> Buffer ADDED: " + randomInt);
					queue.add(randomInt);
					queue.notifyAll();
				}
			}
		}
	}

	static class Consumer extends Thread {
		private Queue<Integer> queue;

		public Consumer(Queue<Integer> queue, String threadName) {
			super(threadName);
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							System.out.println(Thread.currentThread().getName() + " -> Buffer EMPTY: waiting......");
							queue.wait();
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}

					System.out.println(Thread.currentThread().getName() + " -> Buffer REMOVE: " + queue.remove());
					queue.notifyAll();
				}
			}
		}
	}
}
