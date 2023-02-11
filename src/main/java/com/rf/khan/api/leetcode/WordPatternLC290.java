package com.rf.khan.api.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPatternLC290 {
	public static void main(String[] args) {
		WordPatternLC290 w = new WordPatternLC290();
		String pattern = "abba", s = "dog cat cat dog";
		System.out.println(w.wordPattern(pattern, s));
		System.out.println(w.wordPattern("abba", "dog dog dog dog"));
		System.out.println(w.wordPattern("abba", "dog cat cat fish"));
	}

	public boolean wordPattern(String pattern, String s) {
		String[] words = s.split(" ");
		if (words.length != pattern.length())
			return false;
		Map<Character, String> map = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			if (map.containsKey(pattern.charAt(i))) {
				if (!map.get(pattern.charAt(i)).equals(words[i]))
					return false;
			} else {
				if (!map.containsValue(words[i])) {
					map.put(pattern.charAt(i), words[i]);
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
