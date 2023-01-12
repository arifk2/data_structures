package com.rf.khan.api.coding.decoded;

import java.util.ArrayList;
import java.util.List;

public class NumberOfNodesSubTreeWithSameLabelLC1519 {
	public static void main(String[] args) {
		int n = 7;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
		String labels = "abaedcd";
		NumberOfNodesSubTreeWithSameLabelLC1519 num = new NumberOfNodesSubTreeWithSameLabelLC1519();

		int[] ans = num.countSubTrees(n, edges, labels);
		for (int i = 0; i < n; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	private int[] ans;
	private List<List<Integer>> adjList;

	public int[] countSubTrees(int n, int[][] edges, String labels) {
		ans = new int[n];
		adjList = new ArrayList<>();

		// Step1: Prepare adjacency list
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int[] e : edges) {
			adjList.get(e[0]).add(e[1]);
			adjList.get(e[1]).add(e[0]);
		}
		boolean[] visited = new boolean[n];

		dfs(labels, 0, visited);
		return ans;
	}

	private int[] dfs(String labels, int node, boolean[] visited) {
		visited[node] = true;

		int[] count = new int[26];

		// get the count of each character in each subtree and returning bac to the root
		// node
		for (int currNode : adjList.get(node)) {
			if (visited[currNode] == false) {
				int[] temp = dfs(labels, currNode, visited);
				for (int i = 0; i < 26; i++) {
					count[i] += temp[i];
				}
			}
		}

		int ch = labels.charAt(node) - 'a';
		count[ch]++;

		// store current node in answer
		ans[node] = count[ch];

		return count;
	}
}
