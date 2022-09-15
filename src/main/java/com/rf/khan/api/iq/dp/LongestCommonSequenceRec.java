package com.rf.khan.api.iq.dp;

/**
 * This class is created to solve the DP in string using recursion
 * 
 * @author mkhan339
 *
 */
public class LongestCommonSequenceRec {

	/**
	 * This method is created to get the longest common sequence using recursion
	 * 
	 * @param text1 holds the information of text1 input
	 * @param text2 holds the information of text2 input
	 * @return longest string
	 */
	public int longestCommonSubsequence(String text1, String text2) {

		return solveRecursion(0, 0, text1, text2);
	}

	/**
	 * This method is created to solve the problem using recursion
	 * 
	 * @param index1
	 * @param index2
	 * @param text1
	 * @param text2
	 * @return
	 */
	private int solveRecursion(int index1, int index2, String text1, String text2) {
		if (index1 >= text1.length() | index2 >= text2.length())
			return 0;

		int ans = 0;

		if (text1.charAt(index1) == text2.charAt(index2)) {
			ans += 1 + solveRecursion(index1 + 1, index2 + 1, text1, text2);
		} else {
			ans += Math.max(solveRecursion(index1 + 1, index2, text1, text2),
					solveRecursion(index1, index2 + 1, text1, text2));
		}

		return ans;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LongestCommonSequenceRec l = new LongestCommonSequenceRec();
		String text1 = "abcde";
		String text2 = "ace";
		System.out.println(l.longestCommonSubsequence(text1, text2));
	}
}
