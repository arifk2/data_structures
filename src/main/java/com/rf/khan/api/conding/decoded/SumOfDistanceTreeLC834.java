package com.rf.khan.api.conding.decoded;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SumOfDistanceTreeLC834 {
	public static void main(String[] args) {
		int n = 6;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } };
		SumOfDistanceTreeLC834 s = new SumOfDistanceTreeLC834();
		Arrays.asList(s.sumOfDistancesInTree(n, edges)).stream().forEach(i -> {
			System.out.println(i);
		});
	}

	private int[] res;
	private int[] count;
	private List<HashSet<Integer>> adjList;

	public int[] sumOfDistancesInTree(int n, int[][] edges) {
		res = new int[n];
		count = new int[n];
		adjList = new ArrayList<>();

		for (int i = 0; i < n; i++)
			adjList.add(new HashSet<>());

		for (int[] e : edges) {
			adjList.get(e[0]).add(e[1]);
			adjList.get(e[1]).add(e[0]);
		}

		postOrder(0, -1);
		preOrder(0, -1);

		return res;
	}

	private void preOrder(int root, int pre) {
		for (int i : adjList.get(root)) {
			if (i == pre)
				continue;
			res[i] = res[root] - count[i] + count.length - count[i];
			preOrder(i, root);
		}
	}

	private void postOrder(int root, int pre) {
		for (int i : adjList.get(root)) {
			if (i == pre)
				continue;
			postOrder(i, root);
			count[root] += count[i];
			res[root] += res[i] + count[i];
		}
		count[root]++;
	}
}
