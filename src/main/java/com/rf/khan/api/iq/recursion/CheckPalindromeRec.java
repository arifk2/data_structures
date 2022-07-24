package com.rf.khan.api.iq.recursion;

public class CheckPalindromeRec {

	public static void main(String[] args) {
		String name = "abcba";
		char[] in = name.toCharArray();

		System.out.println(checkPalindrome(in, 0, in.length - 1) ? "Yes is Palindrome" : "No is not Palindrome");
	}

	static boolean checkPalindrome(char[] in, int start, int end) {
		// base case, If both the pointer crossed each other, means both the pointer
		// index value is same.
		if (start > end)
			return true;

		if (in[start] != in[end]) {
			return false;
		} else {
			// recursive call
			start++;
			end--;
			return checkPalindrome(in, start, end);
		}

	}

}
