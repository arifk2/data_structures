package com.rf.khan.api.iq.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CycleDirectedGraphBfsKahnsAlgo {

	public static Boolean isCyclic(int[][] edges, int v, int e) {
		// prepare adj list
		Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
		for (int i = 1; i <= v; i++)
			adjList.put(i, new ArrayList<>());

		prepareAdjList(adjList, edges, e);

		// Get inDegree
		int[] inDegree = new int[v];
		for (int i = 0; i < v; i++)
			inDegree[i] = 0;

		getInOrder(inDegree, adjList);

		// push all zero in degree to queue
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}

		// do bfs

		int count = 0;
		while (!q.isEmpty()) {
			int frontNode = q.peek();
			q.poll();

			count++;
			ArrayList<Integer> neighbours = adjList.get(frontNode);
			for (int neighbour : neighbours) {
				inDegree[neighbour]--;
				if (inDegree[neighbour] == 0)
					q.add(neighbour);
			}
		}

		if (count == v) {
			return false;
		}
		return true;
	}

	/**
	 * This method is created to get the inOrder
	 * 
	 * @param inDegree holds the information of the inOrder
	 * @param adjList  holds the information of the adjacency list
	 */
	private static void getInOrder(int[] inDegree, Map<Integer, ArrayList<Integer>> adjList) {

		for (Map.Entry<Integer, ArrayList<Integer>> node : adjList.entrySet()) {
			for (int i : node.getValue()) {
				inDegree[i]++;
			}
		}
	}

	/**
	 * This method is created to get the adjacency list
	 * 
	 * @param adjList holds the information of the adjacency list
	 * @param edges   holds the information of the edges
	 * @param e       number of edges
	 */
	private static void prepareAdjList(Map<Integer, ArrayList<Integer>> adjList, int[][] edges, int e) {
		for (int i = 0; i < e; i++) {
			int u = edges[i][0];
			int v = edges[i][1];

			ArrayList<Integer> temp = adjList.get(u);
			temp.add(v);

			adjList.put(u, temp);
		}
	}

	public static void main(String[] args) {
		int node = 5;
		int e = 5;
		int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 1 } };
		System.out.println(isCyclic(edges, node, e));
	}
}
