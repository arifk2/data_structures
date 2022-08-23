package com.rf.khan.api.iq.dp;

public class CoinChangeProblemRec {

	/**
	 * Diver method
	 * 
	 * @param num
	 * @param x
	 * @return
	 */
	public static int minimumElements(int num[], int x) {

		int ans = solveUsingRecursion(num, x);
		if (ans != Integer.MAX_VALUE)
			return ans;
		return -1;
	}

	/**
	 * This method is create to solve the problem using recursion
	 * 
	 * @param num    holds the information of the coins array
	 * @param amount holds the information of the amount
	 * @return total number of coins
	 */
	private static int solveUsingRecursion(int[] num, int amount) {
		// base case
		if (amount == 0)
			return 0;
		if (amount < 0)
			return Integer.MAX_VALUE;

		int mini = Integer.MAX_VALUE;

		for (int i = 0; i < num.length; i++) {
			int ans = solveUsingRecursion(num, amount - num[i]);

			if (ans != Integer.MAX_VALUE)
				mini = Math.min(mini, ans + 1);
		}

		return mini;
	}

	public static void main(String[] args) {
		int num[] = { 1, 2, 3 };
		int x = 10;

		System.out.println(minimumElements(num, x));
	}
}
