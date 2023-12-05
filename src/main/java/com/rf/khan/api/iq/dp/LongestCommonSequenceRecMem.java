package com.rf.khan.api.iq.dp;

import java.util.Arrays;

/**
 * This class is created to solve the DP in string using recursion + Memoization
 * 
 * @author mkhan339
 *
 */
public class LongestCommonSequenceRecMem {

	/**
	 * This method is created to get the longest common sequence using recursion
	 * 
	 * @param text1 holds the information of text1 input
	 * @param text2 holds the information of text2 input
	 * @return longest string
	 */
	public int longestCommonSubsequence(String text1, String text2) {
		int[][] dp = new int[text1.length()][text2.length()];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		return solveRecursionMem(0, 0, text1, text2, dp);
	}

	/**
	 * This method is created to solve the problem using recursion +Memoization
	 * 
	 * @param index1
	 * @param index2
	 * @param text1
	 * @param text2
	 * @return
	 */
	private int solveRecursionMem(int index1, int index2, String text1, String text2, int[][] dp) {
		if (index1 >= text1.length() | index2 >= text2.length())
			return 0;

		int ans = 0;

		if (dp[index1][index2] != -1)
			return dp[index1][index2];

		if (text1.charAt(index1) == text2.charAt(index2)) {
			ans += 1 + solveRecursionMem(index1 + 1, index2 + 1, text1, text2, dp);
		} else {
			ans += Math.max(solveRecursionMem(index1 + 1, index2, text1, text2, dp),
					solveRecursionMem(index1, index2 + 1, text1, text2, dp));
		}

		return dp[index1][index2] = ans;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LongestCommonSequenceRecMem l = new LongestCommonSequenceRecMem();
		String text1 = "abcde";
		String text2 = "ace";
		System.out.println(l.longestCommonSubsequence(text1, text2));
	}
}
