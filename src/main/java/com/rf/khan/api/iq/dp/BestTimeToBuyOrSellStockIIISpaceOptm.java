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
public class BestTimeToBuyOrSellStockIIISpaceOptm {

	/**
	 * This method is created to get the maximum profit
	 * 
	 * @param prices holds the information of the profit
	 * @return profit amount
	 */
	public int maxProfit(int[] prices) {
		return solveSpaceOptmization(prices);
	}

	/**
	 * This method is created to solve the problem using Space Optimization
	 * 
	 * @param index  holds the information of the index
	 * @param prices holds the information of the prices array
	 * @param canBuy tell buy or sell
	 * @return maximum profit
	 */
	private int solveSpaceOptmization(int[] prices) {
		int n = prices.length;

		int[][] curr = new int[2][3];
		int[][] next = new int[2][3];

		for (int index = n - 1; index >= 0; index--) {
			for (int canBuy = 0; canBuy <= 1; canBuy++) {
				for (int limit = 1; limit <= 2; limit++) {

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
		return next[1][2];
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		BestTimeToBuyOrSellStockIIISpaceOptm b = new BestTimeToBuyOrSellStockIIISpaceOptm();
		System.out.println(b.maxProfit(prices));
	}
}
