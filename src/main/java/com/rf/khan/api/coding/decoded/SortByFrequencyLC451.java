package com.rf.khan.api.coding.decoded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SortByFrequencyLC451 {

	public static void main(String[] args) {
		SortByFrequencyLC451 s = new SortByFrequencyLC451();
		// System.out.println(s.frequencySort("tree"));
		System.out.println(s.frequencySortApproach2("tree"));
	}

	public String frequencySort(String s) {
		Map<Character, Integer> freqCount = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			int val = freqCount.getOrDefault(s.charAt(i), 0);
			freqCount.put(s.charAt(i), val + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		pq.addAll(freqCount.entrySet());

		String ans = "";

		while (!pq.isEmpty()) {
			int val = pq.peek().getValue();
			char ch = pq.peek().getKey();
			pq.poll();

			while (val != 0) {
				ans = ans + ch;
				val--;
			}
		}
		return ans;
	}

	public String frequencySortApproach2(String s) {
		if (s == null)
			return s;

		Map<Character, Integer> freqCountMap = new HashMap<>();

		int maxi = 0;
		for (int i = 0; i < s.length(); i++) {
			int val = freqCountMap.getOrDefault(s.charAt(i), 0);
			freqCountMap.put(s.charAt(i), val + 1);

			maxi = Math.max(maxi, freqCountMap.get(s.charAt(i)));
		}

		// get the maximum frequency count, create a array of maximum frequency count
		// length, which have a array of
		// character on each index

		List<Character>[] array = buildBucketArray(freqCountMap, maxi);

		return buildOutputString(array);
	}

	private List<Character>[] buildBucketArray(Map<Character, Integer> freqCountMap, int maxCount) {
		List<Character>[] array = new List[maxCount + 1];

		for (Character c : freqCountMap.keySet()) {
			int count = freqCountMap.get(c);
			if (array[count] == null) {
				array[count] = new ArrayList<>();
			}
			array[count].add(c);
		}
		return array;
	}

	private String buildOutputString(List<Character>[] array) {
		StringBuilder sb = new StringBuilder();
		for (int i = array.length - 1; i > 0; i--) {
			List<Character> list = array[i];
			if (list != null) {
				for (Character c : list) {
					for (int j = 0; j < i; j++) {
						sb.append(c);
					}
				}
			}
		}
		return sb.toString();
	}
}
