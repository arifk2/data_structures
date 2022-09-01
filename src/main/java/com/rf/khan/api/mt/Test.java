package com.rf.khan.api.mt;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					try {
						Thread.sleep(1);
						System.out.println(Thread.currentThread().getName() + " " + i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Thread t2 = new Thread() {

			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					try {
						Thread.sleep(1);
						System.out.println(Thread.currentThread().getName() + " " + i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}
