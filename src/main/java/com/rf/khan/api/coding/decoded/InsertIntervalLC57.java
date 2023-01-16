package com.rf.khan.api.coding.decoded;

import java.util.LinkedList;
import java.util.List;

public class InsertIntervalLC57 {

	public static void main(String[] args) {
		InsertIntervalLC57 ins = new InsertIntervalLC57();
		int[][] ans = ins.insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 });

		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i][0] + ", " + ans[i][1]);
		}
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> ans = new LinkedList<>();
		int len = intervals.length;
		int index = 0;

		// for the non overlapping intervals : ending time of the interval should always
		// less than starting time of new interval
		while (index < len && intervals[index][1] < newInterval[0]) {
			ans.add(intervals[index]);
			index++;
		}

		// for the overlapping intervals : starting time of the interval is greater than
		// or equal to end time of new interval
		while (index < len && intervals[index][0] <= newInterval[1]) {
			// update starting and ending time of the new interval
			newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
			index++;
		}

		// insert newInterval after overlapping
		ans.add(newInterval);

		// add last interval into answer if any present
		while (index < len) {
			ans.add(intervals[index]);
			index++;
		}

		// build the answer
		int[][] result = new int[ans.size()][2];
		int j = 0;
		while (j < ans.size()) {
			result[j] = ans.get(j);
			j++;
		}
		return result;
	}
}
