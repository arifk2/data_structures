package com.rf.khan.api.iq.dp;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciSeriesRecursionMemoization {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Give input: ");
		int n = sc.nextInt();

		// Step 1
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);

		System.out.println(fib(n, dp));
		System.out.println();
	}

	private static int fib(int n, int[] dp) {
		// base case
		if (n <= 1)
			return n;

		// Step 3
		if (dp[n] != -1)
			return dp[n];

		// step 2
		dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
		return dp[n];
	}
}
