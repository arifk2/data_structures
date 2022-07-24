package com.rf.khan.api.iq.stack;

import java.util.Stack;

public class CelebratityProblem {

	public static void main(String[] args) {
		 int[][] input = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };

		//int[][] input = { { 0, 1 }, { 1, 0 } };
		System.out.println(celebrity(input, 2));
	}

	static int celebrity(int m[][], int n) {
		
		// Step1: push all the element in the stack
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			stack.push(i);
		}

		// Step2: get two element and compare
		
		while (stack.size() > 1) {
			int a = stack.peek();
			stack.pop();

			int b = stack.peek();
			stack.pop();

			if (knows(m, a, b, n)) {
				stack.push(b);
			} else {
				stack.push(a);
			}
		}

		// Step 3: get one element which has the potential to be celebrity
		int celebrity = stack.peek();

		// Step 4: verify
		// row check
		boolean rowCheck = false;
		int zeroCount = 0;
		for (int i = 0; i < n; i++) {
			if (m[celebrity][i] == 0) {
				zeroCount++;
			}
		}
		if (zeroCount == n) {
			rowCheck = true;
		}

		// column check
		boolean columnCheck = false;
		int oneCount = 0;
		for (int i = 0; i < n; i++) {
			if (m[i][celebrity] == 1) {
				oneCount++;
			}
		}
		if (oneCount == n - 1) {
			columnCheck = true;
		}

		if (rowCheck && columnCheck) {
			return celebrity;
		}

		return -1;
	}

	private static boolean knows(int[][] m, int a, int b, int n) {
		for (int i = 0; i < n; i++) {
			if (m[a][b] == 1) {
				return true;
			}
		}
		return false;
	}

}
