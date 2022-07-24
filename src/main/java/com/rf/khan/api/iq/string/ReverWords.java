package com.rf.khan.api.iq.string;

public class ReverWords {
	public static void main(String[] args) {
		String input = "My name is khan"; // output : yM eman si nahk

		String[] stringArray = input.split(" ");
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < stringArray.length; i++) {
			String reverseWord = reverseEachWord(stringArray[i]);
			if (i == stringArray.length - 1) {
				stringBuffer.append(reverseWord);
			} else {
				stringBuffer.append(reverseWord + " ");
			}
		}

		System.out.println(stringBuffer);

	}

	public static String reverseEachWord(String word) {
		char[] charArray = word.toCharArray();

		int start = 0;
		int end = charArray.length - 1;

		while (start < end) {
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			start++;
			end--;
		}
		String outputWord = new String(charArray);
		return outputWord;
	}

}
