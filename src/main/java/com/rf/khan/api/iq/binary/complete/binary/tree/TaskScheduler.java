package com.rf.khan.api.iq.binary.complete.binary.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
	
	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> counts = new HashMap<>();
		for (char t : tasks)
			counts.put(t, counts.getOrDefault(t, 0) + 1);

		// Max PQ
		PriorityQueue<Integer> pq = new PriorityQueue<>(counts.size(), Collections.reverseOrder());
		pq.addAll(counts.values());

		int result = 0;
		while (!pq.isEmpty()) {
			int time = 0;
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < n + 1; i++) {
				if (!pq.isEmpty()) {
					temp.add(pq.poll() - 1);
					time++;
				}
			}
			for (int t : temp)
				if (t > 0)
					pq.add(t);

			result += pq.isEmpty() ? time : n + 1;
		}

		return result;
	}

	public static void main(String[] args) {
		TaskScheduler s = new TaskScheduler();
		char[] ch = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n = 2;

		System.out.println(s.leastInterval(ch, n));
	}
}
