package com.ai.test;

import java.util.Timer;
import java.util.TimerTask;

public class Reminder {

	Timer timer;
	
	
	class ReminderTask extends TimerTask {

		@Override
		public void run() {
			System.out.println("Time's up!");
			timer.cancel();
		}
		
	}


	public Reminder(int seconds) {
		super();
		this.timer = new Timer();
		timer.schedule(new ReminderTask(), seconds * 1000);
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("==========");
		new Reminder(2);
		System.out.println("==========");
		
	}
	
	
	
	
	
	
	
}
