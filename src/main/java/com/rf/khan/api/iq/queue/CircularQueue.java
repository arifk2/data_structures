package com.rf.khan.api.iq.queue;

public class CircularQueue {
	private int front;
	private int[] arr;
	private int rear;
	private int size;

	// Initialize your data structure.
	public CircularQueue(int n) {
		size = n;
		arr = new int[size];
		front = rear = -1;
	}

	/*
	 * Enqueues 'X' into the queue. Returns true if it gets pushed into the stack,
	 * and false otherwise.
	 */
	public boolean enqueue(int value) {
		// Check for the not empty : queue is full
		if ((front == 0 && rear == size - 1) || rear == (front - 1) % (size - 1)) {
			return false;
		} else if (front == -1) { // first element
			front = rear = 0;
		} else if (rear == size - 1 && front != 0) { // rear is at last: to maintain cyclic
			rear = 0;
		} else { // normal condition
			rear++;
		}
		arr[rear] = value;
		return true;
	}

	/*
	 * Dequeues top element from queue. Returns -1 if the stack is empty, otherwise
	 * returns the popped element.
	 */
	public int dequeue() {
		// check for the empty
		if (rear == -1 && front == -1) {
			return -1;
		}
		int ans = arr[front];
		arr[front] = -1; // removing element
		if (front == rear) { // single element is present
			front = rear = -1;
		} else if (front == size - 1) { // front is at end
			front = 0; // to maintain cyclic nature
		} else {
			front++;
		}
		return ans;
	}
};