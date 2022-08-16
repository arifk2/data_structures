package com.rf.khan.api.graph;

import java.util.Vector;

public class CPAdjacencyListCS {

	// Function to add edges
	static void addEdge(Vector<Integer> adj[], int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}

	static void initGraph(int V, int edges[][], int noOfEdges) {

		// To represent graph as adjacency list
		@SuppressWarnings("unchecked")
		Vector<Integer> adj[] = new Vector[V];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new Vector<>();
		}
		// Traverse edges array and make edges
		for (int i = 0; i < noOfEdges; i++) {

			// Function call to make an edge
			addEdge(adj, edges[i][0], edges[i][1]);
		}

		// Function Call to print adjacency list
		// adjacencylist(adj, V);
		
		for(int i = 0; i<V ; i++) {
			adj[i].add(i);
			for(int j = 0; j< adj[i].size(); j ++) {
				adj[i].add(adj[i].get(i));
			}
		}
		System.out.println(adj);
	}

	/**
	 * This method is created to print adjacency list
	 * 
	 * @param n
	 * @param m
	 * @param edges
	 * @return
	 */
	public static int[][] printAdjacency(int n, int m, int[][] edges) {
		initGraph(n, edges, m);
		
		return null;
	}

	/**
	 * This is driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int edges[][] = { { 2, 1 }, { 2, 0 } };
		int n = 3;
		int m = 2;
		printAdjacency(n, m, edges);
	}

}
