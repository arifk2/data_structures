package com.rf.khan.api.iq.queue;

public class Deque {
	int[] arr;
	int size;
	int front;
	int rear;

	// Initialize your data structure.
	public Deque(int n) {
		size = n;
		arr = new int[n];
		front = rear = -1;
	}

	// Pushes 'X' in the front of the deque. Returns true if it gets pushed into the
	// deque, and false otherwise.
	public boolean pushFront(int x) {
		// check empty
		if ((front == 0 && rear == size - 1) || front != 0 && rear == (front - 1) % (size - 1)) {
			return false;
		} else if (front == -1) { // first element
			front = rear = 0;
		} else if (front == 0 && rear != size - 1) { // to maintain cyclic
			front = size - 1;
		} else { // normal condition
			front--;
		}
		arr[front] = x;
		return true;
	}

	// Pushes 'X' in the back of the deque. Returns true if it gets pushed into the
	// deque, and false otherwise.
	public boolean pushRear(int x) {
		// check empty
		if ((front == 0 && rear == size - 1) || front != 0 && rear == (front - 1) % (size - 1)) {
			return false;
		} else if (front == -1) { // first element
			front = rear = 0;
		} else if (front != 0 && rear == size - 1) { // to maintain cyclic
			rear = 0;
		} else { // normal condition
			rear++;
		}
		arr[rear] = x;
		return true;
	}

	// Pops an element from the front of the deque. Returns -1 if the deque is
	// empty, otherwise returns the popped element.
	public int popFront() {

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

	// Pops an element from the back of the deque. Returns -1 if the deque is empty,
	// otherwise returns the popped element.
	public int popRear() {

		// check for the empty
		if (rear == -1 && front == -1) {
			return -1;
		}
		int ans = arr[rear];
		arr[rear] = -1; // removing element
		if (front == rear) { // single element is present
			front = rear = -1;
		} else if (rear == 0) { // front is at end
			rear = size - 1; // to maintain cyclic nature
		} else {
			rear--;
		}
		return ans;

	}

	// Returns the first element of the deque. If the deque is empty, it returns -1.
	public int getFront() {
		if (isEmpty()) {
			return -1;
		} else {
			return arr[front];
		}
	}

	// Returns the last element of the deque. If the deque is empty, it returns -1.
	public int getRear() {
		if (isEmpty()) {
			return -1;
		} else {
			return arr[rear];
		}
	}

	// Returns true if the deque is empty. Otherwise returns false.
	public boolean isEmpty() {
		if (front == -1)
			return true;
		else
			return false;
	}

	// Returns true if the deque is full. Otherwise returns false.
	public boolean isFull() {
		if ((front == 0 && rear == size - 1) || front != 0 && rear == (front - 1) % (size - 1)) {
			return true;
		} else {
			return false;
		}
	}
}
