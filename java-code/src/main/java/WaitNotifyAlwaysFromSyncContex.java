import java.io.*;
import java.lang.*;
import java.util.*;

public class WaitNotifyAlwaysFromSyncContex {
	public static void main(String[] args) {
		Thread threadA = new Thread (new ThreadA());
		Thread threadB = new Thread (new ThreadB());
		
		threadA.start();
		threadB.start();
		
		synchronized(threadB) { //NOTE HERE
			try {
				System.out.println(Thread.currentThread().getName() + " Wait() Called. Waiting for threadB to complete.");
				threadB.wait(); //AND HERE TOO
			} catch (InterruptedException e) {
				System.out.println("Exception thrown " + Thread.currentThread().getName() + "  ");
				e.printStackTrace();
			} finally {
				System.out.println("Wait() ended.");
			}
		}
	}
}
class ThreadA implements Runnable {
	@Override
	public void run() {
		//stuff 
		synchronized(this) { 
			for(int i=0; i<999; ++i) {
				//do nothing just waste time
				System.out.println(Thread.currentThread().getName() + " Running...");
			}
			notifyAll();
		}
	}
}

class ThreadB implements Runnable {
	@Override
	public void run() {
		//stuff 
		synchronized(this) { 
			for(int i=0; i<999; ++i) {
				//do nothing just waste time
				System.out.println(Thread.currentThread().getName() + " Running...");
			}
			notifyAll();
		}
	}
}
