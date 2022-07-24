package com.rf.khan.api.iq.stack;

import java.util.Stack;

public class SortStack {

	public static void sortedInsert(Stack<Integer> stack, Integer num) {
		if (stack.isEmpty() || stack.peek() < num) {
			stack.push(num);
			return;
		}

		Integer n = stack.peek();
		stack.pop();

		// recursive call
		sortedInsert(stack, num);
		stack.push(n);
	}

	public static Stack<Integer> sortStack(Stack<Integer> s) {
		if (s.isEmpty()) {
			return s;
		}
		// taking all the element outside of the stack
		Integer num = s.peek();
		s.pop();

		// recursive call
		sortStack(s);

		// sort stack
		sortedInsert(s, num);

		return s;
	}
}
