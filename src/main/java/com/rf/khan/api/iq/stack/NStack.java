package com.rf.khan.api.iq.stack;

public class NStack {

	int[] arr;
	int[] top;
	int[] next;
	int freeSpot;
	int n, s;

	// Initialize your data structure.
	public NStack(int N, int S) {
		n = N;
		s = S;
		arr = new int[s];
		top = new int[n];
		next = new int[s];

		// top initilize
		for (int i = 0; i < n; i++) {
			top[i] = -1;
		}

		// next initilize
		for (int i = 0; i < s; i++) {
			next[i] = i + 1;
		}
		// last emelemt should be -1
		next[s - 1] = -1;
		freeSpot = 0;
	}

	// Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack,
	// and false otherwise.
	public boolean push(int x, int m) {
		// check for the overflow
		if (freeSpot == -1) {
			return false;
		}

		// step 1: get the index to insert in array
		int index = freeSpot;

		// step2: update freeSpot;
		freeSpot = next[index];

		// step3: insert the element in the array
		arr[index] = x;

		// Step 4: update next;
		next[index] = top[m - 1];

		// Step 5: update top;
		top[m - 1] = index;

		return true;
	}

	// Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise
	// returns the popped element.
	public int pop(int m) {
		// reverse of push

		// check if the stack is empty, if the top element is -1
		if (top[m - 1] == -1) {
			return -1;
		}
		int index = top[m - 1];

		top[m - 1] = next[index];

		next[index] = freeSpot;

		freeSpot = index;

		return arr[index];
	}
}