package com.rf.khan.api.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * shortest path in un-directed graph
 * 
 * @author mkhan339
 * 
 *         * Time Complexity O(n+e)
 * 
 *         * Space Complexity (n+e)
 *
 */
public class ShortestPathInUnDirectedGraph {

	public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {

		// Step 1: create adjacency list
		Map<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 1; i <= n; i++)
			adjList.put(i, new ArrayList<>());
		prepareAdjList(adjList, edges, m);

		// Step 2: created visited
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		for (int i = 1; i <= n; i++)
			visited.put(i, false);

		// Step 3: create parent
		Map<Integer, Integer> parent = new HashMap<>();
		for (int i = 1; i <= n; i++)
			parent.put(i, -1);

		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited.put(s, true);
		parent.put(s, -1);

		while (!q.isEmpty()) {
			int frontNode = q.peek();
			q.poll();
			for (int neighbour : adjList.get(frontNode)) {
				if (!visited.get(neighbour)) {
					visited.put(neighbour, true);
					parent.put(neighbour, frontNode);
					q.add(neighbour);
				}
			}
		}

		// Step 4: prepare answer to get the shortest path
		LinkedList<Integer> ans = new LinkedList<Integer>();
		int currentNode = t;
		ans.add(t);
		while (currentNode != s) {
			currentNode = parent.get(currentNode);
			ans.add(currentNode);
		}

		// Step5: reverse answer
		Collections.reverse(ans);
		return ans;
	}

	/**
	 * This method is created to prepare adjacency list of the graph
	 * 
	 * @param adjList holds the information of adjacency list
	 * @param edges   holds the information of
	 * @param m       total number of edges
	 */
	private static void prepareAdjList(Map<Integer, ArrayList<Integer>> adjList, int[][] edges, int m) {
		for (int i = 0; i < m; i++) {
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
