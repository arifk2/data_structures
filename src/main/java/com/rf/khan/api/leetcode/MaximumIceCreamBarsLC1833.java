package com.rf.khan.api.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumIceCreamBarsLC1833 {
	public static void main(String[] args) {
		int[] costs = { 1, 3, 2, 4, 1 };
		int coins = 7;

		MaximumIceCreamBarsLC1833 max = new MaximumIceCreamBarsLC1833();
		System.out.println(max.maxIceCream(costs, coins));
		System.out.println(max.maxIceCream(new int[] { 10, 6, 8, 7, 7, 8 }, 5));

		System.out.println(max.maxIceCreamOpt(new int[] { 10, 6, 8, 7, 7, 8 }, 5));
		System.out.println(max.maxIceCreamOpt(costs, coins));
	}

	public int maxIceCream(int[] costs, int coins) {
		int iceCreamCount = 0;
		// Step1: create a max heap, and insert all cost increase into it
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int cost : costs)
			pq.add(cost);

		// Step2: get the max value from the pq and check if it is equal to then save
		// and return

		while (!pq.isEmpty() && coins != 0) {
			int maxCost = pq.poll();
			if (coins >= maxCost) {
				coins -= maxCost;
				iceCreamCount++;
			}
		}

		return iceCreamCount;
	}

	public int maxIceCreamOpt(int[] costs, int coins) {
		int iceCreamCount = 0;
		// Step1: sort the array
		Arrays.sort(costs);

		// Step2: get the max value from the pq and check if it is equal to then save
		// and return

		for (int index = 0; index < costs.length && coins != 0; index++) {
			if (coins >= costs[index]) {
				coins -= costs[index];
				iceCreamCount++;
			}
		}

		return iceCreamCount;
	}

}
