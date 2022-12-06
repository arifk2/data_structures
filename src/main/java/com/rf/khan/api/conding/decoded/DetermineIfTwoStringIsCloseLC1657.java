package com.rf.khan.api.conding.decoded;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DetermineIfTwoStringIsCloseLC1657 {

	public static void main(String[] args) {
		DetermineIfTwoStringIsCloseLC1657 d = new DetermineIfTwoStringIsCloseLC1657();
		System.out.println(d.closeStrings("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff"));

		System.out.println(d.closeStrings("bccdaa", "abbcdd"));
	}

	public boolean closeStrings(String word1, String word2) {

		Set<Character> wordSet1 = new HashSet<>();
		Set<Character> wordSet2 = new HashSet<>();

		List<Integer> freq1 = new ArrayList<>();
		List<Integer> freq2 = new ArrayList<>();

		Map<Character, Integer> word1Map = new HashMap<>();
		Map<Character, Integer> word2Map = new HashMap<>();

		for (int i = 0; i < word1.length(); i++) {
			int val = word1Map.getOrDefault(word1.charAt(i), 0);
			word1Map.put(word1.charAt(i), val + 1);
		}

		for (int i = 0; i < word2.length(); i++) {
			int val = word2Map.getOrDefault(word2.charAt(i), 0);
			word2Map.put(word2.charAt(i), val + 1);
		}

		for (Map.Entry<Character, Integer> map : word1Map.entrySet()) {
			wordSet1.add(map.getKey());
			freq1.add(map.getValue());
		}

		for (Map.Entry<Character, Integer> map : word2Map.entrySet()) {
			wordSet2.add(map.getKey());
			freq2.add(map.getValue());
		}
		Collections.sort(freq1);
		Collections.sort(freq2);

		return wordSet1.equals(wordSet2) && freq1.equals(freq2);
	}
}
