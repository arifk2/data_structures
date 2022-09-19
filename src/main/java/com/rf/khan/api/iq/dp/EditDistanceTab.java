package com.rf.khan.api.iq.dp;

/**
 * This class is created to find the minimum cost to make word1 as word2, (edit
 * delete and replace cost 1)
 * 
 * 
 * https://leetcode.com/problems/edit-distance/
 * 
 * LC-72
 * 
 * Example
 * 
 * Input: word1 = "horse", word2 = "ros" Output: 3 Explanation: horse -> rorse
 * (replace 'h' with 'r') rorse -> rose (remove 'r') rose -> ros (remove 'e')
 * 
 * @author mkhan339
 *
 */
public class EditDistanceTab {

	/**
	 * This method is created to get the minimum distance to make word1 to word2
	 * 
	 * @param word1 holds the information of the word1
	 * @param word2 holds the information of the word2
	 * @return minimum cost
	 */
	public int minDistance(String word1, String word2) {

		return solveTab(word1, word2);
	}

	/**
	 * This method is created to solve the problem using tabulation - bottom down
	 * 
	 * @param word1 holds the information of word1
	 * @param word2 holds the information of word2
	 * @return minimum cost
	 */
	private int solveTab(String word1, String word2) {
		// create dp array
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];

		// base case analyze
		for (int j = 0; j < word2.length(); j++) {
			dp[word1.length()][j] = word2.length() - j;
		}

		for (int i = 0; i < word1.length(); i++) {
			dp[i][word2.length()] = word1.length() - i;
		}

		for (int i = word1.length() - 1; i >= 0; i--) {
			for (int j = word2.length() - 1; j >= 0; j--) {

				int ans = 0;
				if (word1.charAt(i) == word2.charAt(j)) {
					ans = dp[i + 1][j + 1];
				} else {
					// if not match the we need to perform insert, replace and delete and get the
					// minimum

					// insert
					int insertAns = 1 + dp[i][j + 1];

					// delete
					int deleteAns = 1 + dp[i + 1][j];

					// replace
					int replaceAns = 1 + dp[i + 1][j + 1];

					ans = Math.min(Math.min(deleteAns, insertAns), replaceAns);
				}
				dp[i][j] = ans;
			}
		}
		return dp[0][0];
	}

	/**
	 * This is a main method or driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String word1 = "horse", word2 = "ros";
		EditDistanceTab edit = new EditDistanceTab();
		System.out.println(edit.minDistance(word1, word2));
	}
}
