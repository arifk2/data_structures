package com.rf.khan.api.iq.dp;

/**
 * Lect: 130
 * 
 * @author mkhan339
 * 
 *         * Approach:
 * 
 *         * If you buy a stock on prices[0], then sell will in between 1 to n-1
 *         * Also update profit and minimum value upto i
 * 
 * 
 *
 */
public class BestTimeToBuyOrSellStock {

	/**
	 * This method is created to get the max Profit by selling the stock
	 * 
	 * @param prices holds the information of the price array
	 * @return maximum profit
	 */
	public int maxProfit(int[] prices) {
		int mini = prices[0];
		int profit = 0;

		for (int i = 1; i < prices.length; i++) {
			int difference = prices[i] - mini;
			profit = Math.max(profit, difference);

			mini = Math.min(mini, prices[i]);
		}
		return profit;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BestTimeToBuyOrSellStock b = new BestTimeToBuyOrSellStock();
		int[] price = { 7, 1, 5, 3, 6, 4 };
		System.out.println(b.maxProfit(price));
	}
}
