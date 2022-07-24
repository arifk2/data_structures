package com.rf.khan.api.iq.stack;

public class Stack {

	private int[] arr;
	private int top;
	private int size;

	Stack(int size) {
		this.size = size;
		arr = new int[size];
		top = -1;
	}

	public int push(int element) {
		if (size - top > 1) {
			top++;
			arr[top] = element;
			return element;
		} else {
			throw new StackOverflowError("Size is not present");
		}
	}

	public int pop() {
		// check whether one element is present
		if (top >= 0) {
			int element = arr[top];
			top--;
			return element;

		} else {
			throw new StackOverflowError("Stack is empty");
		}
	}

	public int peek() {
		if (top >= 0) {
			return arr[top];
		} else {
			throw new StackOverflowError("Stack is empty");
		}
	}

	public boolean isEmpty() {
		if (top < 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Stack st = new Stack(3);
		st.push(10);
		st.push(20);
		st.push(30);
		

		System.out.println(st.peek());
		System.out.println(st.pop());
		System.out.println(st.peek());
		System.out.println(st.isEmpty());
	}
}
