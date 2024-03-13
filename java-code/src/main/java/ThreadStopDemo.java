import java.util.*;
import java.lang.Thread.*;
import java.util.concurrent.TimeUnit;


// author @ roottraveller
// oct 2017

class ThreadStopDemo {
	public static void main(String[] args) throws InterruptedException {
		ServerThread stObj = new ServerThread();
		Thread td = new Thread(stObj, "Server Thread");
		td.start();
		
		System.out.println(Thread.currentThread().getName() + "  calling stop() on Server Thread");
		TimeUnit.MILLISECONDS.sleep(10); 		//Let's wait in miliseconds and see server thread stopped 
		stObj.stop();  // !important = notice obj of ServerThread class, same object should be
	}
}

class ServerThread implements Runnable {
	private volatile boolean isExit = false;
	
	@Override
	public void run() {
		while(isExit == false) {
			System.out.println(Thread.currentThread().getName()  + "  running...");
		}
		
		System.out.println(Thread.currentThread().getName()  + "  stoped.");
	}
	
	public void stop() {
		this.isExit = true;
	}
}
