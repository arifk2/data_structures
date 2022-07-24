package com.rf.khan.api.iq.array.ques;

import java.util.ArrayList;

public class ReplaceSpaces {
	public static void main(String[] args) {
		System.out.println(replaceSpaces(new StringBuilder("My name is khan")));

		replaceSpacesWith("My name is khan");
	}

	public static StringBuilder replaceSpaces(StringBuilder str) {
		String stng = new String(str);
		String noSpace = stng.replaceAll("\\s", "@40");

		StringBuilder sb = new StringBuilder(noSpace);
		return sb;
	}

	public static void replaceSpacesWith(String str) {
		char[] strChar = str.toCharArray();

		ArrayList<Character> list = new ArrayList<>();

		for (int i = 0; i < strChar.length; i++) {
			// check if you found space
			if (strChar[i] == ' ') {
				list.add('@');
				list.add('4');
				list.add('0');
			} else {
				list.add(strChar[i]);
			}
		}
		String result = list.toString();

		System.out.println(result);
	}
}
