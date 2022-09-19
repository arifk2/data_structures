package com.rf.khan.api.iq.dp;

import org.bouncycastle.util.Arrays;

/**
 * This class is created to get the longest Palindromic subsequences using
 * recursion + memoization
 * 
 * @author mkhan339
 *
 */
public class LongestPalindromicSubsequencesRecMem {

	/**
	 * This method is created to provide th input and get the result
	 * 
	 * @param s holds the information of the input String
	 * @return largest palindromic length;
	 */
	public int longestPalindromeSubseq(String s) {
		String reverseStr = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reverseStr = reverseStr + s.charAt(i);
		}

		int[][] dp = new int[s.length() + 1][s.length() + 1];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		return solveRecursionMem(s, reverseStr, 0, 0, dp);
	}

	/**
	 * This method is created to solve the problem using recursion + memoization
	 * 
	 * @param text1  holds the information of the given input text
	 * @param text2  holds the information of the reversed input text
	 * @param index1 holds the information of the index of text1
	 * @param index2 holds the information of the index of text2
	 * @param holds  the information of the dp array
	 * @return result
	 */
	private int solveRecursionMem(String text1, String text2, int index1, int index2, int[][] dp) {
		// base case
		if (index1 == text1.length() || index2 == text2.length())
			return 0;

		if (dp[index1][index2] != -1)
			return dp[index1][index2];

		int ans = 0;
		if (text1.charAt(index1) == text2.charAt(index2)) {
			ans += 1 + solveRecursionMem(text1, text2, index1 + 1, index2 + 1, dp);
		} else {
			ans += Math.max(solveRecursionMem(text1, text2, index1 + 1, index2, dp),
					solveRecursionMem(text1, text2, index1, index2 + 1, dp));
		}
		return dp[index1][index2] = ans;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "bbbab";
		LongestPalindromicSubsequencesRecMem l = new LongestPalindromicSubsequencesRecMem();
		System.out.println(l.longestPalindromeSubseq(str));
	}
}
