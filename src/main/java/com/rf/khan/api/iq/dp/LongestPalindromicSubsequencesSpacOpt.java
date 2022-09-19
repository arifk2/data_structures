package com.rf.khan.api.iq.dp;

/**
 * This class is created to get the longest Palindromic subsequences using space
 * optimization
 * 
 * @author mkhan339
 *
 */
public class LongestPalindromicSubsequencesSpacOpt {

	/**
	 * This method is created to provide the input and get the result
	 * 
	 * @param s holds the information of the input String
	 * @return largest palindromic length;
	 */
	public int longestPalindromeSubseq(String s) {
		String reverseStr = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reverseStr = reverseStr + s.charAt(i);
		}

		return solveSpaceOptmization(s, reverseStr);
	}

	/**
	 * This method is created to solve the problem using space optimization
	 * 
	 * @param text1 holds the information of the given input text
	 * @param text2 holds the information of the reversed input text
	 * @return result
	 */
	private int solveSpaceOptmization(String text1, String text2) {

		int[] curr = new int[text2.length() + 1];
		int[] next = new int[text2.length() + 1];

		for (int index1 = text1.length() - 1; index1 >= 0; index1--) {
			for (int index2 = text2.length() - 1; index2 >= 0; index2--) {
				int ans = 0;
				if (text1.charAt(index1) == text2.charAt(index2)) {
					ans += 1 + next[index2 + 1];
				} else {
					ans += Math.max(next[index2], curr[index2 + 1]);
				}
				curr[index2] = ans;
			}
			next = curr;
		}
		return next[0];
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "bbbab";
		LongestPalindromicSubsequencesSpacOpt l = new LongestPalindromicSubsequencesSpacOpt();
		System.out.println(l.longestPalindromeSubseq(str));
	}
}
