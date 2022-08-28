package com.rf.khan.api.iq.dp;

public class MinScoreTrangulationMCPMPRecursion {

	public int minScoreTriangulation(int[] values) {
		int n = values.length;
		return solveRecursion(values, 0, n - 1);
	}

	/**
	 * This method is created to solve the problem using recursion
	 * 
	 * @param values
	 * @param i
	 * @param n
	 * @return
	 */
	private int solveRecursion(int[] values, int i, int j) {
		// base case
		if (i + 1 == j)
			return 0;

		int ans = Integer.MAX_VALUE;

		// to determine the kth value
		for (int k = i + 1; k < j; k++) {
			ans = Math.min(ans,
					values[i] * values[j] * values[k] + solveRecursion(values, i, k) + solveRecursion(values, k, j));
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] values = { 1, 2, 3 };
		MinScoreTrangulationMCPMPRecursion m = new MinScoreTrangulationMCPMPRecursion();
		System.out.println(m.minScoreTriangulation(values));
	}
}
