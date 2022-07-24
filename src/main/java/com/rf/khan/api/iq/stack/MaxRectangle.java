package com.rf.khan.api.iq.stack;

import java.util.Stack;

public class MaxRectangle {

	public static void main(String[] args) {
		int input[][] = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		System.out.println(maxArea(input, 4, 4));
		int input2[][] = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };
		System.out.println(maxArea(input2, 4, 4));
	}

	public static int maxArea(int M[][], int n, int m) {
		// get the max area for the first row
		int area = largestRectangleArea(M[0], m);

		// zero wala nikaal chuka hu isliye 1 se start kiya
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {

				// row update add the previous row , only if the curr row element is not 0
				if (M[i][j] != 0) {
					// adding current and previous row
					M[i][j] = M[i][j] + M[i - 1][j];
				} else {
					M[i][j] = 0;
				}
			}
			// entire row is update now
			int newArea = largestRectangleArea(M[i], m);
			area = Math.max(area, newArea);
		}
		return area;
	}

	/**
	 * get the largest area
	 * 
	 * @param is
	 * @param m
	 * @return
	 */
	private static int largestRectangleArea(int[] is, int m) {

		int[] nextSmaller = nextSmallerElement(is, m);
		int[] prevSmaller = prevSmallerElement(is, m);

		int area = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			int l = is[i];

			if (nextSmaller[i] == -1) {
				nextSmaller[i] = m;
			}
			int b = nextSmaller[i] - prevSmaller[i] - 1;

			int newArea = l * b;
			area = Math.max(area, newArea);
		}

		return area;
	}

	private static int[] nextSmallerElement(int[] is, int m) {
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[m];
		stack.push(-1);
		for (int i = m - 1; i >= 0; i--) {
			int curr = is[i];
			while (stack.peek() != -1 && is[stack.peek()] >= curr) {
				stack.pop();
			}
			ans[i] = stack.peek();
			stack.push(i);
		}
		return ans;
	}

	private static int[] prevSmallerElement(int[] is, int m) {
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[m];
		stack.push(-1);
		for (int i = 0; i < m; i++) {
			int curr = is[i];
			while (stack.peek() != -1 && is[stack.peek()] >= curr) {
				stack.pop();
			}
			ans[i] = stack.peek();
			stack.push(i);
		}
		return ans;
	}

}
