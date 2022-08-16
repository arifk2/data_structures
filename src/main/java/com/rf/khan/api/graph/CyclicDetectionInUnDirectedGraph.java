package com.rf.khan.api.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * This method is created to get the cyclic detection in the undirected graph
 * 
 * Time complexity: Linear
 * 
 * @author mkhan339
 *
 */
public class CyclicDetectionInUnDirectedGraph {
	public static String cycleDetection(int[][] edges, int n, int m) {

		// create adjacency list
		Map<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < n; i++)
			adjList.put(1 + i, new ArrayList<Integer>());

		getAdjList(adjList, edges, m);

		// create visited
		Map<Integer, Boolean> visited = new HashMap<>();
		for (int i = 0; i < n; i++)
			visited.put(i + 1, false);

		// to handle the disconnected graph
		for (int i = 0; i < n; i++) {
			int node = i + 1;
			if (!visited.get(node)) {
				boolean isCyclic = isCyclicDFS(node, -1, visited, adjList);
				if (isCyclic)
					return "Yes";
			}
		}
		return "No";
	}

	/**
	 * This method is created to get the adjacency list
	 * 
	 * @param adjList holds the information of the adjacency list
	 * @param edges   holds the information of the edges
	 * @param m       total edges
	 */
	private static void getAdjList(Map<Integer, ArrayList<Integer>> adjList, int[][] edges, int m) {
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

	/**
	 * This method is created to get the cyclic behavior of a graph using DFS
	 * 
	 * @param node    holds the information of the node
	 * @param parent  holds the information of the parent
	 * @param visited holds the information of the visited array
	 * @param adjList holds the information of adjacency list
	 * @return true/false
	 */
	private static boolean isCyclicDFS(int node, int parent, Map<Integer, Boolean> visited,
			Map<Integer, ArrayList<Integer>> adjList) {
		visited.put(node, true);

		ArrayList<Integer> neighbours = adjList.get(node);
		for (int neighbour : neighbours) {
			if (!visited.get(neighbour)) {
				boolean cycleDetected = isCyclicDFS(neighbour, node, visited, adjList);
				if (cycleDetected)
					return true;
			} else if (neighbour != parent) {
				return true;
			}
		}

		return false;
	}

	/**
	 * This method is created to get the cyclic behavior of a graph using BFS
	 * 
	 * @param node    holds the information of the node
	 * @param visited tells about the visited node
	 * @param adjList holds the information of the adjacency list
	 * @return true/false
	 */
	private static boolean isCyclicBFS(int node, Map<Integer, Boolean> visited,
			Map<Integer, ArrayList<Integer>> adjList) {
		Map<Integer, Integer> parent = new HashMap<Integer, Integer>();

		parent.put(node, -1);
		visited.put(node, true);

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node);

		while (!q.isEmpty()) {
			int frontNode = q.peek();
			q.poll();

			ArrayList<Integer> neighbours = adjList.get(frontNode);

			for (int neighbour : neighbours) {
				if ((visited.containsKey(neighbour) && visited.get(neighbour) == true)
						&& (visited.containsKey(neighbour) && neighbour != parent.get(frontNode))) {
					return true;
				} else if (visited.containsKey(neighbour) && visited.get(neighbour) == false) {
					q.add(neighbour);
					visited.put(neighbour, true);
					parent.put(neighbour, frontNode);
				}
			}
		}
		return false;
	}

	/**
	 * Driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 4, m = 3;
		int edge[][] = { { 1, 4 }, { 4, 3 }, { 3, 1 } };
		System.out.println(cycleDetection(edge, n, m));
	}
}
