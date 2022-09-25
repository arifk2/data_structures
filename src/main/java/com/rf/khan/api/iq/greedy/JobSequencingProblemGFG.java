package com.rf.khan.api.iq.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
 * 
 * @author mkhan339
 * 
 *         TC : n log n , n*
 *
 */
public class JobSequencingProblemGFG {

	/**
	 * This method to solve the problem
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	int[] JobScheduling(Job arr[], int n) {

		int[] ans = new int[2];

		// sort based on the profit in descending order
		Arrays.sort(arr, new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return o2.profit - o1.profit;
			}
		});

		int maxDeadline = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++)
			maxDeadline = Math.max(maxDeadline, arr[i].deadline);

		int[] schedule = new int[maxDeadline + 1];
		Arrays.fill(schedule, -1);

		int maxProft = 0;
		int count = 0;

		for (int i = 0; i < n; i++) {
			int currProfit = arr[i].profit;
			int currJobId = arr[i].id;
			int currDeadline = arr[i].deadline;

			// check for the free space to run the job based on the deadline
			for (int k = currDeadline; k > 0; k--) {
				if (schedule[k] == -1) {
					count++;
					maxProft += currProfit;
					schedule[k] = currJobId;
					break;
				}
			}
		}
		ans[0] = count;
		ans[1] = maxProft;

		return ans;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 4;
		int[][] jobs = { { 1, 4, 20 }, { 2, 1, 10 }, { 3, 1, 40 }, { 4, 1, 30 } };
		Job[] jobArr = new Job[N];

		for (int i = 0; i < N; i++) {
			Job job = new Job(jobs[i][0], jobs[i][1], jobs[i][2]);
			jobArr[i] = job;
		}

		JobSequencingProblemGFG j = new JobSequencingProblemGFG();
		int[] ans = j.JobScheduling(jobArr, N);
		System.out.println("Total jobs: " + ans[0]);
		System.out.println("Total Profit: " + ans[1]);
	}
}

class Job {
	int id, profit, deadline;

	Job(int id, int profit, int deadline) {
		this.id = id;
		this.deadline = profit;
		this.profit = deadline;
	}
}