package com.rf.khan.api.iq.dp;

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
 * @author mkhan339
 *
 */
public class BestTimeToBuyOrSellStockIVSpaceOptm {

	/**
	 * This method is created to get the maximum profit
	 * 
	 * @param prices holds the information of the profit
	 * @return profit amount
	 */
	public int maxProfit(int k, int[] prices) {
		return solveSpaceOptmization(prices, k);
	}

	/**
	 * This method is created to solve the problem using Space Optimization
	 * 
	 * @param prices holds the information of the prices array
	 * @param k      tell number of the transaction
	 * @return maximum profit
	 */
	private int solveSpaceOptmization(int[] prices, int k) {
		int n = prices.length;

		int[][] curr = new int[2][k + 1];
		int[][] next = new int[2][k + 1];

		for (int index = n - 1; index >= 0; index--) {
			for (int canBuy = 0; canBuy <= 1; canBuy++) {
				for (int limit = 1; limit <= k; limit++) {

					int profit = 0;
					if (canBuy == 1) {
						int buuyKaro = -prices[index] + next[0][limit];
						int skipKaro = 0 + next[1][limit];

						profit = Math.max(buuyKaro, skipKaro);

					} else {
						int sellKaro = 0;
						if (limit - 1 >= 0)
							sellKaro = +prices[index] + next[1][limit - 1];
						int skipKaro = 0 + next[0][limit];

						profit = Math.max(sellKaro, skipKaro);
					}
					curr[canBuy][limit] = profit;
				}
			}
			next = curr;
		}
		return next[1][k];
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int k = 2;
		BestTimeToBuyOrSellStockIVSpaceOptm b = new BestTimeToBuyOrSellStockIVSpaceOptm();
		System.out.println(b.maxProfit(k, prices));
	}
}
