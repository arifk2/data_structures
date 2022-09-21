package com.rf.khan.api.iq.dp;

/**
 * https://leetcode.com/problems/wildcard-matching/
 * 
 * @author mkhan339
 *
 */
public class WildcardMatchingRecMem1BasedTabulation {
	/**
	 * This method is created to tell whether the wildcard pattern will match or not
	 * 
	 * @param s holds the information of the input string
	 * @param p holds the information of the pattern
	 * @return true/false
	 */
	public boolean isMatch(String s, String p) {
		return solvetabulation(s, p);
	}

	/**
	 * This method is created to solve using tabulation
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	boolean solvetabulation(String str, String pattern) {
		boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1];
		dp[0][0] = true;

		// catch
		for (int j = 1; j <= pattern.length(); j++) {
			boolean flag = true;
			for (int k = 1; k <= j; k++) {
				if (pattern.charAt(k - 1) != '*') {
					flag = false;
					break;
				}
			}
			dp[0][j] = flag;
		}

		for (int i = 1; i <= str.length(); i++) {
			for (int j = 1; j <= pattern.length(); j++) {

				if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (pattern.charAt(j - 1) == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[str.length()][pattern.length()];
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		WildcardMatchingRecMem1BasedTabulation r = new WildcardMatchingRecMem1BasedTabulation();
		System.out.println(r.isMatch("abcde", "a*cde"));
		System.out.println(r.isMatch("abcde", "p*cde"));
		System.out.println(r.isMatch("aab", "c*a*b"));
	}
}
