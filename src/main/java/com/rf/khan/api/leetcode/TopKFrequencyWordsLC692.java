package com.rf.khan.api.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequencyWordsLC692 {

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		int k = 2;

		TopKFrequencyWordsLC692 t = new TopKFrequencyWordsLC692();
		System.out.println(t.topKFrequent(words, k));
		System.out.println(t.topKFrequent(
				new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4));
	}

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();

		for (String s : words) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		Queue<String> q = new PriorityQueue<>(
				(w1, w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1) - map.get(w2));

		// add to the heap
		for (String word : map.keySet()) {
			q.add(word);

			if (q.size() > k)
				q.poll();
		}

		// add the result
		List<String> result = new ArrayList<>();
		while (!q.isEmpty())
			result.add(q.poll());

		 Collections.reverse(result);

		return result;
	}
}
