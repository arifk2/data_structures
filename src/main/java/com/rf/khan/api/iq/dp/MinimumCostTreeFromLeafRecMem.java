package com.rf.khan.api.iq.dp;

import java.util.HashMap;
import java.util.Map;

import org.bouncycastle.util.Arrays;

public class MinimumCostTreeFromLeafRecMem {

	/**
	 * This method is created to get the minimum cost from the leaf value
	 * 
	 * @param arr
	 * @return
	 */
	public int mctFromLeafValues(int[] arr) {
		Map<Pair, Integer> maxiInRange = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			maxiInRange.put(new Pair(i, i), arr[i]);

			for (int j = i + 1; j < arr.length; j++) {
				maxiInRange.put(new Pair(i, j), Math.max(arr[j], maxiInRange.get(new Pair(i, j - 1))));
			}
		}

		int n = arr.length;
		int[][] dp = new int[n + 1][n + 1];
		for (int[] ar : dp)
			Arrays.fill(ar, -1);

		return solveRecursionMem(arr, maxiInRange, 0, arr.length - 1, dp);
	}

	/**
	 * This method is created to solve the problem using recursion + memoization
	 * 
	 * @param arr         holds the information of the array
	 * @param maxiInRange holds the information of the max number within the range
	 * @param left        holds the information of the left index
	 * @param right       holds the information of the right index
	 * @return
	 */
	private int solveRecursionMem(int[] arr, Map<Pair, Integer> maxiInRange, int left, int right, int[][] dp) {
		if (left == right)
			return 0;

		if (dp[left][right] != -1)
			return dp[left][right];

		int ans = Integer.MAX_VALUE;
		for (int i = left; i < right; i++) {
			int temp = maxiInRange.get(new Pair(left, i)) * maxiInRange.get(new Pair(i + 1, right));

			ans = Math.min(ans, temp + solveRecursionMem(arr, maxiInRange, left, i, dp)
					+ solveRecursionMem(arr, maxiInRange, i + 1, right, dp));
		}

		return dp[left][right] = ans;
	}

	/**
	 * Driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumCostTreeFromLeafRecMem m = new MinimumCostTreeFromLeafRecMem();
		int arr[] = { 6, 2, 4 };

		System.out.println(m.mctFromLeafValues(arr));
	}
}
