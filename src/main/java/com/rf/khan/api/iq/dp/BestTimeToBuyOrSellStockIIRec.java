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
 * @author mkhan339
 *
 */
public class BestTimeToBuyOrSellStockIIRec {

	/**
	 * This method is created to get the maximum profit
	 * 
	 * @param prices holds the information of the profit
	 * @return profit amount
	 */
	public int maxProfit(int[] prices) {

		return solveRecursion(0, prices, 1);
	}

	/**
	 * This method is created to solve the problem using recursion
	 * 
	 * @param index  holds the information of the index
	 * @param prices holds the information of the prices array
	 * @param canBuy tell buy or sell
	 * @return maximum profit
	 */
	private int solveRecursion(int index, int[] prices, int canBuy) {
		if (index == prices.length)
			return 0;

		int profit = 0;
		if (canBuy == 1) {
			int buuyKaro = -prices[index] + solveRecursion(index + 1, prices, 0);
			int skipKaro = 0 + solveRecursion(index + 1, prices, 1);

			profit = Math.max(buuyKaro, skipKaro);

		} else {
			int sellKaro = +prices[index] + solveRecursion(index + 1, prices, 1);
			int skipKaro = 0 + solveRecursion(index + 1, prices, 0);

			profit = Math.max(sellKaro, skipKaro);

		}
		return profit;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		BestTimeToBuyOrSellStockIIRec b = new BestTimeToBuyOrSellStockIIRec();
		System.out.println(b.maxProfit(prices));
	}
}
