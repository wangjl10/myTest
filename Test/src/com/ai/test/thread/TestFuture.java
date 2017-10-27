package com.ai.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFuture {
	
	public static void main(String[] args) {
		Task task = new Task();
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		Future<String> future = singleThreadExecutor.submit(task);
		singleThreadExecutor.shutdown();
		try {
			Thread.sleep(1000);
			if (future.get() != null) {
				System.out.println("========"+future.get());
			}else {
				System.out.println("返回为空");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	
}

class Task implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}
	
}

