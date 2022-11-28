package com.rf.khan.api.conding.decoded;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class MaxProfitInJobSchedulingLC1235 {

	private class Job {
		int startTime;
		int endTime;
		int profit;

		public Job(int startTime, int endTime, int profit) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.profit = profit;
		}

	}

	public static void main(String[] args) {
		MaxProfitInJobSchedulingLC1235 m = new MaxProfitInJobSchedulingLC1235();
		int[] startTime = { 1, 2, 3, 3 };
		int[] endTime = { 3, 4, 5, 6 };
		int[] profit = { 50, 10, 40, 70 };
		System.out.println(m.jobScheduling(startTime, endTime, profit));
	}

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

		int maxProfit = Integer.MIN_VALUE;

		List<Job> jobs = new ArrayList<>();
		for (int i = 0; i < startTime.length; i++)
			jobs.add(new Job(startTime[i], endTime[i], profit[i]));

		Collections.sort(jobs, (a, b) -> (a.endTime - b.endTime));

		// TreeMap<Time, Profit_till_time>
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (Job currJob : jobs) {
			Integer entryTillStartTime = map.floorKey(currJob.startTime);
			int maxProfitTillStartTime = entryTillStartTime == null ? 0 : map.get(entryTillStartTime);
			maxProfit = Math.max(maxProfit, maxProfitTillStartTime + currJob.profit);

			map.put(currJob.endTime, maxProfit);
		}

		return maxProfit;
	}
}
