package com.rf.khan.api.iq.recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberLetterCombinationLC17 {

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}

	/**
	 * This method is created to get the combination of the letters
	 * 
	 * @param digits holds the information of the digits
	 * @return list of the combination of the strings
	 */
	public static List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<>();
		// if the provided input is empty then return the empty ans
		if (digits.length() == 0)
			return ans;

		// create a empty string to hold the value
		String output = "";

		// started the index for the provide digit
		int index = 0;

		// call the method to provide the combination
		solve(digits, ans, output, index);

		return ans;
	}

	/**
	 * This method is created to get provide the combination to the caller
	 * 
	 * @param digits holds the information of the input digit
	 * @param ans    list of string
	 * @param output result string
	 * @param index  index of digit
	 */
	private static void solve(String digits, List<String> ans, String output, int index) {
		// created mapping for the numbers
		String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		// base case
		if (index >= digits.length()) {
			ans.add(new String(output));
			return;
		}

		// get the number pointed by index
		int number = digits.charAt(index) - '0';
		String value = mapping[number];

		// get the combination with the recursive call
		for (int i = 0; i < value.length(); i++) {
			output = output + value.charAt(i);
			solve(digits, ans, output, index + 1);

			// back tracking
			output = output.substring(0, output.length() - 1);
		}
	}
}
