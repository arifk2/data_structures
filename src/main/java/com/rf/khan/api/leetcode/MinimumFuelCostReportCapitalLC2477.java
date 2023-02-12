package com.rf.khan.api.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumFuelCostReportCapitalLC2477 {

	public static void main(String[] args) {
		int[][] roads = new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 } };
		int seats = 5;
		MinimumFuelCostReportCapitalLC2477 m = new MinimumFuelCostReportCapitalLC2477();
		System.out.println(m.minimumFuelCost(roads, seats));
	}

	private int seats;
	private long fuel = 0l;

	public long minimumFuelCost(int[][] roads, int seats) {
		// Step1: prepare adjacency list
		List<Integer>[] graph = new List[roads.length + 1];

		for (int i = 0; i <= roads.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int[] road : roads) {
			int end1 = road[0];
			int end2 = road[1];

			graph[end1].add(end2);
			graph[end2].add(end1);
		}
		this.seats = seats;
	
		dfs(graph, 0, -1);
		return fuel;
	}

	private int dfs(List<Integer>[] graph, int currCity, int prevCity) {
		int people = 1;
		for (int nextCity : graph[currCity]) {
			if (nextCity == prevCity) {
				continue;
			}
			people += dfs(graph, nextCity, currCity);
		}

		// if not reach at destination as zero, the check for the people and capacity
		if (currCity != 0) {
			fuel += (long) (Math.ceil((double) people / this.seats));
		}

		return people;
	}
}
