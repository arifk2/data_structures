package com.rf.khan.api.iq.trie;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] arr, int n) {
		String ans = "";

		for (int i = 0; i < arr[0].length(); i++) {
			char ch = arr[0].charAt(i);

			boolean match = true;

			for (int j = 1; j < n; j++) {
				if (arr[j].length() < i || ch != arr[j].charAt(i)) {
					match = false;
					break;
				}
			}
			if (match == false)
				break;
			else
				ans = ans + ch;
		}
		return ans;
	}

	public static void main(String[] args) {
		LongestCommonPrefix l = new LongestCommonPrefix();
		String[] arr = { "coding", "codehelp", "codingninja", "coders" };
		int n = 4;

		System.out.println(l.longestCommonPrefix(arr, n));
	}
}
