package com.rf.khan.api.mt;

public class NotifyEx {
	public static void main(String[] args) {
		Thread2 objB = new Thread2();

		// starting the thread
		objB.start();

		synchronized (objB) {
			try {
				System.out.println("Waiting for the thread2 to complete");

				objB.wait();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Total is: " + objB.count);
		}

	}
}

class Thread2 extends Thread {
	int count;

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				count += i;
			}

			// waking up the thread in waiting state using notify method
			notify();
		}
	}
}
