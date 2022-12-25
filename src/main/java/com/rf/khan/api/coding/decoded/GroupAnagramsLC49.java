package com.rf.khan.api.coding.decoded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsLC49 {

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		GroupAnagramsLC49 g = new GroupAnagramsLC49();
		System.out.println(g.groupAnagrams(strs));
	}

	/**
	 * This method is created to get the grouped anagrams
	 * 
	 * @param strs holds the information of the string array
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();
		Map<String, List<String>> ans = new HashMap<>();
		for (String str : strs) {
			String key = buildKey(str);
			List<String> list = ans.getOrDefault(key, new ArrayList<>());
			list.add(str);
			ans.put(key, list);
		}
		return new ArrayList<>(ans.values());
	}

	private String buildKey(String str) {
		char[] keyChar = new char[26];
		for (char c : str.toCharArray()) {
			keyChar[c - 'a']++;
		}
		return new String(keyChar);
	}

}
