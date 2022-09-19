package com.rf.khan.api.iq.dp;

/**
 * This class is created to get the longest Palindromic subsequences using
 * recursion
 * 
 * @author mkhan339
 *
 */
public class LongestPalindromicSubsequencesRec {

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

		return solveRecursion(s, reverseStr, 0, 0);
	}

	/**
	 * This method is created to solve the problem using recursion
	 * 
	 * @param text1  holds the information of the given input text
	 * @param text2  holds the information of the reversed input text
	 * @param index1 holds the information of the index of text1
	 * @param index2 holds the information of the index of text2
	 * @return result
	 */
	private int solveRecursion(String text1, String text2, int index1, int index2) {
		// base case
		if (index1 == text1.length() || index2 == text2.length())
			return 0;

		int ans = 0;
		if (text1.charAt(index1) == text2.charAt(index2)) {
			ans += 1 + solveRecursion(text1, text2, index1 + 1, index2 + 1);
		} else {
			ans += Math.max(solveRecursion(text1, text2, index1 + 1, index2),
					solveRecursion(text1, text2, index1, index2 + 1));
		}
		return ans;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "bbbab";
		LongestPalindromicSubsequencesRec l = new LongestPalindromicSubsequencesRec();
		System.out.println(l.longestPalindromeSubseq(str));
	}
}
