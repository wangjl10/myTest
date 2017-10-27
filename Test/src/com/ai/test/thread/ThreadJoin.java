package com.ai.test.thread;

public class ThreadJoin {
			
		public static void main(String[] args) throws InterruptedException {
			
			for (int i = 0; i < 10; i++) {
				Thread thread1 = new Thread(new ThreadTest1());
				Thread thread2 = new Thread(new ThreadTest2());
				Thread thread3 = new Thread(new ThreadTest3());
				thread1.start();
				thread1.join();
				thread2.start();
				thread2.join();
				thread3.start();
				thread3.join();
			}
			
		}
	
}

class ThreadTest1 implements Runnable{
	public void run() {
		System.out.print(1);
	}
}

class ThreadTest2 implements Runnable{
	public void run() {
		System.out.print(2);
	}
}

class ThreadTest3 implements Runnable{
	public void run() {
		System.out.print(3);
	}
}