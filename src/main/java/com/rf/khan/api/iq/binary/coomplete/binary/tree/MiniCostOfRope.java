package com.rf.khan.api.iq.binary.coomplete.binary.tree;

public class MiniCostOfRope {
	// Function to return the minimum cost of connecting the ropes.
	private long minCost(long arr[], int n) {
		java.util.PriorityQueue<Long> p = new java.util.PriorityQueue<Long>();
		for (int i = 0; i < n; i++) {
			p.add(arr[i]);
		}
		long ans = 0;
		while (p.size() > 1) {
			long a = p.peek();
			p.poll();
			long b = p.poll();
			long sum = a + b;
			p.add(sum);
			ans = ans + sum;
		}
		return ans;
	}

	public static void main(String[] args) {
		MiniCostOfRope m = new MiniCostOfRope();

		int n = 4;
		long arr[] = { 4, 3, 2, 6 };
		System.out.println(m.minCost(arr, n));

		n = 5;
		long[] arr2 = { 4, 2, 7, 6, 9 };
		System.out.println(m.minCost(arr2, n));
	}
}
