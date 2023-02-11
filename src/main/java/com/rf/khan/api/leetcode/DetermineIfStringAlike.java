package com.rf.khan.api.leetcode;

public class DetermineIfStringAlike {
	public static void main(String[] args) {
		DetermineIfStringAlike d = new DetermineIfStringAlike();
		System.out.println(d.halvesAreAlike("puKYyvdkFA"));
	}

	// puKYy vdkFA
	public boolean halvesAreAlike(String s) {
		int start = 0;
		int half = s.length() / 2;
		s = s.toLowerCase();
		int leftCount = 0;
		int rightCount = 0;

		while (half < s.length()) {
			if (vowelCheck(s.charAt(start))) {
				leftCount++;
			}
			if (vowelCheck(s.charAt(half))) {
				rightCount++;
			}
			start++;
			half++;
		}

		if (leftCount == rightCount)
			return true;

		return false;
	}

	private boolean vowelCheck(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
			return true;

		return false;
	}
}
