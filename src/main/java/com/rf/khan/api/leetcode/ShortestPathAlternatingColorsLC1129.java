package com.rf.khan.api.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathAlternatingColorsLC1129 {
	public static void main(String[] args) {
		ShortestPathAlternatingColorsLC1129 s = new ShortestPathAlternatingColorsLC1129();
		int[][] redEdges = new int[][] { { 0, 1 }, { 1, 2 } }, blueEdges = {};
		int[] ans = s.shortestAlternatingPaths(3, redEdges, blueEdges);
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}

	private class Pair {
		int node;
		int color;

		// red -> 0 and blue ->1
		public Pair(int node, int color) {
			this.node = node;
			this.color = color;
		}

	}

	public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
		// Prepare adjacency list
		List<List<Pair>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<>());

		for (int i = 0; i < redEdges.length; i++) {
			int u = redEdges[i][0];
			int v = redEdges[i][1];

			adj.get(u).add(new Pair(v, 0));
		}

		for (int i = 0; i < blueEdges.length; i++) {
			int u = blueEdges[i][0];
			int v = blueEdges[i][1];

			adj.get(u).add(new Pair(v, 1));
		}
		// build answer
		int[] answer = new int[n];
		Arrays.fill(answer, -1);

		// Step 3 : create visited arrays, visited , color
		boolean[][] visited = new boolean[n][2];

		// Step 4: create queue of list type <node, step, color>
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, -1 }); // node , steps, color
		visited[0][0] = true;
		visited[0][1] = true;
		answer[0] = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currNode = current[0];
			int currStep = current[1];
			int prevColor = current[2];

			// traverse all adjacency node

			for (Pair it : adj.get(currNode)) {
				int nbrNode = it.node;
				int nbrColor = it.color;
				if (visited[nbrNode][nbrColor] == false && nbrColor != prevColor) {
					visited[nbrNode][nbrColor] = true;
					queue.add(new int[] { nbrNode, currStep + 1, nbrColor });

					if (answer[nbrNode] == -1) {
						answer[nbrNode] = currStep + 1;
					}
				}
			}
		}
		return answer;
	}
}
