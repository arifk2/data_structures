package com.rf.khan.api.iq.dp;

import java.util.Arrays;

/**
 * Solving the partition problem in bottom up approach - tabulation
 * 
 * @author mkhan339
 *
 */
public class PartitionEqualSubsetSumRecMem {

	static int equalPartition(int N, int arr[]) {
		int total = 0;
		for (int i = 0; i < N; i++) {
			total += arr[i];
		}
		if (total % 2 != 0)
			return 0;

		int target = total / 2;

		int[][] dp = new int[N][target + 1];

		for (int[] d : dp)
			Arrays.fill(d, -1);

		if (solveRecursionMem(0, N, arr, target, dp))
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
	static boolean solveRecursionMem(int index, int n, int[] arr, int target, int[][] dp) {
		if (index >= n)
			return false;

		if (target < 0)
			return false;

		if (target == 0)
			return true;

		if (dp[index][target] != -1) {
			if (dp[index][target] == 1)
				return true;
			else {
				return false;
			}
		}

		boolean include = solveRecursionMem(index + 1, n, arr, target - arr[index], dp);
		boolean exclude = solveRecursionMem(index + 1, n, arr, target, dp);

		if (include || exclude) {
			dp[index][target] = 1;
			return true;
		} else {
			dp[index][target] = 0;
			return false;
		}
	}

	/**
	 * This is driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 4;
		int[] arr = { 1, 5, 11, 5 };

		int N1 = 3;
		int[] arr1 = { 1, 3, 5 };

		System.out.println(equalPartition(N, arr));
		System.out.println(equalPartition(N1, arr1));
	}
}
