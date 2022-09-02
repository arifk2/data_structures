package com.rf.khan.api.iq.dp;

public class PartitionEqualSubsetSumTabulation {

	static int equalPartition(int N, int arr[]) {
		int total = 0;
		for (int i = 0; i < N; i++) {
			total += arr[i];
		}
		if (total % 2 != 0)
			return 0;

		if (solveRecursionTabulation(N, arr, total))
			return 1;

		return 0;
	}

	/**
	 * Solving using tabulation
	 * 
	 * @param n     size of array
	 * @param arr   array information
	 * @param total total sum in the array
	 * @return
	 */
	static boolean solveRecursionTabulation(int n, int[] arr, int total) {

		boolean[][] dp = new boolean[n + 1][total + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		for (int index = n - 1; index >= 0; index--) {
			for (int target = 0; target <= total / 2; target++) {

				boolean include = false;
				if (target - arr[index] >= 0)
					include = dp[index + 1][target - arr[index]];
				
				boolean exclude = dp[index + 1][target];

				dp[index][target] = include || exclude;
			}
		}
		return dp[0][total / 2];
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
