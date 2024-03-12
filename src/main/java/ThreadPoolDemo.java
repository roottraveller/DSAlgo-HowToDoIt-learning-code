import java.util.concurrent.*;

//@author : roottraveller , 24 Sept 2017
//http://javarevisited.blogspot.in/2013/07/how-to-create-thread-pools-in-java-executors-framework-example-tutorial.html
//http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/util/concurrent/Executors.java


class ThreadPoolDemo {
	private static final int THREAD_COUNT = 10;  //10 thread in Thread Pool
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);
		//Other methods = Executors.newSingleThreadExecutor(), Executors.newCachedThreadPool()
		
		// submit obj to Thread pool for execution
		for(int i=1; i<=100; ++i) {
			service.submit(new MyThreadClass(i));
		}
		
		System.out.println("\n\nFor() loop terminated. Now terminating - " + Thread.currentThread().getName());
	}
}

class MyThreadClass implements Runnable {
	private int id;
	
	MyThreadClass(int idIn) {
		this.id = idIn;
	}
	
	@Override
	public void run() {
		//stuff 
		System.out.println("Current Thread = " + Thread.currentThread().getName() + ", MyThreadClass.id = " + this.id);
	}
}
