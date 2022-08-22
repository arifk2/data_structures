package com.rf.khan.api.iq.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinimumSpanningTreeCS {

	/**
	 * This method is created initialize the parent and rank
	 * 
	 * @param parent holds the information of the parent
	 * @param rank   holds the information of the rank
	 */
	private static void makeSet(int[] parent, int[] rank, int n) {
		for (int i = 0; i < n; i++) {
			// assuming that all the node as broken and have separate component in the
			// graph, so that parent of each node is itself
			parent[i] = i;

			// and rank rank of each node is 0
			rank[i] = 0;
		}
	}

	/**
	 * This method is created to get the parent of the node
	 * 
	 * @param parent holds the information of the parent
	 * @param node   holds the information of the node
	 * 
	 * @return
	 */
	public static int findParent(int[] parent, int node) {
		if (parent[node] == node) {
			return node;
		}
		return parent[node] = findParent(parent, parent[node]);
	}

	/**
	 * This method is created to get the union set
	 * 
	 * @param u      holds the information of the node
	 * @param v      holds the information of edge
	 * @param parent holds the information of the parent
	 */
	public static void unionSet(int u, int v, int[] parent, int[] rank) {
		u = findParent(parent, u);
		v = findParent(parent, v);

		// to get the union, if the rank of node1 is greater than node2 then parent of
		// node2 will be node1
		if (rank[u] < rank[v]) {
			parent[u] = v;
		} else if (rank[v] < rank[u]) {
			parent[v] = u;
		}
		// if the nodes are equal then mark anyone as parent but increment the rank
		else {
			parent[v] = u;
			rank[u]++;
		}
	}

	/**
	 * This method is created to get the minimum spanning Tree
	 * 
	 * @param edges
	 * @param n
	 * @return
	 */
	public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
		Collections.sort(edges, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return o1.get(2).compareTo(o2.get(2));
			}
		});

		int[] parent = new int[n];
		int[] rank = new int[n];
		makeSet(parent, rank, n);
		int minWeight = 0;

		for (int i = 0; i < edges.size(); i++) {
			int u = findParent(parent, edges.get(i).get(0));
			int v = findParent(parent, edges.get(i).get(1));
			int wt = edges.get(i).get(2);

			// if same then union else ignore add weight and get the union set
			if (u != v) {
				minWeight += wt;
				unionSet(u, v, parent, rank);
			}
		}

		return minWeight;
	}

}
