package com.rf.khan.api.thread;

public class Thread1 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println("Thread1 : " + Thread.currentThread() + " " + i);
		}
	}
}
