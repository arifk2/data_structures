package com.rf.khan.api.iq.stack;

/**
 * For the stack1 element push left from right 
 * For the stack2 element push right from left
 **/
public class TwoStack {
	private int[] arr;
	private int top1;
	private int top2;
	private int size;

	// Initialize TwoStack.
	public TwoStack(int s) {
		this.size = s;
		top1 = -1;
		top2 = s;
		arr = new int[size];
	}

	// Push in stack 1.
	public void push1(int num) {
		// check atleast 1 space is present
		if (top2 - top1 > 1) {
			top1++;
			arr[top1] = num;
		}
		// else stackoverflow
	}

	// Push in stack 2.
	public void push2(int num) {
		if (top2 - top1 > 1) {
			top2--;
			arr[top2] = num;
		}
		// else stackoverflow
	}

	// Pop from stack 1 and return popped element.
	public int pop1() {
		if (top1 > -1) {
			int element = arr[top1];
			top1--;
			return element;
		} else {
			return -1;
		}
		// else stackoverflow
	}

	// Pop from stack 2 and return popped element.
	public int pop2() {
		if (top2 < size) {
			int element = arr[top2];
			top2++;
			return element;
		} else {
			return -1;
		}
	}
}
