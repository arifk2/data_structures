package com.rf.khan.api.iq.stack;

import java.util.Stack;

class LargestRectangleInHistogram {
	public static void main(String[] args) {
		int[] in = { 2, 1, 5, 6, 2, 3 };

		System.out.println(largestRectangleArea(in));
	}

	private static int largestRectangleArea(int[] heights) {
		int n = heights.length;

		// Step 1: get the next smaller element index
		int[] nextSmaller = nextSmallerElement(heights, n);

		// Step 2: get the previous smaller element index
		int[] prevSmaller = prevSmallerElement(heights, n);

		// Step 3: get the are with are formula ans compare with newArea
		int area = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int l = heights[i];

			if (nextSmaller[i] == -1) {
				nextSmaller[i] = n;
			}
			int b = nextSmaller[i] - prevSmaller[i] - 1;

			int newArea = l * b;
			area = Math.max(area, newArea);
		}

		// Step4: return area as a answer
		return area;
	}

	/**
	 * This method is created to get all the next Smaller element index
	 * 
	 * @param heights holds the information of the input parameter
	 * @param n       size of the array
	 * @return answer array
	 */
	private static int[] nextSmallerElement(int[] heights, int n) {
		int[] ans = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);

		// reverse loop
		for (int i = n - 1; i >= 0; i--) {
			int curr = heights[i];
			while (stack.peek() != -1 && heights[stack.peek()] >= curr) {
				stack.pop();
			}
			ans[i] = stack.peek();
			stack.push(i);
		}
		return ans;
	}

	private static int[] prevSmallerElement(int[] heights, int n) {

		int[] ans = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);

		// reverse loop
		for (int i = 0; i < n; i++) {
			int curr = heights[i];
			while (stack.peek() != -1 && heights[stack.peek()] >= curr) {
				stack.pop();
			}
			ans[i] = stack.peek();
			stack.push(i);
		}
		return ans;
	}
}