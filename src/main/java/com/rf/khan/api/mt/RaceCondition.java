package com.rf.khan.api.mt;

public class RaceCondition {
	int count = 0;

	public synchronized void task() {
		for (int i = 0; i < 100000; i++)
			count += 1;
		System.out.println(Thread.currentThread().getName() + " " + count);
	}

	void print() {
		System.out.println(count);
	}

	/**
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		RaceCondition inconsistent = new RaceCondition();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				inconsistent.task();
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				inconsistent.task();
			}
		};

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		inconsistent.print();
	}
}
