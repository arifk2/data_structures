package com.rf.khan.api.iq.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

public class BFSInGraphUndirected {

	/**
	 * This is a driver method to generated the graph
	 * 
	 * @param vertex holds the information of the node
	 * @param edges  holds the information of the edge
	 * @return answer
	 */
	public static ArrayList<Integer> BFS(int vertex, int edges[][]) {
		Map<Integer, TreeSet<Integer>> adjList = new HashMap<>();

		for (int i = 0; i < vertex; i++)
			adjList.put(i, new TreeSet<>());

		ArrayList<Integer> ans = new ArrayList<>();

		Map<Integer, Boolean> visited = new HashMap<>();
		for (int i = 0; i < vertex; i++) {
			visited.put(i, false);
		}

		prepareAdjList(adjList, edges);

		// traverse all component of a graph
		for (int i = 0; i < vertex; i++) {
			if (!visited.get(i)) {
				bfs(adjList, visited, ans, i);
			}
		}
		return ans;
	}

	/**
	 * This method is created to manipulate
	 * 
	 * @param adjList holds the information of the adjacent node
	 * @param visited holds the information of the visited map
	 * @param ans     holds the information of the answer
	 * @param node    holds the information of the node
	 */
	private static void bfs(Map<Integer, TreeSet<Integer>> adjList, Map<Integer, Boolean> visited,
			ArrayList<Integer> ans, int node) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node);
		visited.put(node, true);

		while (!q.isEmpty()) {
			int frontNode = q.peek();
			q.poll();

			// store front node into answer;
			ans.add(frontNode);

			// traverse all neighbors of frontNode
			TreeSet<Integer> nb = adjList.get(frontNode);
			for (int i : nb) {
				if (!visited.get(i)) {
					q.add(i);
					visited.put(i, true);
				}
			}
		}
	}

	/**
	 * Prepare adjacency list
	 * 
	 * @param adjList
	 * @param edges
	 */
	private static void prepareAdjList(Map<Integer, TreeSet<Integer>> adjList, int[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];

			if (adjList.get(u) == null) {
				TreeSet<Integer> temp = new TreeSet<Integer>();
				temp.add(u);
				temp.add(v);
				adjList.put(u, temp);
			} else {
				TreeSet<Integer> temp = adjList.get(u);
				temp.add(v);
				adjList.put(u, temp);
			}

			if (adjList.get(v) == null) {
				TreeSet<Integer> temp = new TreeSet<Integer>();
				temp.add(v);
				temp.add(u);
				adjList.put(v, temp);
			} else {
				TreeSet<Integer> temp = adjList.get(v);
				temp.add(u);
				adjList.put(v, temp);
			}
		}
	}

	/**
	 * Driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int vertex = 9;

		int edges[][] = { { 0, 8 }, { 1, 6 }, { 1, 7 }, { 1, 8 }, { 5, 8 }, { 6, 0 }, { 7, 3 }, { 7, 4 }, { 8, 7 },
				{ 2, 5 } };
		System.out.println(BFS(vertex, edges));
	}
}
