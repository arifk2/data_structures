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
public class BestTimeToBuyOrSellStockIISpaceOptm {

	/**
	 * This method is created to get the maximum profit
	 * 
	 * @param prices holds the information of the profit
	 * @return profit amount
	 */
	public int maxProfit(int[] prices) {

		return solveSpaceOptimization(prices);
	}

	/**
	 * This method is created to solve the problem using space optimization.
	 * 
	 * @param index  holds the information of the index
	 * @param prices holds the information of the prices array
	 * @param canBuy tell buy or sell
	 * @return maximum profit
	 */
	private int solveSpaceOptimization(int[] prices) {
		int n = prices.length;
		
		int[] curr = new int[2];
		int[] next = new int[2];

		for (int index = n - 1; index >= 0; index--) {
			for (int canBuy = 0; canBuy <= 1; canBuy++) {

				int profit = 0;
				if (canBuy == 1) {
					int buyKaro = -prices[index] + next[0];
					int skipKaro = 0 + next[1];

					profit = Math.max(buyKaro, skipKaro);

				} else {
					int sellKaro = +prices[index] + next[1];
					int skipKaro = 0 + next[0];

					profit = Math.max(sellKaro, skipKaro);

				}
				curr[canBuy] = profit;
			}
			next = curr;
			
		}
		return next[1];
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		BestTimeToBuyOrSellStockIISpaceOptm b = new BestTimeToBuyOrSellStockIISpaceOptm();
		System.out.println(b.maxProfit(prices));
	}
}
