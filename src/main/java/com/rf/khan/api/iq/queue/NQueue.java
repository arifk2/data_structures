package com.rf.khan.api.iq.queue;

public class NQueue {
	private int arr[];
	private int front[];
	private int rear[];
	private int next[];
	private int freeSpot;
	int n;
	int k;

	public NQueue() {
		arr = new int[n];

		next = new int[n];
		for (int i = 0; i < n; i++) {
			next[i] = i + 1;
		}
		next[n - 1] = -1;

		rear = new int[k];
		front = new int[k];
		for (int i = 0; i < k; i++) {
			front[i] = -1;
			rear[i] = -1;
		}
		freeSpot = 0;
	}

	public void enQueue(int data, int qn) {
		// Step1: stack overflow check
		if (freeSpot == -1) {
			System.out.println("Stack Overfflow, Full");
			return;
		}

		// Step 2: get the index
		int index = freeSpot;

		// Step 3: update the freeSpot
		freeSpot = next[index];

		// Step 4: check for the first element : updating front
		if (front[qn - 1] == -1) {
			front[qn - 1] = index;
		} else {
			// link the new element to the previous element for a particular queue
			next[rear[qn - 1]] = index;
		}

		// Step5: update next
		next[index] = -1;

		// Step6: update rear
		rear[qn - 1] = index;

		// Step7: insert the data
		arr[index] = data;

	}

	public int enQueue(int qn) {
		// Step1: check empty
		if (front[qn - 1] == -1) {
			System.out.println("Queue Under flow: Empty");
			return -1;
		}
		// Step2: find the index to pop
		int index = front[qn - 1];

		// Step:3 Change the front to next
		front[qn - 1] = next[index]; // -1 ko daal rhe queue me

		// Step4: Manage freeSpot
		next[index] = freeSpot;

		freeSpot = index;

		return arr[index];
	}
}
