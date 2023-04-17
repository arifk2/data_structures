package com.rf.khan.api.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class IPOLC502 {

	public static void main(String[] args) {
		IPOLC502 i = new IPOLC502();
		// System.out.println(i.findMaximizedCapital(2, 0, new int[] { 1, 2, 3 }, new
		// int[] { 0, 1, 1 }));
		System.out.println(i.findMaximizedCapital(3, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 2 }));
		// System.out.println(i.findMaximizedCapital(4, 0, new int[] { 1, 5, 1, 1, 1, 1,
		// 15, 20, 30, 40 },
		// new int[] { 0, 0, 1, 1, 2, 2, 4, 4, 5, 5 }));
	}

	private class Project implements Comparable<Project> {
		private int profit;
		private int capital;

		public Project(int capital, int profit) {
			this.profit = profit;
			this.capital = capital;
		}

		@Override
		public int compareTo(Project project) {
			return capital - project.capital;
		}
	}

	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		int n = profits.length;
		Project[] projects = new Project[n];

		for (int i = 0; i < n; i++) {
			projects[i] = new Project(capital[i], profits[i]);
		}

		Arrays.sort(projects);
		// maxHeap for profit
		PriorityQueue<Integer> q = new PriorityQueue<>(n, Collections.reverseOrder());
		int index = 0;

		for (int i = 0; i < k; i++) {
			while (index < n && projects[index].capital <= w) {
				q.add(projects[index++].profit);
			}
			if (q.isEmpty()) {
				break;
			}
			// adding profit
			w += q.poll();
		}
		return w;
	}
}
