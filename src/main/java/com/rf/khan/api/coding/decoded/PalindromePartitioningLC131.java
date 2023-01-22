package com.rf.khan.api.coding.decoded;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningLC131 {
	public static void main(String[] args) {
		PalindromePartitioningLC131 p = new PalindromePartitioningLC131();
		System.out.println(p.partition("aab"));
		System.out.println(p.partition("abacfc"));
	}

	private List<List<String>> result;

	public List<List<String>> partition(String s) {
		result = new ArrayList<>();
		if (s.length() == 0 || s == null) {
			return result;
		}

		helper(new ArrayList<>(), s);
		return result;
	}

	private void helper(ArrayList<String> currList, String inputString) {
		// base case:
		if (inputString.length() == 0) {
			result.add(new ArrayList<>(currList));
			return;
		}

		for (int index = 0; index < inputString.length(); index++) {
			String firstPart = inputString.substring(0, index + 1);
			if (isPalindrome(firstPart)) {
				currList.add(firstPart);
				String secondPart = inputString.substring(index + 1, inputString.length());
				// recursive call
				helper(currList, secondPart);

				// back tracking
				currList.remove(currList.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String firstPart) {
		String reverseString = new StringBuilder(firstPart).reverse().toString();
		if (reverseString.equals(firstPart)) {
			return true;
		}
		return false;
	}
}
