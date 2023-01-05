package com.rf.khan.api.coding.decoded;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundLC2244 {
	public static void main(String[] args) {
		int[] tasks = { 2, 2, 3, 3, 2, 4, 4, 4, 4, 4 };
		MinimumRoundLC2244 m = new MinimumRoundLC2244();
		System.out.println(m.minimumRounds(tasks));
	}

	public int minimumRounds(int[] tasks) {
		int roundCount = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < tasks.length; i++) {
			map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int freq = entry.getValue();
			if (freq == 1)
				return -1;

			if (freq % 3 != 0)
				roundCount += freq / 3 + 1;
			else {
				roundCount += freq / 3;
			}
		}

		return roundCount;
	}

}
