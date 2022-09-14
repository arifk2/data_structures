package com.rf.khan.api.iq.dp;

public class BestTimeToBuyOrSellStockVRec {

	/**
	 * This method is created to solve using recursion
	 * 
	 * @param prices holds the information of the prices
	 * @param fee    holds the information of the fee
	 * @return maximum profit
	 */
	public int maxProfit(int[] prices, int fee) {
		return solveRecursion(prices, fee, 0, 1);
	}

	/**
	 * This is a recursive method created to solve the problem using recursion
	 * 
	 * @param prices holds the information of the prices
	 * @param fee    holds the information of the fee
	 * @param index  holds the information of the index
	 * @param canBuy holds the information to tell whether can buy the stock or sell
	 *               the stock
	 * @return return max profit
	 */
	private int solveRecursion(int[] prices, int fee, int index, int canBuy) {
		if (index == prices.length)
			return 0;

		int profit = 0;

		if (canBuy == 1) {
			int buyKaro = -prices[index] + solveRecursion(prices, fee, index + 1, 0);
			int skipKaro = 0 + solveRecursion(prices, fee, index + 1, 1);

			profit = Math.max(buyKaro, skipKaro);
		} else {
			int sellKaro = +prices[index] + (-fee) + solveRecursion(prices, fee, index + 1, 1);
			int skipKaro = 0 + solveRecursion(prices, fee, index + 1, 0);

			profit = Math.max(sellKaro, skipKaro);
		}

		return profit;
	}

	public static void main(String[] args) {
		int[] prices = { 1, 3, 2, 8, 4, 9 };
		int fee = 2;
		BestTimeToBuyOrSellStockVRec b = new BestTimeToBuyOrSellStockVRec();

		System.out.println(b.maxProfit(prices, fee));
	}

}
