package com.rf.khan.api.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTimeCollectAllApplesTreeLC1443 {

	public static void main(String[] args) {
		int n = 7;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
		Boolean[] hasApple = { false, false, true, false, true, true, false };
		MinimumTimeCollectAllApplesTreeLC1443 m = new MinimumTimeCollectAllApplesTreeLC1443();

		System.out.println(m.minTime(n, edges, Arrays.asList(hasApple)));
	}

	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

		// Step1: prepare adjacency list
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int[] e : edges) {
			adjList.get(e[0]).add(e[1]);
			adjList.get(e[1]).add(e[0]);
		}

		boolean[] visited = new boolean[n];

		return dfs(adjList, visited, hasApple, 0);
	}

	private int dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, List<Boolean> hasApple, int node) {
		visited[node] = true;
		int appleCollectedTime = 0;

		for (int currNode : adjList.get(node)) {
			if (visited[currNode] == false) {
				appleCollectedTime += dfs(adjList, visited, hasApple, currNode);
			}
		}

		if (node == 0)
			return appleCollectedTime;

		// if my current node has apple with it or it it child node has apple mean t >0
		if (hasApple.get(node) || appleCollectedTime > 0) {
			appleCollectedTime += 2;
		}

		return appleCollectedTime;
	}

}
