package com.rf.khan.api.iq.greedy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is created to solve the problem of the shop in the candy store
 * 
 * 
 * Approach:
 * 
 * Sort the array
 * 
 * To get min amount : purchase minimum and free maximum
 * 
 * To get max amount : purchase maximum and free minimum
 * 
 * @author mkhan339
 *
 */
public class ShopInCandyStoreGFG {

	/**
	 * This method is created to get the min and max amount to purchase all candy
	 * from the store
	 * 
	 * @param candies holds the information of the candy prices
	 * @param N       total no of candies
	 * @param K       total free candy
	 * @return minimum and maximum amount
	 */
	static ArrayList<Integer> candyStore(int candies[], int N, int K) {
		ArrayList<Integer> ans = new ArrayList<>();

		// Sort array
		Arrays.sort(candies);

		int minAmount = 0;
		int buy = 0;
		int free = N - 1;

		while (buy <= free) {
			minAmount += candies[buy];
			buy++;
			free = free - K;
		}

		int maxAmount = 0;

		buy = N - 1;
		free = 0;

		while (buy >= free) {
			maxAmount += candies[buy];
			buy--;
			free = free + K;
		}

		ans.add(minAmount);
		ans.add(maxAmount);

		return ans;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 10;
		int K = 1;
		int candies[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		System.out.println(candyStore(candies, N, K));
	}
}
