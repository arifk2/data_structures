package com.rf.khan.api.iq.dp;

import java.util.Arrays;

/**
 ***********
 * Approach
 ***********
 * LC -188
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
 * Atmost k transaction
 * 
 * @author mkhan339
 *
 */
public class BestTimeToBuyOrSellStockIVRecMem {

	/**
	 * This method is created to get the maximum profit
	 * 
	 * @param prices holds the information of the profit
	 * 
	 * @param k      k time transaction
	 * @return profit amount
	 */
	public int maxProfit(int[] prices, int k) {
		int n = prices.length;

		int[][][] dp = new int[n + 1][3][k+1];

		for (int[][] arr : dp) {
			for (int[] ar : arr)
				Arrays.fill(ar, -1);
		}

		return solveRecursionMem(0, prices, 1, k, dp);
	}

	/**
	 * This method is created to solve the problem using recursion +memoization
	 * 
	 * @param index  holds the information of the index
	 * @param prices holds the information of the prices array
	 * @param canBuy tell buy or sell
	 * @return maximum profit
	 */
	private int solveRecursionMem(int index, int[] prices, int canBuy, int limit, int[][][] dp) {
		if (index == prices.length)
			return 0;

		if (limit == 0)
			return 0;

		if (dp[index][canBuy][limit] != -1)
			return dp[index][canBuy][limit];

		int profit = 0;

		if (canBuy == 1) {
			int buuyKaro = -prices[index] + solveRecursionMem(index + 1, prices, 0, limit, dp);
			int skipKaro = 0 + solveRecursionMem(index + 1, prices, 1, limit, dp);

			profit = Math.max(buuyKaro, skipKaro);

		} else {
			int sellKaro = +prices[index] + solveRecursionMem(index + 1, prices, 1, limit - 1, dp);
			int skipKaro = 0 + solveRecursionMem(index + 1, prices, 0, limit, dp);

			profit = Math.max(sellKaro, skipKaro);

		}
		return dp[index][canBuy][limit] = profit;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int k = 2;
		BestTimeToBuyOrSellStockIVRecMem b = new BestTimeToBuyOrSellStockIVRecMem();
		System.out.println(b.maxProfit(prices, k));
	}
}
