package com.rf.khan.api.iq.string;

public class Palindrome54CodeStudio {

	public static void main(String[] args) {

		String input = "0P";
		// "N2 i&nJA?a& jnI2n";
		System.out.println("Is given string is palindrome ? " + checkPalindrome(input));
	}

	public static boolean checkPalindrome(String str) {
		String s = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(s);

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}

		return true;

	}

}
