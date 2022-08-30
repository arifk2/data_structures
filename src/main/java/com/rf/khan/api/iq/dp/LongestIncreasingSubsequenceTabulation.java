package com.rf.khan.api.iq.dp;

public class LongestIncreasingSubsequenceTabulation {
	// Function to find length of longest increasing subsequence.
	static int longestSubsequence(int size, int a[]) {

		return solveUsingTabulation(a, size);
	}

	/**
	 * Solving using tabulation- bottom -up approach
	 * 
	 * @param a input array
	 * @param n
	 * @return
	 */
	private static int solveUsingTabulation(int[] a, int n) {

		int[][] dp = new int[n + 1][n + 1];

		for (int current = n - 1; current >= 0; current--) {
			for (int previous = current; previous >= -1; previous--) {

				int include = 0;

				if (previous == -1 || a[current] > a[previous])
					include = 1 + dp[current + 1][current + 1];

				int exclude = 0 + dp[current + 1][previous + 1];
				dp[current][previous + 1] = Math.max(include, exclude);

			}
		}

		return dp[0][-1 + 1];
	}

	public static void main(String[] args) {
		int[] a = { 5, 8, 3, 7, 9, 1 };
		int size = a.length;
		System.out.println(longestSubsequence(size, a));
	}
}
