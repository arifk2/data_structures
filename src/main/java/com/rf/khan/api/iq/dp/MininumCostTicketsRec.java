package com.rf.khan.api.iq.dp;

public class MininumCostTicketsRec {

	public static int minimumCoins(int n, int[] days, int[] cost) {
		return solveRecursion(n, days, cost, 0);
	}

	/**
	 * Solving using recursion
	 * 
	 * @param n
	 * @param totalDays
	 * @param cost
	 * @param index
	 * @return
	 */
	private static int solveRecursion(int totalDays, int[] days, int[] cost, int index) {

		// base case
		// if the number of the days is increase to current day number
		if (index >= totalDays)
			return 0;

		// option 1: 1 day pass
		int option1 = cost[0] + solveRecursion(totalDays, days, cost, index + 1);

		// option 2: 7 day pass
		// days[index] + 7;
		// 7 days ka pass lene ke baad kis din pe pahuch sakte ho

		int i;
		for (i = index; i < totalDays && days[i] < days[index] + 7; i++)
			;

		int option2 = cost[1] + solveRecursion(totalDays, days, cost, i);

		// option3: 30 days pass

		for (i = index; i < totalDays && days[i] < days[index] + 30; i++)
			;
		int option3 = cost[2] + solveRecursion(totalDays, days, cost, i);

		return Math.min(option1, Math.min(option2, option3));
	}

	public static void main(String[] args) {

		int[] days = { 1, 4, 6, 7, 8, 20 };
		int[] cost = { 2, 7, 15 };
		int n = days.length;

		System.out.println(minimumCoins(n, days, cost));
	}
}
