import java.util.*;

// @author : rootTraveller, June 2017

class ProducerConsumerBySynchronized {
	public static void main(String[] args) throws Exception {
		Queue<Integer> queue = new LinkedList<>();
		Integer buffer = new Integer(20);  //Important buffer or queue size, change as per need.
	
		Producer producerThread = new Producer(queue, buffer, "PRODUCER");
		Consumer consumerThread = new Consumer(queue, buffer, "CONSUMER");
		
		producerThread.start();  
		consumerThread.start();
	}
}



class Producer extends Thread {
	private Queue<Integer> queue;
	private int queueSize ;
	
	public Producer (Queue<Integer> queueIn, int queueSizeIn, String ThreadName){
		super(ThreadName);
		this.queue = queueIn;
		this.queueSize = queueSizeIn;
	}
	
	@Override
	public void run() {
		while(true){
			synchronized (queue) {
				while(queue.size() == queueSize){
					System.out.println(Thread.currentThread().getName() + " -> Buffer  FULL    : waiting......");
					try{
						queue.wait();   //Important
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				
				//queue empty then produce one, add and notify	
				int randomInt = new Random().nextInt(); 
				System.out.println(Thread.currentThread().getName() + " -> Buffer  ADDED   : " + randomInt); 
				queue.add(randomInt); 
				queue.notifyAll();  //Important
			} //synchronized ends here : NOTE
		}
	}
}



class Consumer extends Thread {
	private Queue<Integer> queue;
	private int queueSize;
	
	public Consumer(Queue<Integer> queueIn, int queueSizeIn, String ThreadName){
		super (ThreadName);
		this.queue = queueIn;
		this.queueSize = queueSizeIn;
	}
	
	 @Override
	public void run() {
		while(true){
			synchronized (queue) {
				while(queue.isEmpty()){
					System.out.println(Thread.currentThread().getName() + " -> Buffer  EMPTY   : waiting......");
					try {
						queue.wait();  //Important
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				
				//queue empty then consume one and notify
				System.out.println(Thread.currentThread().getName() + " -> Buffer  REMOVE  : " + queue.remove());
				queue.notifyAll();
			} //synchronized ends here : NOTICE
		}
	}
}
