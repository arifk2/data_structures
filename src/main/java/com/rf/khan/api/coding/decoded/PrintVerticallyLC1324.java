package com.rf.khan.api.coding.decoded;

import java.util.ArrayList;
import java.util.List;

public class PrintVerticallyLC1324 {

	public static void main(String[] args) {
		PrintVerticallyLC1324 p = new PrintVerticallyLC1324();
		System.out.println(p.printVertically("HOW ARE YOU"));
		System.out.println(p.printVertically("TO BE OR NOT TO BE"));
	}

	public List<String> printVertically(String s) {
		List<String> verticalWords = new ArrayList<>();
		String[] words = s.split(" ");

		int maxLength = 0;
		for (String word : words)
			maxLength = Math.max(maxLength, word.length());

		for (int i = 0; i < maxLength; i++) {
			String str = "", spaces = "";
			for (int j = 0; j < words.length; j++) {
				if (i >= words[j].length()) {
					spaces += " ";
				} else {
					str += spaces + words[j].charAt(i);
					spaces = "";
				}
			}
			verticalWords.add(str);
		}
		return verticalWords;
	}
}
