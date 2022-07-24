package com.rf.khan.api.iq.queue;

public class QueueQ {
	int[] arr;
	int size;
	int qFront;
	int rear;

	QueueQ() {
		size = 10001;
		arr = new int[size];
		qFront = 0;
		rear = 0;
	}

	/*----------------- Public Functions of Queue -----------------*/

	boolean isEmpty() {
		if (rear == qFront) {
			return true;
		}
		return false;
	}

	void enqueue(int data) {
		if (rear == size) {
			System.out.println("List is full");
		} else {
			arr[rear] = data;
			rear++;
		}
	}

	int dequeue() {
		// check if the queue is empty
		if (rear == qFront) {
			return -1;
		} else {
			int ans = arr[qFront];
			// after removing add dummy value at the arr[qFront]
			arr[qFront] = -1;
			qFront++;
			if (rear == qFront) {
				rear = 0;
				qFront = 0;
			}
			return ans;
		}
	}

	int front() {
		// check if the queue is empty
		if (rear == qFront) {
			return -1;
		} else {
			return arr[qFront];
		}
	}

}
