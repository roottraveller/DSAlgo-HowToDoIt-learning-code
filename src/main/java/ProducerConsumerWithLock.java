import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock; 
import java.util.concurrent.locks.ReentrantLock;

// @author : rootTraveller, June 2017

class ProducerConsumerWithLock {
	public static void main(String[] args) throws Exception {
		ProducerConsumerImpl sharedObj = new ProducerConsumerImpl();
		
		Producer producer = new Producer(sharedObj, "PRODUCER");
		Consumer consumer = new Consumer(sharedObj, "CONSUMER");
		
		producer.start();
		consumer.start();
	}
}



class Producer extends Thread {
	ProducerConsumerImpl pc = null;
	
	Producer(ProducerConsumerImpl sharedObjIn, String threadName){
		super(threadName);
		this.pc = sharedObjIn;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				pc.put();  //Produce 
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread {
	ProducerConsumerImpl  pc = null;
	
	Consumer(ProducerConsumerImpl sharedObjIn, String threadName) {
		super(threadName);
		this.pc = sharedObjIn;
	}
	
	@Override
	public void run(){
		while (true) {
			try{
				pc.get();   //Consume
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}



class ProducerConsumerImpl {
	private Queue<Integer> queue = new LinkedList<>();
	private static final int queueSize = 10;  //Important, change as per need.
	
	private final Lock mylock = new ReentrantLock();    //Important, this part is for lock related stuff
	private final Condition bufferNotFull  = mylock.newCondition();
	private final Condition bufferNotEmpty = mylock.newCondition(); 
	
	public void put() throws InterruptedException {
		mylock.lock();
		try {
			while (queue.size() == queueSize) {
				System.out.println(Thread.currentThread().getName() + " -> Buffer  FULL    :  waiting......");
				bufferNotEmpty.await();
			}
			
			int randomInt = new Random().nextInt();
			System.out.println(Thread.currentThread().getName() + " -> Buffer  ADDED   : " + randomInt); 
			queue.offer(randomInt);
			bufferNotFull.signalAll();
		} finally {
			mylock.unlock();
		}
	}
	
	public void get() throws InterruptedException {
		mylock.lock();
		try {
			while (queue.isEmpty()) {
				System.out.println(Thread.currentThread().getName() + " -> Buffer  EMPTY   :  waiting......");
				bufferNotFull.await();
			}
			
			System.out.println(Thread.currentThread().getName() + " -> Buffer  REMOVE  : " + queue.poll());
			bufferNotEmpty.signalAll();
		} finally {
			mylock.unlock();
		}
	}
}
