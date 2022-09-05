package com.rf.khan.api.mt;

import java.util.concurrent.Semaphore;

public class SemaphoreT {
	public static void main(String[] args) throws InterruptedException {

		// creating a semaphore, so that at a time 3 thread can use critical resource
		Semaphore semaphore = new Semaphore(3);

		// If the Semaphore has 1 value is binary semaphore, semaphore > 1 then count
		// Semaphore

		Sema thread1 = new Sema(semaphore, "Thread 1 ");
		Sema thread2 = new Sema(semaphore, "Thread 2 ");
		Sema thread3 = new Sema(semaphore, "Thread 3 ");
		Sema thread4 = new Sema(semaphore, "Thread 4 ");
		Sema thread5 = new Sema(semaphore, "Thread 5 ");

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();

		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		thread5.join();

	}

}

/**
 * Thread class
 * 
 * @author mkhan339
 *
 */
class Sema extends Thread {
	Semaphore semaphore;
	String threadName;

	public Sema(Semaphore semaphore, String threadName) {
		this.semaphore = semaphore;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		try {

			this.task();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is a shared resource accessing by the multiple thread
	 * 
	 * @throws InterruptedException
	 */
	public void task() throws InterruptedException {
		semaphore.acquire();

		for (int i = 1; i <= 10; i++) {
			System.out.println(threadName + " is working " + i);
			Thread.sleep(1000);
		}

		semaphore.release();
	}

}