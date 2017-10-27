package com.ai.test;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * Copyright: Copyright (c) 2017 Asiainfo
 * 
 * @ClassName CyclicBarrierTest.java
 * @Description
 *
 * @version: V1.0.0
 * @author wangjl10
 * @date 2017年3月12日 CyclicBarrierTest
 * 
 * 
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {

		CyclicBarrier barrier = new CyclicBarrier(3);
		ExecutorService executor = Executors.newFixedThreadPool(3);

		executor.submit(new Thread(new Runner("1号", barrier)));
		executor.submit(new Thread(new Runner("2号", barrier)));
		executor.submit(new Thread(new Runner("3号", barrier)));
		executor.shutdown();

	}

}

class Runner implements Runnable {

	private CyclicBarrier barrier;

	private String name;

	public Runner(String name, CyclicBarrier barrier) {
		super();
		this.name = name;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000 * (new Random().nextInt(8)));
			System.out.println(name + "准备好了！");
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("起跑！");
	}

}
