package com.rf.khan.api.iq.dp;

/**
 * This class is created to get the best time to buy stock or sell stock, if the
 * transaction amount is added in the transaction.
 * 
 * @author mkhan339
 *
 */
public class BestTimeToBuyOrSellStockVTabulationSpcOpt {

	/**
	 * This method is created to solve using space optimization
	 * 
	 * @param prices holds the information of the prices
	 * @param fee    holds the information of the fee
	 * @return maximum profit
	 */
	public int maxProfit(int[] prices, int fee) {

		return solveTabulationSpcOPt(prices, fee);
	}

	/**
	 * This method is created to solve the problem using solve tabulation using
	 * space optimization
	 * 
	 * @param prices holds the information of the prices array
	 * @param fee    holds the information of the transaction fee
	 * @return return profit amount
	 */
	private int solveTabulationSpcOPt(int[] prices, int fee) {
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
					int sellKaro = +prices[index] + next[1] - fee;
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
		int[] prices = { 1, 3, 2, 8, 4, 9 };
		int fee = 2;
		BestTimeToBuyOrSellStockVTabulationSpcOpt b = new BestTimeToBuyOrSellStockVTabulationSpcOpt();

		System.out.println(b.maxProfit(prices, fee));
	}

}
