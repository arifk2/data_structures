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
 * Also we need to add the limit to get track the transaction
 * 
 * we are taking 2*k as a operation number, if the operation number ie even then
 * buy, or else of operation number is odd then sell
 * 
 * @author mkhan339
 *
 */
public class BestTimeToBuyOrSellStockIVUsingTxNoRecMem {

	/**
	 * This method is created to get the maximum profit
	 * 
	 * @param prices holds the information of the profit
	 * @return profit amount
	 */
	public int maxProfit(int k, int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n + 1][2 * k];

		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		return solveRec(0, 0, k, prices, dp);
	}

	/**
	 * This method is created to solve the problem using recursion + memoization
	 * 
	 * @param prices holds the information of the prices array
	 * @param k      tell number of the transaction
	 * @return maximum profit
	 */
	private int solveRec(int index, int operationNo, int k, int[] prices, int[][] dp) {
		// base case
		if (index == prices.length)
			return 0;

		if (operationNo == 2 * k)
			return 0;

		if (dp[index][operationNo] != -1)
			return dp[index][operationNo];

		int profit = 0;

		if (operationNo % 2 == 0) {
			// even - buy allowed
			int buyKaro = -prices[index] + solveRec(index + 1, operationNo + 1, k, prices, dp);
			int skipKaro = 0 + solveRec(index + 1, operationNo, k, prices, dp);

			profit = Math.max(skipKaro, buyKaro);

		} else {
			// off - sell allowed
			int sellKaro = +prices[index] + solveRec(index + 1, operationNo + 1, k, prices, dp);
			int skipKaro = 0 + solveRec(index + 1, operationNo, k, prices, dp);

			profit = Math.max(sellKaro, skipKaro);
		}

		return dp[index][operationNo] = profit;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int k = 2;
		BestTimeToBuyOrSellStockIVUsingTxNoRecMem b = new BestTimeToBuyOrSellStockIVUsingTxNoRecMem();
		System.out.println(b.maxProfit(k, prices));
	}
}
