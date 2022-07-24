package com.rf.khan.api.iq.stack;

import java.util.Stack;

/**
 * jab jab mini bada hai curr ya data the tabhi manipulation karna hai
 * push() : 2 * curr - mini;
 * pop()  : 2 * mini - curr;
 * 
 * to find the prevMin from the currMin
 * 
 * @author mkhan339
 *
 */
public class SpecialStackGetMin {
	// Define the data members.
	Stack<Integer> stack;
	int mini;

	/*----------------- Public Functions of SpecialStack -----------------*/

	void push(int data) {
		// if empty then normal push and update mini
		if (stack.isEmpty()) {
			stack.push(data);
			mini = data;
		}
		if (data < mini) {
			int val = 2 * data - mini;
			stack.push(val);
			mini = data;
		} else {
			stack.push(data);
		}
	}

	int pop() {
		// if stack is empty and trying to pop()
		if (stack.isEmpty()) {
			return -1;
		}
		int curr = stack.peek();
		if (curr > mini) {
			// normal pop()
			stack.pop();
			return curr;
		} else {
			int prevMin = mini;
			int val = 2 * mini - curr;
			// update mini
			mini = val;
			stack.pop();
			return prevMin;
		}
	}

	int top() {
		if (stack.isEmpty()) {
			return -1;
		}
		int curr = stack.peek();

		if (curr < mini) {
			return mini;
		} else {
			return curr;
		}
	}

	boolean isEmpty() {
		return stack.isEmpty();
	}

	int getMin() {
		if (stack.isEmpty()) {
			return -1;
		} else {
			return mini;
		}
	}
}
