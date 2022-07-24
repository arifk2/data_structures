package com.rf.khan.api.iq.string;

public class RevereWordWithEachWordReverse {
	public static void main(String[] args) {
		System.out.println(reverseStringWordWise("Welcome to Coding Ninjas"));
	}

	static String reverseStringWordWise(String input) {
		char[] str = input.toCharArray();
		int start = 0;
		int end = str.length - 1;
		System.out.println(str);
		while (start < end) {
			// swap kardo
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < str.length; i++) {
			result.append(str[i]);
		}
		return result.toString();
	}
}
