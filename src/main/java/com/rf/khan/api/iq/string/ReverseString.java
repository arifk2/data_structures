package com.rf.khan.api.iq.string;

public class ReverseString {

	public static void main(String[] args) {

		String name = "arif";
		char[] chr = name.toCharArray();

		int start = 0;
		int end = chr.length - 1;

		while (start < end) {
			// swap kardo
			char temp = chr[start];
			chr[start] = chr[end];
			chr[end] = temp;
			start++;
			end--;
		}

		System.out.println(chr);
	}
}
