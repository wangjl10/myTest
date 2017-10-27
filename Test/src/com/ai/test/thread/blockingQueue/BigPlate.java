package com.ai.test.thread.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BigPlate {

	private BlockingQueue eggs = new ArrayBlockingQueue(5);

	public void putEgg(Object egg) {

		try {
			eggs.put(egg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("放入鸡蛋！");

	}

	public Object takeEgg() {

		Object egg = null;

		try {
			egg = eggs.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("取出鸡蛋！");
		return egg;

	}

	static class PutThread implements Runnable {
		private BigPlate bigPlate;

		public PutThread(BigPlate bigPlate) {
			this.bigPlate = bigPlate;
		}

		public void run() {
			Object egg = new Object();
			bigPlate.putEgg(egg);
		}
	}
	
	
	static class TakeThread implements Runnable {
		private BigPlate bigPlate;

		public TakeThread(BigPlate bigPlate) {
			this.bigPlate = bigPlate;
		}

		public void run() {
			bigPlate.takeEgg();
		}
	}
	
	public static void main(String[] args) {
		
		BigPlate bigPlate = new BigPlate();
		
		for (int i = 0; i < 10; i++) {
			new Thread(new PutThread(bigPlate)).start();
		}
		
		for (int i = 0; i < 10; i++) {
			new Thread(new TakeThread(bigPlate)).start();
		}
		
	}
	

}
