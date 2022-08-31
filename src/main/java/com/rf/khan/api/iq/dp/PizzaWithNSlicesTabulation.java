package com.rf.khan.api.iq.dp;

/**
 * 
 * @author mkhan339
 *
 */
public class PizzaWithNSlicesTabulation {

	/**
	 * Solving using recursion
	 * 
	 * @param slices
	 * @return
	 */
	public int maxSizeSlices(int[] slices) {
		return solveUsingTabulation(slices);
	}

	/**
	 * Solving using Tabulation
	 * 
	 * @param slices
	 * @return
	 */
	private int solveUsingTabulation(int[] slices) {
		int k = slices.length;

		int[][] dp1 = new int[k + 2][k + 2];
		int[][] dp2 = new int[k + 2][k + 2];

		for (int index = k - 2; index >= 0; index--) {
			for (int n = 1; n <= k / 3; n++) {

				int take = slices[index] + dp1[index + 2][n - 1];
				int nottake = 0 + dp1[index + 1][n];

				dp1[index][n] = Math.max(take, nottake);

			}
		}

		int case1 = dp1[0][k / 3];

		for (int index = k - 1; index >= 1; index--) {
			for (int n = 1; n <= k / 3; n++) {

				int take = slices[index] + dp2[index + 2][n - 1];
				int nottake = 0 + dp2[index + 1][n];

				dp2[index][n] = Math.max(take, nottake);

			}
		}

		int case2 = dp2[1][k / 3];

		return Math.max(case1, case2);
	}

	/**
	 * This is a main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] slices = { 1, 2, 3, 4, 5, 6 };
		PizzaWithNSlicesTabulation p = new PizzaWithNSlicesTabulation();
		System.out.println(p.maxSizeSlices(slices));

	}
}
