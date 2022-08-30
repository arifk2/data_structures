package com.rf.khan.api.iq.dp;

public class LongestIncreasingSubsequenceTabulationOpt {
	// Function to find length of longest increasing subsequence.
	static int longestSubsequence(int size, int a[]) {

		return solveUsingTabulationOpt(a, size);
	}

	/**
	 * Solving using tabulation- bottom -up approach
	 * 
	 * @param a input array
	 * @param n
	 * @return
	 */
	private static int solveUsingTabulationOpt(int[] a, int n) {

		int[] currRow = new int[n + 1];
		int[] nextRow = new int[n + 1];

		for (int current = n - 1; current >= 0; current--) {
			for (int previous = current; previous >= -1; previous--) {

				int include = 0;

				if (previous == -1 || a[current] > a[previous])
					include = 1 + nextRow[current + 1];

				int exclude = 0 + nextRow[previous + 1];
				currRow[previous + 1] = Math.max(include, exclude);

			}
			nextRow = currRow;
		}

		return nextRow[0];
	}

	public static void main(String[] args) {
		int[] a = { 5, 8, 3, 7, 9, 1 };
		int size = a.length;
		System.out.println(longestSubsequence(size, a));
	}
}
