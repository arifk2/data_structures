package com.rf.khan.api.iq.string;

public class ReverseLastToFirst {

	public static void main(String[] args) {
		System.out.println(reverseStringWordWise("Welcome to Coding Ninjas"));
	}

	static String reverseStringWordWise(String input) {
		String[] str = input.split(" ");
		int start = 0;
		int end = str.length - 1;
		while (start < end) {
			// swap kardo
			String temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < str.length; i++) {
			if (i == result.length() - 1)
				result.append(str[i]);
			else
				result.append(str[i] + " ");
		}
		result.lastIndexOf("", result.length() - 1);
		return result.toString();
	}
}
