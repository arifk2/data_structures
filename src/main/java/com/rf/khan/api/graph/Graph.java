package com.rf.khan.api.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {

	static ArrayList<ArrayList<Integer>> adj;

	void addEdge(int u, int v, int direction) {
		// direction = 0 -> undirected graph
		// direction = 1 -> directed graph

		adj.get(u).add(v);
		if (direction == 0) {
			adj.get(v).add(u);
		}

		// create and edge from u to v;
	}

	/**
	 * This method is create to print the graph
	 */
	void printGraph() {
		for (int i = 0; i < adj.size(); i++) {
			System.out.print("Node::" + i);
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" -> " + adj.get(i).get(j));
			}
			System.out.println();
		}
	}

	public static int[][] printAdjacency(int n, int m, int[][] edges) {
		Map<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();
		for (int i = 0; i < m; i++) {
			int u = edges[i][0];
			int v = edges[i][1];

			if (adjacencyList.get(u) == null) {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(u);
				temp.add(v);
				adjacencyList.put(u, temp);
			} else {
				ArrayList<Integer> temp = adjacencyList.get(u);
				temp.add(v);
				adjacencyList.put(u, temp);
			}

			if (adjacencyList.get(v) == null) {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(v);
				temp.add(u);
				adjacencyList.put(v, temp);
			} else {
				ArrayList<Integer> temp = adjacencyList.get(v);
				temp.add(u);
				adjacencyList.put(v, temp);
			}
		}

		int[][] ans = new int[n][n];
		for (int i = 0; i < n; i++) {
			if (adjacencyList.get(i) != null) {
				ArrayList<Integer> temp = adjacencyList.get(i);
				int[] arr = temp.stream().mapToInt(j -> j).toArray();

				ans[i] = arr;
			} else {
				ans[i] = new int[] { i };
			}
		}
		return ans;
	}

	/**
	 * This is a driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		adj = new ArrayList<>();
		Graph graph = new Graph();

		// create a graph
		int node = 5;
		int edge = 6;
		for (int i = 0; i < node; i++)
			adj.add(new ArrayList<Integer>());

		// add edges
		graph.addEdge(0, 1, 0);
		graph.addEdge(1, 2, 0);
		graph.addEdge(2, 3, 0);
		graph.addEdge(3, 1, 0);
		graph.addEdge(3, 4, 0);
		graph.addEdge(0, 4, 0);

		graph.printGraph();

		System.out.println("------------------------------------");

	}

}
