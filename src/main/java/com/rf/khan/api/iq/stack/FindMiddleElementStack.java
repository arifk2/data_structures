package com.rf.khan.api.iq.stack;

import java.util.Stack;

public class FindMiddleElementStack {

	public static void main(String[] args) {
		FindMiddleElementStack f = new FindMiddleElementStack();
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);

		System.out.println(f.getMiddlElement(stack, stack.size()));
	}

	public int getMiddlElement(Stack<Integer> stack, int size) {
		int count = 0;
		return getMidRec(stack, size, count);

	}

	private int getMidRec(Stack<Integer> stack, int size, int count) {
		int ans;
		// base case
		if (count == size / 2) {
			ans = stack.peek(); // pop also can be used, : delete middle element
			return ans;
		}

		// watch
		int num = stack.peek();
		// nikaal do
		stack.pop();

		// recursive call
		ans = getMidRec(stack, size, count + 1);
		stack.push(num);
		return ans;
	}
}
