package com.rf.khan.api.iq.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

public class FirstNoReapeatingJava8 {
	public static void main(String[] args) {
		String inputString = "aabbcc";
		try {
			HashMap<Character, Integer> countHashMap = new LinkedHashMap<>();
			for (int i = 0; i < inputString.length(); i++) {
				char ch = inputString.charAt(i);
				if (countHashMap.containsKey(ch))
					countHashMap.put(ch, countHashMap.get(ch) + 1);
				else
					countHashMap.put(ch, 1);
			}

			char ans = countHashMap.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey();
			System.out.println("First Non-Repeating character is : " + ans);
		} catch (NoSuchElementException e) {
			System.out.println(inputString.charAt(0));
		}
	}
}
