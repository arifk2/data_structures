package com.rf.khan.api.iq.graph;

import java.util.ArrayList;
import java.util.Arrays;

// node start from 1
public class BellmanFordAlgoShortestPath {

	/**
	 * 
	 * @param n     total node
	 * @param m     total edges
	 * @param src   source node
	 * @param dest  destination node
	 * @param edges edges information
	 * @return
	 */
	static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
		int[] distance = new int[n + 1];
		Arrays.fill(distance, 1000000000);

		// update the source distance to 0
		distance[src] = 0;

		// traverse the edges for the n-1 times and update distance based on the formula
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				int u = edges.get(j).get(0);
				int v = edges.get(j).get(1);
				int wt = edges.get(j).get(2);

				// BellmanFord formula
				if (distance[u] != 1e9 && ((distance[u] + wt) < distance[v])) {
					distance[v] = distance[u] + wt;
				}
			}
		}

		// check for the negative cycle
		boolean negativeCycle = false;
		for (int j = 0; j < m; j++) {
			int u = edges.get(j).get(0);
			int v = edges.get(j).get(1);
			int wt = edges.get(j).get(2);

			if (distance[u] != 1e9 && ((distance[u] + wt) < distance[v])) {
				distance[v] = distance[u] + wt;
				negativeCycle = true;
			}
		}

		if (!negativeCycle) {
			return distance[dest];
		}
		return -1;
	}

	/**
	 * Driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
		ArrayList<Integer> e1 = new ArrayList<>(Arrays.asList(new Integer[] { 1, 2, 2 }));
		ArrayList<Integer> e2 = new ArrayList<>(Arrays.asList(new Integer[] { 2, 3, -1 }));
		ArrayList<Integer> e3 = new ArrayList<>(Arrays.asList(new Integer[] { 3, 1, 2 }));

		edges.add(e1);
		edges.add(e2);
		edges.add(e3);

		int n = 3;
		int m = 3;
		int src = 1;
		int dest = 3;
		System.out.println(bellmonFord(n, m, src, dest, edges));
		System.out.println(Integer.MAX_VALUE);
	}
}
