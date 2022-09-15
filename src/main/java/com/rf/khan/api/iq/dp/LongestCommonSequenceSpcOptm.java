package com.rf.khan.api.iq.dp;

import org.bouncycastle.util.Arrays;

/**
 * This class is created to solve the DP in string using recursion + Memoization
 * 
 * @author mkhan339
 *
 */
public class LongestCommonSequenceSpcOptm {

	/**
	 * This method is created to get the longest common sequence using recursion
	 * 
	 * @param text1 holds the information of text1 input
	 * @param text2 holds the information of text2 input
	 * @return longest string
	 */
	public int longestCommonSubsequence(String text1, String text2) {

		return solveSpaceOptimization(text1, text2);
	}

	/**
	 * This method is created to solve the problem using tabulation
	 * 
	 * @param text1
	 * @param text2
	 * @return
	 */
	private int solveSpaceOptimization(String text1, String text2) {

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
		LongestCommonSequenceSpcOptm l = new LongestCommonSequenceSpcOptm();
		String text1 = "abcba";
		String text2 = "abcbcba";
		System.out.println(l.longestCommonSubsequence(text1, text2));
	}
}

//*****************C++*******************************************
//
//class Solution {
//public:
//    int longestCommonSubsequence(string text1, string text2) {
//        return solveSpaceOptimization(text1, text2);
//    }
//    
//     int solveSpaceOptimization(string text1, string text2) {
//         
//        vector<int> curr (text2.length() +1, 0);
//        vector<int> next (text2.length() +1, 0);
//         
//		for (int index1 = text1.length() - 1; index1 >= 0; index1--) {
//			for (int index2 = text2.length() - 1; index2 >= 0; index2--) {
//				int ans = 0;
//				if (text1[index1] == text2[index2]) {
//					ans += 1 + next[index2 + 1];
//				} else {
//					ans += max(next[index2], curr[index2 + 1]);
//				}
//				curr[index2] = ans;
//			}
//			next = curr;
//		}
//		return next[0];
//	}
//};
//
//*****************C++*******************************************
