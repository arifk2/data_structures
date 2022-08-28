package com.rf.khan.api.gg.array;

import java.util.PriorityQueue;

public class MinimumProduct {

	private static int minProduct(int[] arr, int n, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++)
			pq.add(arr[i]);

		int count = 0;
		int ans = 1;
		while (!pq.isEmpty() && count < k) {
			ans = ans * pq.peek();
			pq.poll();
			count++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 198, 76, 544, 123, 154, 675 };
		int k = 2;
		System.out.println(minProduct(arr, arr.length, k));
	}
}
