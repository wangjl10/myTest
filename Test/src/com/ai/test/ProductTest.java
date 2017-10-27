package com.ai.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductTest {
	
	public static void main(String[] args) {
		
		Clerk clerk = new Clerk();
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(new Producter(clerk));
		executorService.submit(new Consumer(clerk));
		executorService.shutdown();
	
	}

}


class Clerk {
	
	//最多产品数量
	private static final int MAX_PRODUCT = 20;
	
	//最少产品数量
	private static final int MIN_PRODUCT = 0;
	
	//默认产品数量
	private int product = 0;
	
	
	/**
	 * 生产产品
	 */
	public synchronized void addProduct(){
		
		if (this.product >= MAX_PRODUCT) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		this.product ++;
		System.out.println("生产者生产第" + this.product + "个产品");
		notifyAll();
		
	}
	
	
	/**
	 * 消费产品
	 */
	public synchronized void getProduct(){
		
		if (this.product < MIN_PRODUCT + 1) {
			try {
				wait();
				System.out.println("缺货！稍后再取！");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		System.out.println("消费者取走了第" + this.product + "个产品");
		this.product--;
		notifyAll();
		
	}
	
}


/**
 * 生产者
 * Copyright: Copyright (c) 2017 Asiainfo
 * @ClassName ProductTest.java
 * @Description
 *
 * @version: V1.0.0
 * @author wangjll0
 * @date 2017年3月12日
 * Producter
 */
class Producter implements Runnable {

	private Clerk clerk;
	
	public Producter(Clerk clerk) {
		super();
		this.clerk = clerk;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("生产者开始生产产品！");
		while(true){
			try {
				Thread.sleep((int)(Math.random() * 10) * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			clerk.addProduct();
		}
		
	}
	
}


/**
 * 消费者
 * Copyright: Copyright (c) 2017 Asiainfo
 * @ClassName ProductTest.java
 * @Description
 *
 * @version: V1.0.0
 * @author wangjll0
 * @date 2017年3月12日
 * Consumer
 */
class Consumer implements Runnable {
	
	private Clerk clerk;

	public Consumer(Clerk clerk) {
		super();
		this.clerk = clerk;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("消费者开始消费产品！");
		
		while (true) {
			
			try {
				Thread.sleep((int)(Math.random() * 10) * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			clerk.getProduct();
			
		}
		
	}
	
}





















