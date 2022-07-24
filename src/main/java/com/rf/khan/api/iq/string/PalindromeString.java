package com.rf.khan.api.iq.string;

public class PalindromeString {

	public static void main(String[] args) {

		String name = "nbooon";
		System.out.println("Is given string is palindrome: " + checkPalindrome(name));
	}

	public static boolean checkPalindrome(String str) {
		char ch[] = str.toCharArray();
		int start = 0;
		int end = ch.length - 1;

		while (start < end) {
			if (ch[start] != ch[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;

	}
}
