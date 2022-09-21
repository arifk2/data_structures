package com.rf.khan.api.iq.dp;

import java.util.Stack;

/**
 * This class is created to get the largest area in histogram
 * 
 * @author mkhan339
 *
 */
public class MaximalRectangle85 {

	/**
	 * This method is created to get the maximal area of the rectangle
	 * 
	 * @param matrix
	 * @return
	 */
	public int maximalRectangle(char[][] matrix) {
		int[] histogram = new int[matrix[0].length];
		int maxi = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			// to create histogram array
			for (int j = 0; j < histogram.length; j++) {
				if (Character.getNumericValue(matrix[i][j]) == 1)
					histogram[j]++;
				else {
					histogram[j] = 0;
				}
			}
			maxi = Math.max(maxi, largestRectangleArea(histogram));
		}
		return maxi;
	}

	/**
	 * This method is created to get the largest rectangle area
	 * 
	 * @param heights
	 * @return
	 */
	private int largestRectangleArea(int[] heights) {
		int n = heights.length;

		int[] next = nextSmallerElement(heights, n);
		int[] prev = prevSmallerElement(heights, n);

		int area = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int l = heights[i];

			if (next[i] == -1)
				next[i] = n;

			int b = next[i] - prev[i] - 1;

			int newArea = l * b;
			area = Math.max(area, newArea);
		}

		return area;
	}

	/**
	 * This method is created to get the previous smaller element
	 * 
	 * @param heights holds the information of the heights
	 * @param n       holds the size of the height array
	 * @return
	 */
	private int[] prevSmallerElement(int[] heights, int n) {

		int[] prev = new int[n];
		Stack<Integer> st = new Stack<>();
		st.add(-1);

		for (int i = 0; i < n; i++) {
			int curr = heights[i];
			while (st.peek() != -1 && curr <= heights[st.peek()]) {
				st.pop();
			}
			prev[i] = st.peek();
			st.add(i);
		}
		return prev;
	}

	/**
	 * This method is created to get the next smaller element
	 * 
	 * @param heights holds the information of the heights
	 * @param n       holds the size of the height array
	 * @return
	 */
	private int[] nextSmallerElement(int[] heights, int n) {
		int[] next = new int[n];
		Stack<Integer> st = new Stack<>();
		st.add(-1);

		for (int i = n - 1; i >= 0; i--) {
			int curr = heights[i];
			while (st.peek() != -1 && curr <= heights[st.peek()]) {
				st.pop();
			}
			next[i] = st.peek();
			st.add(i);
		}
		return next;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		MaximalRectangle85 max = new MaximalRectangle85();
		System.out.println(max.maximalRectangle(matrix));

	}
}
