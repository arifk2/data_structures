package com.rf.khan.api.mt;

import java.util.concurrent.Semaphore;

public class PrintOrderLC1114 {
	Semaphore run2, run3;

	public PrintOrderLC1114() {
		run2 = new Semaphore(0);
		run3 = new Semaphore(0);
	}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		run2.release();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		run2.acquire();
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		run3.release();
	}

	public void third(Runnable printThird) throws InterruptedException {
		run3.acquire();
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
}
