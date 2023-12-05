package com.rf.khan.api.iq.dp;

/**
 * This class is created to solve the DP in string using recursion + Memoization
 * 
 * @author mkhan339
 *
 */
public class LongestCommonSequenceTab {

	/**
	 * This method is created to get the longest common sequence using recursion
	 * 
	 * @param text1 holds the information of text1 input
	 * @param text2 holds the information of text2 input
	 * @return longest string
	 */
	public int longestCommonSubsequence(String text1, String text2) {

		return solveRecursionTab(text1, text2);
	}

	/**
	 * This method is created to solve the problem using tabulation
	 * 
	 * @param text1
	 * @param text2
	 * @return
	 */
	private int solveRecursionTab(String text1, String text2) {
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];

		for (int index1 = text1.length() - 1; index1 >= 0; index1--) {
			for (int index2 = text2.length() - 1; index2 >= 0; index2--) {
				int ans = 0;
				if (text1.charAt(index1) == text2.charAt(index2)) {
					ans += 1 + dp[index1 + 1][index2 + 1];
				} else {
					ans += Math.max(dp[index1 + 1][index2], dp[index1][index2 + 1]);
				}

				dp[index1][index2] = ans;
			}
		}

		return dp[0][0];
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LongestCommonSequenceTab l = new LongestCommonSequenceTab();
		String text1 = "abcde";
		String text2 = "ace";
		System.out.println(l.longestCommonSubsequence(text1, text2));
	}
}
