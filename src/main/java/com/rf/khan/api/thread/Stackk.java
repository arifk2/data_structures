package com.rf.khan.api.thread;

public class Stackk {
	int[] arr;
	int stackTop;

	public Stackk(int capacity) {
		this.arr = new int[capacity];
		stackTop = -1;
	}

	public boolean isFull() {
		return stackTop >= arr.length - 1;
	}

	public boolean isEmpty() {
		return stackTop < 0;
	}

	public synchronized boolean push(int element) {
		if (isFull())
			return false;
		++stackTop;
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		arr[stackTop] = element;
		return true;
	}

	public synchronized int pop() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		int obj = arr[stackTop];
		arr[stackTop] = Integer.MIN_VALUE;
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		stackTop--;
		return obj;
	}

	public static void main(String[] args) {
		Stackk stackk = new Stackk(5);
		System.out.println("Main Thread starting");
		new Thread(() -> {
			int counter = 0;
			while (++counter < 10) {
				System.out.println("Pushed: " + stackk.push(100));
			}
		}, "Thread-1").start();

		new Thread(() -> {
			int counter = 0;
			while (++counter < 10) {
				System.out.println("Poped: " + stackk.pop());
			}
		}, "Thread-2").start();
		System.out.println("Main Thread in exiting");
	}
}
