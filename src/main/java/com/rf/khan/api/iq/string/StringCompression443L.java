package com.rf.khan.api.iq.string;

import java.util.HashMap;

public class StringCompression443L {
	public static void main(String[] args) {
		char ch[] = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		System.out.println(compress(ch));
	}

	public static int compress(char[] chars) {
		int i = 0;
		int ansIndex = 0;
		int n = chars.length;

		while (i < n) {
			int j = i + 1;
			while (j < n && chars[i] == chars[j]) {
				j++;
			}

			// yahan kab aaoge
			// ya to poora char array traverse kar liye
			// ya phir ab new character mil gaya.

			chars[ansIndex++] = chars[i]; /// store new character
			int count = j - i;
			if (count > 1) {
				// converting counting into single digit and saving in answer
				String cnt = String.valueOf(count);
				char[] ch = cnt.toCharArray();
				for (char c : ch) {
					chars[ansIndex++] = c;
				}
			}
			i = j;
		}

		return ansIndex;
	}

	public static void getOccuranceCount(char[] chars) {
		HashMap<Character, Integer> countMap = new HashMap<>();

		for (char ch : chars) {
			if (countMap.containsKey(ch)) {
				countMap.put(ch, countMap.get(ch) + 1);
			} else {
				countMap.put(ch, 1);
			}
		}
		System.out.println(countMap);
	}

}
