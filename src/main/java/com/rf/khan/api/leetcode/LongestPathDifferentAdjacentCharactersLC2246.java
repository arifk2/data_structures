package com.rf.khan.api.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestPathDifferentAdjacentCharactersLC2246 {
	public static void main(String[] args) {
		int[] parent = { -1, 0, 0, 1, 1, 2 };
		String s = "abacbe";
		LongestPathDifferentAdjacentCharactersLC2246 l = new LongestPathDifferentAdjacentCharactersLC2246();
		System.out.println(l.longestPath(parent, s));

	}

	private List<List<Integer>> adjList;
	private int answer = 1;

	public int longestPath(int[] parent, String s) {
		int n = parent.length;

		// Prepare adjacency list
		adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int i = 0; i < n; i++) {
			if (parent[i] != -1) {
				adjList.get(i).add(parent[i]);
				adjList.get(parent[i]).add(i);
			}
		}
		boolean[] visited = new boolean[n];

		// call dfs
		dfs(0, visited, s);

		return answer;
	}

	private int dfs(int node, boolean[] visited, String s) {
		visited[node] = true;
		int maxPath = 1;

		for (int currNode : adjList.get(node)) {
			if (visited[currNode] == false) {
				int temp = dfs(currNode, visited, s);

				// if parent node label is not same as the current node label the add
				if (s.charAt(node) != s.charAt(currNode)) {
					answer = Math.max(answer, maxPath + temp);
					maxPath = Math.max(maxPath, temp + 1);
				}
			}
		}
		return maxPath;
	}
}
