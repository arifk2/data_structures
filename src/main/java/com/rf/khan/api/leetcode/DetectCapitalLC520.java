package com.rf.khan.api.leetcode;

public class DetectCapitalLC520 {

	public static void main(String[] args) {
		DetectCapitalLC520 d = new DetectCapitalLC520();
		System.out.println(d.detectCapitalUse("USA"));
		System.out.println(d.detectCapitalUse("FlaG"));
		System.out.println(d.detectCapitalUse("leetcode"));
		System.out.println(d.detectCapitalUse("FFFFFFFFFFFFFFFFFFFFf"));
	}

	public boolean detectCapitalUse(String word) {
		char[] words = word.toCharArray();
		if (checkAllLetterCapital(words))
			return true;

		if (checkAllLetterNotCapital(words))
			return true;

		if (checkOnlyFirstLetterCapital(words))
			return true;

		return false;
	}

	// word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'
	private boolean checkOnlyFirstLetterCapital(char[] words) {
		boolean check = false;

		if (Character.isUpperCase(words[0]))
			check = true;

		for (int i = 0; i < words.length; i++) {
			if (i != 0 && Character.isUpperCase(words[i])) {
				check = false;
			}
		}
		return check;

	}

	private boolean checkAllLetterNotCapital(char[] words) {
		for (int i = 0; i < words.length; i++) {
			if (Character.isUpperCase(words[i])) {
				return false;
			}
		}
		return true;

	}

	private boolean checkAllLetterCapital(char[] words) {
		for (int i = 0; i < words.length; i++) {
			if (Character.isLowerCase(words[i])) {
				return false;
			}
		}
		return true;
	}
}
