package com.rf.khan.api.iq.string;

import java.util.ArrayList;

public class RemoveOccuranceL1910 {

	public static void main(String[] args) {
		String input = "daabcbaabcbc";
		System.out.println(removeOccurrences(input, 'a'));
	}

	/**
	 * This method is created to remove the occurrence
	 * 
	 * @param input     holds the information of the input parameter
	 * @param character holds the information of the character to remove
	 * @return
	 */
	private static String removeOccurrences(String input, Character character) {
		ArrayList<Character> al = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch != character) {
				al.add(ch);
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : al) {
			stringBuilder.append(c);
		}
		return stringBuilder.toString();
	}
}
