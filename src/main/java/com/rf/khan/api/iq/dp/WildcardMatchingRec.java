package com.rf.khan.api.iq.dp;

/**
 * https://leetcode.com/problems/wildcard-matching/
 * 
 * @author mkhan339
 *
 */
public class WildcardMatchingRec {
	/**
	 * This method is created to tell whether the wildcard pattern will match or not
	 * 
	 * @param s holds the information of the input string
	 * @param p holds the information of the pattern
	 * @return true/false
	 */
	public boolean isMatch(String s, String p) {
		return solveRecursion(s, p, s.length() - 1, p.length() - 1);
	}

	/**
	 * Solving the problem using recursion
	 * 
	 * @param str     holds the information of the input string
	 * @param pattern holds the information of the pattern
	 * @param i       index of the input string
	 * @param j       index of the pattern string
	 * @return true/false
	 */
	private boolean solveRecursion(String str, String pattern, int i, int j) {
		// base case
		if (i < 0 && j < 0) {
			return true;
		}
		if (i >= 0 && j < 0)
			return false;

		if (i < 0 && j >= 0) {
			for (int k = 0; k <= j; k++) {
				if (pattern.charAt(k) != '*')
					return false;
			}
			return true;
		}

		// match
		if (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?') {
			return solveRecursion(str, pattern, i - 1, j - 1);
		} else if (pattern.charAt(j) == '*') {
			return (solveRecursion(str, pattern, i - 1, j) || solveRecursion(str, pattern, i, j - 1));
		} else {
			return false;
		}
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		WildcardMatchingRec r = new WildcardMatchingRec();
		System.out.println(r.isMatch("abcde", "a*cde"));
		System.out.println(r.isMatch("abcde", "p*cde"));
		System.out.println(r.isMatch("aab", "c*a*b"));
	}
}
