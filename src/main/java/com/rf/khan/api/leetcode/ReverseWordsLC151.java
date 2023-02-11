package com.rf.khan.api.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsLC151 {
	public static void main(String[] args) {
		ReverseWordsLC151 r = new ReverseWordsLC151();
		String s = "a good   example";
		System.out.println(r.reverseWords(s));
		System.out.println(r.reverseWordss(s));
		System.out.println(r.reverseW("My name is Khan"));
	}

	private String reverseW(String s) {
		return Arrays.stream(s.split(" ")).reduce((word1, word2) -> word2 + " " + word1).orElse("");
	}

	public String reverseWords(String s) {
		String[] strArray = s.trim().split(" +");
		Collections.reverse(Arrays.asList(strArray));
		return String.join(" ", strArray);
	}

	public String reverseWordss(String s) {
		return Arrays.stream(s.split(" ")).map(String::trim).filter(word -> !word.isEmpty())
				.reduce((word1, word2) -> word2 + " " + word1).orElse("");
	}

}
