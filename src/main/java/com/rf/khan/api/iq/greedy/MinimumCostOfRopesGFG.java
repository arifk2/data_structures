package com.rf.khan.api.iq.greedy;

import java.util.PriorityQueue;

/**
 * 
 * @author mkhan339
 *
 */
public class MinimumCostOfRopesGFG {

	/**
	 * This method is created to get the minimum cost to create one rope
	 * 
	 * @param arr holds the information of the array
	 * @param n   holds the information of the number of the ropes
	 * @return min cost
	 */
	long minCost(long arr[], int n) {

		PriorityQueue<Long> pq = new PriorityQueue<>();

		long cost = 0;

		// add all the element in he priority queue
		for (int i = 0; i < n; i++)
			pq.add(arr[i]);

		while (pq.size() > 1) {
			long first = pq.poll();
			long second = pq.poll();
			long mergeLength = first + second;

			cost = cost + mergeLength;

			pq.add(mergeLength);
		}

		return cost;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 4;
		long arr[] = { 4, 3, 2, 6 };

		MinimumCostOfRopesGFG m = new MinimumCostOfRopesGFG();
		System.out.println(m.minCost(arr, n));
	}
}
