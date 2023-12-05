package com.rf.khan.api.iq.dp;

import java.util.Arrays;

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
public class EditDistanceRecMem {

	/**
	 * This method is created to get the minimum distance to make word1 to word2
	 * 
	 * @param word1 holds the information of the word1
	 * @param word2 holds the information of the word2
	 * @return minimum cost
	 */
	public int minDistance(String word1, String word2) {

		int[][] dp = new int[word1.length()][word2.length()];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		return solveRecusionMem(word1, word2, 0, 0, dp);
	}

	/**
	 * This method is created to solve the problem using recursion + mem
	 * 
	 * @param word1 holds the information of word1
	 * @param word2 holds the information of word2
	 * @param i     index for word1
	 * @param j     index for word2
	 * @param dp    holds the information of the dp array
	 * @return minimum cost
	 */
	private int solveRecusionMem(String word1, String word2, int i, int j, int[][] dp) {
		// base case if the i and j get out of bound
		if (i == word1.length())
			return word2.length() - j;

		if (j == word2.length())
			return word1.length() - i;

		if (dp[i][j] != -1)
			return dp[i][j];

		int ans = 0;
		if (word1.charAt(i) == word2.charAt(j)) {
			return solveRecusionMem(word1, word2, i + 1, j + 1, dp);
		} else {
			// if not match the we need to perform insert, replace and delete and get the
			// minimum

			// insert
			int insertAns = 1 + solveRecusionMem(word1, word2, i, j + 1, dp);

			// delete
			int deleteAns = 1 + solveRecusionMem(word1, word2, i + 1, j, dp);

			// replace
			int replaceAns = 1 + solveRecusionMem(word1, word2, i + 1, j + 1, dp);

			ans = Math.min(Math.min(deleteAns, insertAns), replaceAns);
		}
		return dp[i][j] = ans;
	}

	/**
	 * This is a main method or driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String word1 = "horse", word2 = "ros";
		EditDistanceRecMem edit = new EditDistanceRecMem();
		System.out.println(edit.minDistance(word1, word2));
	}
}
