package com.rf.khan.api.iq.dp;

import java.util.Arrays;

/**
 * This class is created to get the best time to buy stock or sell stock, if the
 * transaction amount is added in the transaction.
 * 
 * @author mkhan339
 *
 */
public class BestTimeToBuyOrSellStockVRecMem {

	/**
	 * This method is created to solve using recursion + memoization
	 * 
	 * @param prices holds the information of the prices
	 * @param fee    holds the information of the fee
	 * @return maximum profit
	 */
	public int maxProfit(int[] prices, int fee) {
		int n = prices.length;
		int[][] dp = new int[n + 1][2];

		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		return solveRecursionMem(prices, fee, 0, 1, dp);
	}

	/**
	 * This is a recursive method created to solve the problem using recursion +
	 * memoization
	 * 
	 * @param prices holds the information of the prices
	 * @param fee    holds the information of the fee
	 * @param index  holds the information of the index
	 * @param canBuy holds the information to tell whether can buy the stock or sell
	 *               the stock
	 * @param dp     holds the information of the dynamic array
	 * @return return max profit
	 */
	private int solveRecursionMem(int[] prices, int fee, int index, int canBuy, int[][] dp) {
		if (index == prices.length)
			return 0;

		int profit = 0;

		if (dp[index][canBuy] != -1)
			return dp[index][canBuy];

		if (canBuy == 1) {
			int buyKaro = -prices[index] + solveRecursionMem(prices, fee, index + 1, 0, dp);
			int skipKaro = 0 + solveRecursionMem(prices, fee, index + 1, 1, dp);

			profit = Math.max(buyKaro, skipKaro);
		} else {
			int sellKaro = +prices[index] + (-fee) + solveRecursionMem(prices, fee, index + 1, 1, dp);
			int skipKaro = 0 + solveRecursionMem(prices, fee, index + 1, 0, dp);

			profit = Math.max(sellKaro, skipKaro);
		}

		return dp[index][canBuy] = profit;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = { 1, 3, 2, 8, 4, 9 };
		int fee = 2;
		BestTimeToBuyOrSellStockVRecMem b = new BestTimeToBuyOrSellStockVRecMem();

		System.out.println(b.maxProfit(prices, fee));
	}

}
