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
public class EditDistanceSpcOpt {

	/**
	 * This method is created to get the minimum distance to make word1 to word2
	 * 
	 * @param word1 holds the information of the word1
	 * @param word2 holds the information of the word2
	 * @return minimum cost
	 */
	public int minDistance(String word1, String word2) {

		return solveSpcOpt(word1, word2);
	}

	/**
	 * This method is created to solve the problem using space optimization
	 * 
	 * @param word1 holds the information of word1
	 * @param word2 holds the information of word2
	 * @return minimum cost
	 */
	private int solveSpcOpt(String word1, String word2) {
		// create dp array
		int[] curr = new int[word2.length() + 1];
		int[] next = new int[word1.length() + 1];

		// base case analyze
		for (int j = 0; j < word2.length(); j++) {
			next[j] = word2.length() - j;
		}

		for (int i = word1.length() - 1; i >= 0; i--) {
			for (int j = word2.length() - 1; j >= 0; j--) {

				// catch here -> got from the base case
				curr[word2.length()] = word1.length() - i;

				int ans = 0;
				if (word1.charAt(i) == word2.charAt(j)) {
					ans = next[j + 1];
				} else {
					// if not match the we need to perform insert, replace and delete and get the
					// minimum

					// insert
					int insertAns = 1 + curr[j + 1];

					// delete
					int deleteAns = 1 + next[j];

					// replace
					int replaceAns = 1 + next[j + 1];

					ans = Math.min(Math.min(deleteAns, insertAns), replaceAns);
				}
				curr[j] = ans;
			}
			next = curr;
		}
		return next[0];
	}

	/**
	 * This is a main method or driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String word1 = "horse", word2 = "ros";
		EditDistanceSpcOpt edit = new EditDistanceSpcOpt();
		System.out.println(edit.minDistance(word1, word2));
	}
}

//********************C++***************************
//class Solution {
//public:
//    int minDistance(string word1, string word2) {
//       
//        if(word1.length() == 0)
//            return word2.length();
//        if(word2.length() == 0)
//            return word1.length();
//        
//        return solveSpcOpt(word1, word2);
//    }
//    
//     int solveSpcOpt(string word1, string word2) {
//		// create dp array
//		vector<int> curr (word2.length() + 1, 0);
//		vector<int> next (word1.length() + 1, 0);
//
//		// base case analyze
//		for (int j = 0; j < word2.length(); j++) {
//			next[j] = word2.length() - j;
//		}
//
//		for (int i = word1.length() - 1; i >= 0; i--) {
//			for (int j = word2.length() - 1; j >= 0; j--) {
//
//				// catch here -> got from the base case
//				curr[word2.length()] = word1.length() - i;
//
//				int ans = 0;
//				if (word1[i] == word2[j]) {
//					ans = next[j + 1];
//				} else {
//					// if not match the we need to perform insert, replace and delete and get the
//					// minimum
//
//					// insert
//					int insertAns = 1 + curr[j + 1];
//
//					// delete
//					int deleteAns = 1 + next[j];
//
//					// replace
//					int replaceAns = 1 + next[j + 1];
//
//					ans = min(insertAns, min(deleteAns, replaceAns));
//				}
//				curr[j] = ans;
//			}
//			next = curr;
//		}
//		return next[0];
//	}
//};
//
//********************C++***************************