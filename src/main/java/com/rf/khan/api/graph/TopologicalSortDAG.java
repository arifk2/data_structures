package com.rf.khan.api.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TopologicalSortDAG {

	/**
	 * This method is created for the topological sort
	 * 
	 * @param edges holds the information of the edge array
	 * @param v     number of node
	 * @param e     number of edge
	 * @return true/false
	 */
	public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
		ArrayList<Integer> ans = new ArrayList<>();

		// prepare adjacency list
		Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
		for (int i = 0; i < v; i++)
			adjList.put(i, new ArrayList<Integer>());
		getAdjList(adjList, e, edges);

		Map<Integer, Boolean> visited = new HashMap<>();
		for (int i = 0; i < v; i++)
			visited.put(i, false);

		Stack<Integer> stack = new Stack<>();

		// call depth first search topological utility function for all components;
		for (int i = 0; i < v; i++) {
			if (!visited.get(i)) {
				topologicalSortUtil(i, visited, stack, adjList);
			}
		}

		// creating answer
		while (!stack.isEmpty()) {
			ans.add(stack.pop());
		}
		return ans;
	}

	/**
	 * This is a utility method to get the topological sort in DAG
	 * 
	 * @param node    holds the information of the node
	 * @param visited holds the information of the visited node
	 * @param stack   holds the track for the ans
	 * @param adjList holds information of the adjacency node
	 */
	private static void topologicalSortUtil(int node, Map<Integer, Boolean> visited, Stack<Integer> stack,
			Map<Integer, ArrayList<Integer>> adjList) {
		visited.put(node, true);

		for (int neighbour : adjList.get(node)) {
			if (!visited.get(neighbour)) {
				topologicalSortUtil(neighbour, visited, stack, adjList);
			}
		}
		stack.push(node);

	}

	/**
	 * This method is created to get the adjacency list
	 * 
	 * @param adjList holds the information of the adjacency list
	 * @param e       size of the edge
	 * @param edges   holds the information of the edge
	 */
	private static void getAdjList(Map<Integer, ArrayList<Integer>> adjList, int e,
			ArrayList<ArrayList<Integer>> edges) {
		for (int i = 0; i < e; i++) {
			int u = edges.get(i).get(0);
			int v = edges.get(i).get(1);

			ArrayList<Integer> temp = adjList.get(u);
			temp.add(v);
			adjList.put(u, temp);
		}
	}
}
