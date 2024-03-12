import java.io.*

// @author : rootTraveller, June 2017

class DeadLockCreater implements Runnable {
	public static void main(String[] args) throws Exception {
		Thread thread01 = new Thread(new DeadLockCreater());
		Thread thread02 = new Thread(new DeadLockCreater());
		
		thread01.start();
		thread02.start();
	}
	
	@Override
	public void run() {
		while (true){
			this.method01();
			this.method02();
		}
	}
	
	public void method01(){
		synchronized (String.class) {
			System.out.println("method01 : Lock on  String.class " + Thread.currentThread().getName());
			
			synchronized (Integer.class) {
				System.out.println("method01 : Lock on  Integer.class " + Thread.currentThread().getName());
			}
		}
	}
	
	public void method02() {
		synchronized (Integer.class) {
			System.out.println("method02 : Lock on  Integer.class " + Thread.currentThread().getName());
			
			synchronized (String.class) {
				System.out.println("method02 : Lock on String.class " + Thread.currentThread().getName());
			}
		}
	}
}
