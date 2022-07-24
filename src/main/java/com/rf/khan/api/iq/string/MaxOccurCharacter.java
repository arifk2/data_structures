package com.rf.khan.api.iq.string;

public class MaxOccurCharacter {

	public static void main(String[] args) {
		System.out.println(getMaxOccCharacter("arifkhan"));
		// getMaxOccCharacter("arifkhan");
	}

	// ek array bana lo aur sab char ka count type
	static char getMaxOccCharacter(String s) {
		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int number = 0;
			number = ch - 'a';
			arr[number]++;
		}

		// get the maximum from array
		int max = 0, ans = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				ans = i;
				max = arr[i];
			}
		}
		char maxOccuranceCharacter = (char) ('a' + ans);
		return maxOccuranceCharacter;
	}
}
