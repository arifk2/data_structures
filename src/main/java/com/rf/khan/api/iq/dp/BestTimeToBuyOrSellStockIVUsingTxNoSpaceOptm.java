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
 * we are taking 2*k as a operation number, if the operation number ie even then
 * buy, or else of operation number is odd then sell
 * 
 * @author mkhan339
 *
 */
public class BestTimeToBuyOrSellStockIVUsingTxNoSpaceOptm {

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
	 * This method is created to solve the problem using Tabulation
	 * 
	 * @param prices holds the information of the prices array
	 * @param k      tell number of the transaction
	 * @return maximum profit
	 */
	private int solveSpaceOptmization(int[] prices, int k) {
		int n = prices.length;

		int[] curr = new int[2 * k + 1];
		int[] next = new int[2 * k + 1];

		for (int index = n - 1; index >= 0; index--) {
			for (int operationNo = 0; operationNo < 2 * k; operationNo++) {
				int profit = 0;
				if (operationNo % 2 == 0) {
					// even - buy allowed
					int buyKaro = -prices[index] + next[operationNo + 1];
					int skipKaro = 0 + next[operationNo];

					profit = Math.max(skipKaro, buyKaro);

				} else {
					// off - sell allowed
					int sellKaro = +prices[index] + next[operationNo + 1];
					int skipKaro = 0 + next[operationNo];

					profit = Math.max(sellKaro, skipKaro);
				}
				curr[operationNo] = profit;
			}
			next = curr;
		}
		return curr[0];
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int k = 2;
		BestTimeToBuyOrSellStockIVUsingTxNoSpaceOptm b = new BestTimeToBuyOrSellStockIVUsingTxNoSpaceOptm();
		System.out.println(b.maxProfit(k, prices));
	}
}
