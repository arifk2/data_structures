package com.rf.khan.api.iq.dp;

import java.util.concurrent.atomic.AtomicInteger;

public class LargestSqFoundInMatrix {

	/**
	 * Driver method
	 * 
	 * @param n
	 * @param m
	 * @param mat
	 * @return
	 */
	static int maxSquare(int n, int m, int mat[][]) {
		AtomicInteger maxi = new AtomicInteger(0);
		solveByRecursion(mat, 0, 0, maxi);
		return maxi.get();
	}

	/**
	 * Solve by recursion
	 * 
	 * @param mat
	 * @param i
	 * @param j
	 * @param maxi
	 */
	private static int solveByRecursion(int[][] mat, int i, int j, AtomicInteger maxi) {

		// base case i and j should not go outside of the array
		if (i >= mat.length || j >= mat[0].length)
			return 0;

		int right = solveByRecursion(mat, i, j + 1, maxi);
		int diagonal = solveByRecursion(mat, i + 1, j + 1, maxi);
		int down = solveByRecursion(mat, i + 1, j, maxi);

		if (mat[i][j] == 1) {
			int ans = 1 + Math.min(right, Math.min(diagonal, down));
			maxi.set(Integer.max(ans, maxi.get()));
			return ans;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {

		int[][] mat = { { 1, 1 }, { 1, 1 } };
		int n = 2;
		int m = 2;
		System.out.println(maxSquare(n, m, mat));
	}
}
