package com.rf.khan.api.iq.dp;

public class CutIntoSegmentRecursion {

	public static int cutSegments(int n, int x, int y, int z) {
		int ans = solveRecursion(n, x, y, z);
		if (ans > 0)
			return ans;
		return 0;
	}

	/**
	 * Recursive solution
	 * 
	 * @param n
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	private static int solveRecursion(int n, int x, int y, int z) {
		// base case
		if (n == 0)
			return 0;
		if (n < 0)
			return Integer.MIN_VALUE;

		int aX = solveRecursion(n - x, x, y, z) + 1;
		int aY = solveRecursion(n - y, x, y, z) + 1;
		int aZ = solveRecursion(n - z, x, y, z) + 1;

		return Math.max(Math.max(aX, aY), aZ);
	}

	public static void main(String[] args) {
		System.out.println(cutSegments(5, 4, 2, 4));
	}

}
