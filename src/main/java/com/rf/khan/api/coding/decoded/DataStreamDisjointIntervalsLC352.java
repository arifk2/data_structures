package com.rf.khan.api.coding.decoded;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DataStreamDisjointIntervalsLC352 {
	private Set<Integer> numbers;

	public DataStreamDisjointIntervalsLC352() {
		numbers = new TreeSet<Integer>();
	}

	// O(log n)
	public void addNum(int value) {
		numbers.add(value);
	}

	public int[][] getIntervals() {

		List<int[]> disJointInterval = new ArrayList<>();

		for (int n : numbers) {
			int size = disJointInterval.size();
			if (size > 0 && disJointInterval.get(size - 1)[1] + 1 == n) {
				disJointInterval.get(size - 1)[1] = n;
			} else {
				disJointInterval.add(new int[] { n, n });
			}
		}
		return disJointInterval.toArray(new int[0][1]);
	}
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges(); obj.addNum(value); int[][] param_2 =
 * obj.getIntervals();
 */