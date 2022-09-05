package com.rf.khan.api.iq.dp;

public class GuessNumberHigherOrLowerLC375Rec {

	/**
	 * This method is created to get the money amount
	 * 
	 * @param n holds the information of the number
	 * @return minimum money
	 */
	public int getMoneyAmount(int n) {

		return solveRecursion(1, n);
	}

	/**
	 * his method is created to solve using recursion
	 * 
	 * @param start holds the information of the start
	 * @param end   holds the information of the end
	 * @return
	 */
	private int solveRecursion(int start, int end) {
		if (start >= end)
			return 0;

		int maxi = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			maxi = Math.min(maxi, i + Math.max(solveRecursion(start, i - 1), solveRecursion(i + 1, end)));
		}

		return maxi;
	}

	/**
	 * This is a driver maain method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GuessNumberHigherOrLowerLC375Rec g = new GuessNumberHigherOrLowerLC375Rec();
		int n = 10;
		System.out.println(g.getMoneyAmount(n));
	}
}
