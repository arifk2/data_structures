package com.rf.khan.api.iq.dp;

import org.bouncycastle.util.Arrays;

/**
 * This class is created to get the max total number of the unique binary search
 * tree
 * 
 * @author mkhan339
 *
 */
public class UniqueStructuralBSTTabulation {

	/**
	 * This method is created to get the total number of the unique BST
	 * 
	 * @param n holds the number of node from 1 to n
	 * @return
	 */
	public int numTrees(int n) {

		return solveTabulation(n);
	}

	/**
	 * Solving using tabulation- bottom -up approach
	 * 
	 * @param n holds the total number of node
	 * @return total unique BST count
	 */
	private int solveTabulation(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;

		// i = number of nodes
		for (int i = 2; i <= n; i++) {
			// j denote which is root node
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
	}

	/**
	 * This is driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UniqueStructuralBSTTabulation u = new UniqueStructuralBSTTabulation();
		System.out.println("Total number of the unique structural BST is: " + u.numTrees(3));
	}
}
