package com.rf.khan.api.iq.dp;

import org.bouncycastle.util.Arrays;

/**
 ***********
 * Approach
 ***********
 * 
 * We have to take a flag canBuy which tell we have to but the stock or sell the
 * stock.
 * 
 * Also in each can of the buy sell, we can either buy/sell or can skip to
 * buy/sell.
 * 
 * Also when we but any stock the price will be added into profit as
 * -price[index] and for the sell +price[index].
 * 
 * Get maximum of the (buy & skip) && (sell & skip)
 * 
 * @author mkhan339
 *
 */
public class BestTimeToBuyOrSellStockIIRecMem {

	/**
	 * This method is created to get the maximum profit
	 * 
	 * @param prices holds the information of the profit
	 * @return profit amount
	 */
	public int maxProfit(int[] prices) {
		int n = prices.length;

		int[][] dp = new int[n][2];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		return solveRecursionMem(0, prices, 1, dp);
	}

	/**
	 * This method is created to solve the problem using recursion + memoization
	 * 
	 * @param index  holds the information of the index
	 * @param prices holds the information of the prices array
	 * @param canBuy tell buy or sell
	 * @return maximum profit
	 */
	private int solveRecursionMem(int index, int[] prices, int canBuy, int[][] dp) {
		if (index == prices.length)
			return 0;

		if (dp[index][canBuy] != -1)
			return dp[index][canBuy];

		int profit = 0;
		if (canBuy == 1) {
			int buuyKaro = -prices[index] + solveRecursionMem(index + 1, prices, 0, dp);
			int skipKaro = 0 + solveRecursionMem(index + 1, prices, 1, dp);

			profit = Math.max(buuyKaro, skipKaro);

		} else {
			int sellKaro = +prices[index] + solveRecursionMem(index + 1, prices, 1, dp);
			int skipKaro = 0 + solveRecursionMem(index + 1, prices, 0, dp);

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
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		BestTimeToBuyOrSellStockIIRecMem b = new BestTimeToBuyOrSellStockIIRecMem();
		System.out.println(b.maxProfit(prices));
	}
}
