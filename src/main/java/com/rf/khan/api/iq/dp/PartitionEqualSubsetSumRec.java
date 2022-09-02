package com.rf.khan.api.iq.dp;

public class PartitionEqualSubsetSumRec {

	int equalPartition(int N, int arr[]) {
		int total = 0;
		for (int i = 0; i < N; i++) {
			total += arr[i];
		}
		if (total % 2 != 0)
			return 0;

		int target = total / 2;

		if (solveRecursion(0, N, arr, target))
			return 1;

		return 0;
	}

	/**
	 * Solving using recursion
	 * 
	 * @param index  holds information of the index
	 * @param n      total size
	 * @param arr    holds array information
	 * @param target target value to make
	 * @return true/false
	 */
	private boolean solveRecursion(int index, int n, int[] arr, int target) {
		if (index >= n)
			return false;

		if (target < 0)
			return false;

		if (target == 0)
			return true;

		boolean include = solveRecursion(index + 1, n, arr, target - arr[index]);
		boolean exclude = solveRecursion(index + 1, n, arr, target);

		return exclude || include;
	}

	/**
	 * This is driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PartitionEqualSubsetSumRec p = new PartitionEqualSubsetSumRec();
		int N = 4;
		int[] arr = { 1, 5, 11, 5 };

		int N1 = 3;
		int[] arr1 = { 1, 3, 5 };

		System.out.println(p.equalPartition(N, arr));
		System.out.println(p.equalPartition(N1, arr1));
	}
}
