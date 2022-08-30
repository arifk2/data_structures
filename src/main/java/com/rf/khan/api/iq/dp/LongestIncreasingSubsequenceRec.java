package com.rf.khan.api.iq.dp;

public class LongestIncreasingSubsequenceRec {
	// Function to find length of longest increasing subsequence.
	static int longestSubsequence(int size, int a[]) {

		return solveUsingRecursion(a, 0, -1);
	}

	private static int solveUsingRecursion(int[] a, int current, int previous) {
		if (current == a.length)
			return 0;

		int include = 0;
		if (previous == -1 || a[current] > a[previous])
			include = 1 + solveUsingRecursion(a, current + 1, current);

		int exclude = 0 + solveUsingRecursion(a, current + 1, previous);

		int ans = Math.max(include, exclude);
		return ans;
	}

	public static void main(String[] args) {
		int[] a = { 5, 8, 3, 7, 9, 1 };
		int size = a.length;
		System.out.println(longestSubsequence(size, a));
	}
}
