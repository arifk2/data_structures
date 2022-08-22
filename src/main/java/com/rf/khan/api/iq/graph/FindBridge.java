package com.rf.khan.api.iq.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindBridge {

	/**
	 * This method is created to find the bridges
	 * 
	 * @param edges holds the information of the edges
	 * @param v     total number of vertexes
	 * @param e     total number of edges
	 * @return edge information
	 */
	public static List<List<Integer>> findBridges(int[][] edges, int v, int e) {
		Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
		for (int i = 0; i < v; i++)
			adjList.put(i, new ArrayList<>());

		prepareAdjList(adjList, edges, e);

		int timer = 0;
		int[] dicoveryTime = new int[v];
		int[] low = new int[v];

		int parent = -1;
		Map<Integer, Boolean> visited = new HashMap<>();
		for (int i = 0; i < v; i++) {
			visited.put(i, false);
			dicoveryTime[i] = -1;
			low[i] = -1;
		}

		List<List<Integer>> result = new ArrayList<>();
		// dfs
		for (int i = 0; i < v; i++) {
			if (!visited.get(i)) {
				// call dfs
				dfs(i, parent, timer, dicoveryTime, low, visited, result, adjList);
			}
		}

		return result;
	}

	/**
	 * DFS call
	 * 
	 * @param node
	 * @param parent
	 * @param timer
	 * @param dicoveryTime
	 * @param low
	 * @param visited
	 * @param result
	 * @param adjList
	 */
	private static void dfs(int node, int parent, int timer, int[] dicoveryTime, int[] low,
			Map<Integer, Boolean> visited, List<List<Integer>> result, Map<Integer, ArrayList<Integer>> adjList) {

		visited.put(node, true);
		dicoveryTime[node] = low[node] = timer++;

		ArrayList<Integer> neighbours = adjList.get(node);
		for (int neighbour : neighbours) {
			if (parent == neighbour)
				continue;
			if (!visited.get(neighbour)) {
				dfs(neighbour, node, timer, dicoveryTime, low, visited, result, adjList);

				// update low
				low[node] = Math.min(low[node], low[neighbour]);

				// check if the particular edge is bridge or not
				if (low[neighbour] > dicoveryTime[node]) {
					result.add(new ArrayList<>(Arrays.asList(new Integer[] { node, neighbour })));
				}

			} else {
				// back edge: node already visited and not a parent node
				low[node] = Math.min(low[node], dicoveryTime[neighbour]);
			}
		}
	}

	/**
	 * This method is created to get the information of the adjacency list
	 * 
	 * @param adjList holds the information of adjacency list
	 * @param edges   holds the information of edges
	 * @param e       total number of edges
	 */
	private static void prepareAdjList(Map<Integer, ArrayList<Integer>> adjList, int[][] edges, int e) {
		for (int i = 0; i < e; i++) {
			int u = edges[i][0];
			int v = edges[i][1];

			ArrayList<Integer> temp = adjList.get(u);
			temp.add(v);
			adjList.put(u, temp);

			temp = adjList.get(v);
			temp.add(u);
			adjList.put(v, temp);
		}
	}
}
