package com.rf.khan.api.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is created to tell cyclic behavior of graph
 * 
 * Time Complexity O(n+e)
 * 
 * @author mkhan339
 *
 */
public class CycleInDirectedGraphCS {

	/**
	 * This method is created to check that graph is cyclic or not
	 * 
	 * @param n     number of nodes
	 * @param edges edges list
	 * @return true/false
	 */
	public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {

		Map<Integer, List<Integer>> adjList = new HashMap<>();
		for (int i = 1; i <= n; i++)
			adjList.put(i, new ArrayList<>());

		getAdjList(adjList, edges, edges.size());

		// create visited
		Map<Integer, Boolean> visited = new HashMap<>();
		for (int i = 1; i <= n; i++)
			visited.put(i, false);

		// created dfs visited
		Map<Integer, Boolean> dfsVisited = new HashMap<>();
		for (int i = 1; i <= n; i++)
			dfsVisited.put(i, false);

		// call dfs for all the component
		for (int i = 1; i <= n; i++) {
			if (!visited.get(i)) {
				boolean cycleFound = checkCycleDFS(i, adjList, visited, dfsVisited);
				if (cycleFound)
					return true;
			}
		}
		return false;
	}

	/**
	 * This method is created to check the cycle directed graph using DFS
	 * 
	 * @param node       holds the information of the node
	 * @param adjList    holds the information of the adjacent list
	 * @param visited    holds the information of the visited array
	 * @param dfsVisited holds the information of the visited dfs call
	 * @return true/false
	 */
	private static boolean checkCycleDFS(int node, Map<Integer, List<Integer>> adjList, Map<Integer, Boolean> visited,
			Map<Integer, Boolean> dfsVisited) {

		visited.put(node, true);
		dfsVisited.put(node, true);

		for (int neighbour : adjList.get(node)) {
			if (!visited.get(neighbour)) {
				boolean cycleDetected = checkCycleDFS(neighbour, adjList, visited, dfsVisited);
				if (cycleDetected)
					return true;
			} else if (dfsVisited.get(neighbour)) {
				return true;
			}
		}
		dfsVisited.put(node, false);
		return false;
	}

	/**
	 * This method is created to get the adjacent nodes
	 * 
	 * @param adjList holds the information of the adjacent list
	 * @param edges   holds the information of the edges
	 * @param size    size of the edges
	 */
	private static void getAdjList(Map<Integer, List<Integer>> adjList, ArrayList<ArrayList<Integer>> edges, int size) {
		for (int i = 0; i < size; i++) {
			int u = edges.get(i).get(0);
			int v = edges.get(i).get(1);

			List<Integer> temp = adjList.get(u);
			temp.add(v);
			adjList.put(u, temp);
		}

	}

	public static void main(String[] args) {
		int node = 5;
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
		edges.add(new ArrayList<>(Arrays.asList(1, 2)));
		edges.add(new ArrayList<>(Arrays.asList(2, 3)));
		edges.add(new ArrayList<>(Arrays.asList(3, 4)));
		edges.add(new ArrayList<>(Arrays.asList(4, 5)));
		System.out.println(detectCycleInDirectedGraph(node, edges));
	}
}
