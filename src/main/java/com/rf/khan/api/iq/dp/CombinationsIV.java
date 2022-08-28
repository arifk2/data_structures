package com.rf.khan.api.iq.dp;

/**
 * https://www.codingninjas.com/codestudio/problems/number-of-ways_3755252?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar
 * 
 * @author mkhan339
 *
 */
public class CombinationsIV {
	public static int findWays(int num[], int tar) {
		return solveRecursion(num, tar);
	}

	private static int solveRecursion(int[] num, int tar) {
		// base case
		if (tar < 0)
			return 0;
		if (tar == 0)
			return 1;

		int ans = 0;
		for (int i = 0; i < num.length; i++) {
			ans += solveRecursion(num, tar - num[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 5 };
		int tar = 5;
		System.out.println(findWays(num, tar));
	}
}
