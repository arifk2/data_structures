package com.rf.khan.api.graph;

import java.util.ArrayList;

public class AdjacencyList {

	// A utility function to add an edge in an
	// undirected graph
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v, int condition) {
		adj.get(u).add(v);
		if (condition == 0) {
			adj.get(v).add(u);
		}
	}

	// A utility function to print the adjacency list
	// representation of graph
	static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		for (int i = 0; i < adj.size(); i++) {
			System.out.print(i);
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" -> " + adj.get(i).get(j));
			}
			System.out.println();
		}
	}

	// Driver Code
	public static void main(String[] args) {
		// Creating a graph with 5 node
		int V = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < 5; i++)
			adj.add(new ArrayList<Integer>());

		// Adding edges one by one
		addEdge(adj, 0, 1, 0);
		addEdge(adj, 1, 2, 0);
		addEdge(adj, 2, 3, 0);
		addEdge(adj, 3, 1, 0);
		addEdge(adj, 3, 4, 0);
		addEdge(adj, 0, 4, 0);

		printGraph(adj);
	}
}
