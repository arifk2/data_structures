package com.rf.khan.api.thread;

public class ThreadTester {
	public static void main(String[] args) {
		/*
		 * System.out.println("Main Thread starting");
		 * 
		 * // Thread thread = new Thread1(); // thread.start(); Thread thread2 = new
		 * Thread(() -> { for (int i = 1; i <= 100; i++) {
		 * System.out.println("Thread1 : " + Thread.currentThread() + " " + i); } },
		 * "thread2"); thread2.setDaemon(true); thread2.start();
		 * System.out.println("Main Thread exiting");
		 */

		System.out.println("Main Thread starting");
		Stack stack = new Stack(5);

		new Thread(() -> {
			int counter = 0;
			while (++counter < 10) {
				System.out.println("Pushed: " + stack.push(100));
			}

		}, "Thread-1").start();

		new Thread(() -> {
			int counter = 0;
			while (++counter < 10) {
				System.out.println("Pop: " + stack.pop());
			}
		}, "Thread-2").start();

		System.out.println("Main Thread exiting");
	}

}
