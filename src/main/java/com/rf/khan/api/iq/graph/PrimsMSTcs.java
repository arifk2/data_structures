package com.rf.khan.api.iq.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is created for the Prim's algorithm
 * 
 * @author mkhan339
 * 
 *         *Spanning Tree: Covert a graph into tree with n nodes and n-1 edges
 *         and node is reachable to another node
 */
public class PrimsMSTcs {

	static class Pair {
		int first;
		int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

	}

	/**
	 * This method is created to calculate the minimum spanning tree
	 * 
	 * @param n total number of nodes: start from 1
	 * @param m total number of edges
	 * @param g information of the edges
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g) {

		// Step 1: create adjacency list
		Map<Integer, ArrayList<Pair>> adjList = new HashMap<>();
		for (int i = 1; i <= n; i++)
			adjList.put(i, new ArrayList<>());
		prepareAdjList(m, g, adjList);

		// Step 2: Create required data structures
		int[] key = new int[n + 1];
		int[] parent = new int[n + 1];
		boolean[] mst = new boolean[n + 1];
		// initialize
		for (int i = 1; i <= n; i++) {
			key[i] = Integer.MAX_VALUE;
			parent[i] = -1;
			mst[i] = false;
		}

		// Step 3: Prim's Algorithm starts here

		// source node is 1
		int sourceNode = 1;
		key[sourceNode] = 0;
		parent[sourceNode] = -1;

		// for all the nodes
		for (int i = 1; i <= n; i++) {
			int mini = Integer.MAX_VALUE;
			int u = 0;

			// Find minimum value in the key DS
			for (int v = 1; v <= n; v++) {
				if (mst[v] == false && key[v] < mini) {
					u = v;
					mini = key[v];
				}
			}
			// mark min node as true
			mst[u] = true;

			// check its adjacency node
			for (Pair neighbour : adjList.get(u)) {
				int node = neighbour.first;
				int weight = neighbour.second;

				if (mst[node] == false && weight < key[node]) {
					parent[node] = u;
					key[node] = weight;
				}
			}
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			result.add(new ArrayList<>(Arrays.asList(new Integer[] { parent[i], i, key[i] })));
		}

		return result;
	}

	/**
	 * This method is created to prepare adjacency list
	 * 
	 * @param m       total numbers of edges
	 * @param g       information of the edges
	 * @param adjList adjacency list
	 */
	private static void prepareAdjList(int m, ArrayList<ArrayList<Integer>> g, Map<Integer, ArrayList<Pair>> adjList) {
		for (int i = 0; i < m; i++) {
			int u = g.get(i).get(0);
			int v = g.get(i).get(1);
			int w = g.get(i).get(2);

			ArrayList<Pair> temp = adjList.get(u);
			temp.add(new Pair(v, w));
			adjList.put(u, temp);

			temp = adjList.get(v);
			temp.add(new Pair(u, w));
			adjList.put(v, temp);
		}
	}

}
