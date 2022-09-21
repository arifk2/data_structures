package com.rf.khan.api.iq.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/wildcard-matching/
 * 
 * @author mkhan339
 *
 */
public class WildcardMatchingRecMem1Based {
	/**
	 * This method is created to tell whether the wildcard pattern will match or not
	 * 
	 * @param s holds the information of the input string
	 * @param p holds the information of the pattern
	 * @return true/false
	 */
	public boolean isMatch(String s, String p) {
		int[][] dp = new int[s.length() + 1][p.length() + 1];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		return solveRecursionMem(s, p, s.length(), p.length(), dp);
	}

	/**
	 * Solving the problem using recursion + memoization
	 * 
	 * @param str     holds the information of the input string
	 * @param pattern holds the information of the pattern
	 * @param i       index of the input string
	 * @param j       index of the pattern string
	 * @param dp      holds the information of the dynamic array
	 * @return true/false
	 */
	private boolean solveRecursionMem(String str, String pattern, int i, int j, int[][] dp) {
		// base case
		if (i == 0 && j == 0) {
			return true;
		}
		if (i > 0 && j == 0)
			return false;

		if (i == 0 && j > 0) {
			for (int k = 1; k <= j; k++) {
				if (pattern.charAt(k-1) != '*')
					return false;
			}
			return true;
		}

		if (dp[i][j] != -1) {
			if (dp[i][j] == 1)
				return true;
			else
				return false;
		}

		// match
		boolean ans1 = false, ans2 = false, ans3 = false;

		if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
			ans1 = solveRecursionMem(str, pattern, i - 1, j - 1, dp);
		} else if (pattern.charAt(j - 1) == '*') {
			ans2 = (solveRecursionMem(str, pattern, i - 1, j, dp) || solveRecursionMem(str, pattern, i, j - 1, dp));
		} else {
			ans3 = false;
		}

		// building answer
		if (ans1 || ans2 || ans3) {
			dp[i][j] = 1;
			return true;
		} else {
			dp[i][j] = 0;
			return false;
		}
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		WildcardMatchingRecMem1Based r = new WildcardMatchingRecMem1Based();
		System.out.println(r.isMatch("abcde", "a*cde"));
		System.out.println(r.isMatch("abcde", "p*cde"));
		System.out.println(r.isMatch("aab", "c*a*b"));
	}
}
