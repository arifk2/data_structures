package com.rf.khan.api.coding.decoded;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionaryLC953 {
	public static void main(String[] args) {
		VerifyingAlienDictionaryLC953 ver = new VerifyingAlienDictionaryLC953();
		System.out.println(ver.isAlienSorted(new String[] { "hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz"));
		System.out.println(ver.isAlienSorted(new String[] { "word", "world", "row" }, "worldabcefghijkmnpqstuvxyz"));
	}

	public boolean isAlienSorted(String[] words, String order) {
		Map<Character, Integer> orderMap = new HashMap<>();

		for (int i = 0; i < order.length(); i++) {
			orderMap.put(order.charAt(i), i);
		}

		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];

			int min = Math.min(word1.length(), word2.length());

			for (int index = 0; index < min; index++) {
				if (orderMap.get(word1.charAt(index)) < orderMap.get(word2.charAt(index))) {
					break;
				}

				if (orderMap.get(word1.charAt(index)) > orderMap.get(word2.charAt(index))) {
					return false;
				}

				if (index == min - 1 && word1.length() > word2.length())
					return false;
			}
		}
		return true;
	}
}
