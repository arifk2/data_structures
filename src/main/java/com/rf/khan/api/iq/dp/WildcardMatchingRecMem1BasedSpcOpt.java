package com.rf.khan.api.iq.dp;

/**
 * https://leetcode.com/problems/wildcard-matching/
 * 
 * @author mkhan339
 *
 */
public class WildcardMatchingRecMem1BasedSpcOpt {
	/**
	 * This method is created to tell whether the wildcard pattern will match or not
	 * 
	 * @param s holds the information of the input string
	 * @param p holds the information of the pattern
	 * @return true/false
	 */
	public boolean isMatch(String s, String p) {
		return solveSpaceOptmization(s, p);
	}

	/**
	 * This method is created to solve using Space Optmization
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	boolean solveSpaceOptmization(String str, String pattern) {
		// boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1];

		boolean[] prev = new boolean[pattern.length() + 1];
		boolean[] curr = new boolean[pattern.length() + 1];

		prev[0] = true;

		// catch
		for (int j = 1; j <= pattern.length(); j++) {
			boolean flag = true;
			for (int k = 1; k <= j; k++) {
				if (pattern.charAt(k - 1) != '*') {
					flag = false;
					break;
				}
			}
			prev[j] = flag;
		}

		for (int i = 1; i <= str.length(); i++) {
			for (int j = 1; j <= pattern.length(); j++) {

				if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
					curr[j] = prev[j - 1];
				} else if (pattern.charAt(j - 1) == '*') {
					curr[j] = prev[j] || curr[j - 1];
				} else {
					curr[j] = false;
				}
			}
			prev = curr;
		}
		return prev[pattern.length()];
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		WildcardMatchingRecMem1BasedSpcOpt r = new WildcardMatchingRecMem1BasedSpcOpt();
		System.out.println(r.isMatch("abcde", "a*cde"));
		System.out.println(r.isMatch("abcde", "p*cde"));
		System.out.println(r.isMatch("aab", "c*a*b"));
	}
}

//******************************C++***********************************
// class Solution {
//public:
//    bool isMatch(string s, string p) {
//        return solveSpaceOptmization(s, p);
//    }
//    
//	bool solveSpaceOptmization(string str, string pattern) {
//		
//		vector<bool> prev (pattern.length() + 1,0);
//		vector<bool> curr (pattern.length() + 1, 0);
//
//		prev[0] = true;
//
//		// catch
//		for (int j = 1; j <= pattern.length(); j++) {
//			bool flag = true;
//			for (int k = 1; k <= j; k++) {
//				if (pattern[k - 1] != '*') {
//					flag = false;
//					break;
//				}
//			}
//			prev[j] = flag;
//		}
//
//		for (int i = 1; i <= str.length(); i++) {
//			for (int j = 1; j <= pattern.length(); j++) {
//
//				if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '?') {
//					curr[j] = prev[j - 1];
//				} else if (pattern[j - 1] == '*') {
//					curr[j] = prev[j] || curr[j - 1];
//				} else {
//					curr[j] = false;
//				}
//			}
//			prev = curr;
//		}
//		return prev[pattern.length()];
//	}
//};
//
//******************************C++***********************************
