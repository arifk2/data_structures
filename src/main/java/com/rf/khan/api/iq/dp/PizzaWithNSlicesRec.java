package com.rf.khan.api.iq.dp;

public class PizzaWithNSlicesRec {

	/**
	 * Solving using recursion
	 * 
	 * @param slices
	 * @return
	 */
	public int maxSizeSlices(int[] slices) {
		int k = slices.length;

		int case1 = solveUsingRecursion(0, k - 2, slices, k / 3);
		int case2 = solveUsingRecursion(1, k - 1, slices, k / 3);

		return Math.max(case1, case2);
	}

	/**
	 * Solving using recursion
	 * 
	 * @param index
	 * @param slices
	 * @param n
	 * @return
	 */

	private int solveUsingRecursion(int index, int endIndex, int[] slices, int n) {
		// base
		if (n == 0 || index > endIndex)
			return 0;

		int take = slices[index] + solveUsingRecursion(index + 2, endIndex, slices, n - 1);
		int nottake = 0 + solveUsingRecursion(index + 1, endIndex, slices, n);

		return Math.max(take, nottake);
	}

	/**
	 * This is a main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] slices = { 9, 5, 1, 7, 8, 4, 4, 5, 5, 8, 7, 7 };
		PizzaWithNSlicesRec p = new PizzaWithNSlicesRec();
		System.out.println(p.maxSizeSlices(slices));

	}
}
