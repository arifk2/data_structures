package com.rf.khan.api.leetcode;

public class BestTimeToBuyStockLC121 {

	public static void main(String[] args) {
		BestTimeToBuyStockLC121 b = new BestTimeToBuyStockLC121();
		System.out.println(b.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

	public int maxProfit(int[] prices) {
		int sellingPrice = 0;
		int maxProfit = 0;

		for (int i = prices.length - 1; i >= 0; i--) {
			sellingPrice = Math.max(sellingPrice, prices[i]);
			maxProfit = Math.max(maxProfit, sellingPrice - prices[i]);
		}

		return maxProfit;
	}
}
