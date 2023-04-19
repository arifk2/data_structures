package com.rf.khan.api.leetcode;

public class MergeStringsLC1768 {

	public static void main(String[] args) {
		MergeStringsLC1768 m = new MergeStringsLC1768();
		System.out.println(m.mergeAlternately("abc", "pqr"));
		System.out.println(m.mergeAlternately("ab", "pqrs"));
		System.out.println(m.mergeAlternately("abcd", "pq"));

		System.out.println("*".repeat(50));
		System.out.println(m.mergeAlternately1Ptr("abc", "pqr"));
		System.out.println(m.mergeAlternately1Ptr("ab", "pqrs"));
		System.out.println(m.mergeAlternately1Ptr("abcd", "pq"));
	}

	/**
	 * This method is created to merger two string using two pointer
	 * 
	 * @param word1 holds the information of the word1
	 * @param word2 holds the information of the word2
	 * @return merged string
	 */
	public String mergeAlternately(String word1, String word2) {
		StringBuilder result = new StringBuilder();
		int word1Length = word1.length();
		int word2Length = word2.length();

		int i = 0, j = 0;
		while (i < word1Length || j < word2Length) {
			if (i < word1Length) {
				result.append(word1.charAt(i++));
			}

			if (j < word2Length) {
				result.append(word2.charAt(j++));
			}
		}

		return result.toString();
	}

	/**
	 * This method is created to get the merge string using one pointer
	 * 
	 * @param word1 holds the information of the word1
	 * @param word2 holds the information of the word2
	 * @return merged string
	 */
	public String mergeAlternately1Ptr(String word1, String word2) {
		StringBuilder result = new StringBuilder();
		int n = word1.length();
		int m = word2.length();

		for (int i = 0; i < Math.max(n, m); i++) {
			if (i < n) {
				result.append(word1.charAt(i));
			}

			if (i < m) {
				result.append(word2.charAt(i));
			}
		}

		return result.toString();
	}
}
