package com.rf.khan.api.iq.dp;

import java.util.Arrays;

/**
 * This class is created to get the max total number of the unique binary search
 * tree
 * 
 * @author mkhan339
 *
 */
public class UniqueStructuralBSTRecMem {

	/**
	 * This method is created to get the total number of the unique BST
	 * 
	 * @param n holds the number of node from 1 to n
	 * @return
	 */
	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);

		return solveRecursionMemoization(n, dp);
	}

	/**
	 * Solving using recursion + memoization
	 * 
	 * @param n  holds the total number of node
	 * @param dp dp array
	 * @return total unique BST count
	 */
	private int solveRecursionMemoization(int n, int[] dp) {
		// base case
		if (n <= 1)
			return 1;

		if (dp[n] != -1)
			return dp[n];

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans += solveRecursionMemoization(i - 1, dp) * solveRecursionMemoization(n - i, dp);
		}
		return dp[n] = ans;
	}

	/**
	 * This is driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UniqueStructuralBSTRecMem u = new UniqueStructuralBSTRecMem();
		System.out.println("Total number of the unique structural BST is: " + u.numTrees(19));
	}
}
