package com.rf.khan.api.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTargetLC797 {

	public static void main(String[] args) {
		AllPathFromSourceToTargetLC797 a = new AllPathFromSourceToTargetLC797();
		List<List<Integer>> ans = a.allPathsSourceTarget(new int[][] { { 1, 2 }, { 3 }, { 3 }, {} });
		ans.stream().forEach(System.out::println);
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		temp.add(0);
		dfs(0, graph, temp, ans);
		return ans;
	}

	private void dfs(int node, int[][] graph, List<Integer> temp, List<List<Integer>> ans) {
		// base case
		if (node == graph.length - 1) {
			ans.add(new ArrayList<>(temp));
			return;
		}

		for (int adjList : graph[node]) {
			temp.add(adjList);
			dfs(adjList, graph, temp, ans);
			// bactracking
			temp.remove(temp.size() - 1);
		}
	}
}
