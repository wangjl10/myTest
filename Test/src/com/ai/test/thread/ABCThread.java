package com.ai.test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABCThread {

	private static Lock lock = new ReentrantLock();
	private static int state = 0;

	public static void main(String[] args) {

		new ThreadA().start();
		new ThreadB().start();
		new ThreadC().start();

	}

	static class ThreadA extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10;) {
				lock.lock();
				if (state % 3 == 0) {
					System.out.print("A");
					state++;
					i++;
				}
				lock.unlock();
			}
		}
	}

	static class ThreadB extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10;) {
				lock.lock();
				if (state % 3 == 1) {
					System.out.print("B");
					state++;
					i++;
				}
				lock.unlock();
			}
		}
	}

	static class ThreadC extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10;) {
				lock.lock();
				if (state % 3 == 2) {
					System.out.print("C");
					state++;
					i++;
				}
				lock.unlock();
			}
		}
	}

}
