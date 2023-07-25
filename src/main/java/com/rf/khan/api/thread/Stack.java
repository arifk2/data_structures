package com.rf.khan.api.thread;

/**
 * 
 * @author mkhan339
 *
 */
public class Stack {
	private int[] array;
	private int stackTop;

	public Stack(int capacity) {
		array = new int[capacity];
		stackTop = -1;
	}

	/**
	 * This method is created to push the element to stack
	 * 
	 * @param element holds the information of the element
	 * @return
	 */
	public boolean push(int element) {
		synchronized (this) {
			if (isFull())
				return false;
			++stackTop;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			array[stackTop] = element;
			return true;
		}

	}

	/**
	 * This method is created to pop element from the stack
	 * 
	 * @return
	 */
	public int pop() {
		synchronized (this) {
			if (isEmpty())
				return Integer.MIN_VALUE;
			int obj = array[stackTop];
			array[stackTop] = Integer.MIN_VALUE;

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			stackTop--;
			return obj;
		}
	}

	/**
	 * This method is created to tell stack is empty
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return stackTop < 0;
	}

	/**
	 * This method is created to tell stack is full
	 * 
	 * @return
	 */
	public boolean isFull() {
		return stackTop >= array.length - 1;
	}
}
