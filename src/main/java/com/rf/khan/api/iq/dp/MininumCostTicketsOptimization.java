package com.rf.khan.api.iq.dp;

import java.util.LinkedList;
import java.util.Queue;

public class MininumCostTicketsOptimization {

	public static int minimumCoins(int n, int[] days, int[] cost) {
		return solveOptimization(n, days, cost);
	}

	static class Pair {
		int first;
		int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

	}

	/**
	 * Solving via Optimization.
	 * 
	 * @param n
	 * @param n
	 * @param cost
	 * @param index
	 * @return
	 */
	private static int solveOptimization(int n, int[] days, int[] cost) {
		int ans = 0;

		Queue<Pair> month = new LinkedList<>();
		Queue<Pair> week = new LinkedList<>();

		for (int day : days) {
			// step1: remove expire days
			while (!month.isEmpty() && month.peek().first + 30 <= day)
				month.poll();

			while (!week.isEmpty() && week.peek().first + 7 <= day)
				week.poll();

			// Step2: add cost for current day
			week.add(new Pair(day, ans + cost[1]));
			month.add(new Pair(day, ans + cost[2]));

			// Step3: answer update
			ans = Math.min(ans + cost[0], Math.min(month.peek().second, week.peek().second));

		}

		return ans;
	}

	public static void main(String[] args) {

		int[] days = { 1, 4, 6, 7, 8, 20 };
		int[] cost = { 2, 7, 15 };
		int n = days.length;

		System.out.println(minimumCoins(n, days, cost));
	}
}
