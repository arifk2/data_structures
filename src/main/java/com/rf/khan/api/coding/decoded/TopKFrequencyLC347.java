package com.rf.khan.api.coding.decoded;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequencyLC347 {
	public static void main(String[] args) {
		TopKFrequencyLC347 t = new TopKFrequencyLC347();
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		Arrays.stream(t.topKFrequent(nums, k)).forEach(System.out::print);
	}

	private int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);

		Queue<Integer> q = new PriorityQueue<>(
				(n1, n2) -> map.get(n1).equals(n2) ? n1.compareTo(n2) : map.get(n1) - map.get(n2));

		for (int number : map.keySet()) {
			q.add(number);

			if (q.size() > k)
				q.poll();
		}

		// build ans
		int[] result = new int[q.size()];
		int count = 0;

		while (!q.isEmpty()) {
			result[count++] = q.poll();	
		}

		return result;
	}
}
