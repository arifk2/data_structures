package com.rf.khan.api.iq.graph.striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
	int first;
	int second;

	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}

}

// Print shortest distance of weighted graph using Dijaktra Algorithm
//https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
public class G35PrintShortestPath {
	public static void main(String[] args) {
		int n = 5, m = 6;
		int[][] edges = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };
		int[][] edges2 = { { 1, 2, 2 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 } };

		List<Integer> result = shortestPath(n, m, edges);
		System.out.println(result);
		System.out.println(shortestPath(4, 4, edges2));

	}

	public static List<Integer> shortestPath(int n, int m, int edges[][]) {

		// Create an adjacency list of pairs of the form node1 -> {node2, edge weight}
		// where the edge weight is the weight of the edge from node1 to node2.
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
			adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
		}

		// Create a priority queue for storing the nodes along with distances
		// in the form of a pair { dist, node }.
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.first - y.first);

		// Create a dist array for storing the updated distances and a parent array
		// for storing the nodes from where the current nodes represented by indices of
		// the parent array came from.

		int[] distance = new int[n + 1];
		int[] parent = new int[n + 1];

		// update distance and parent
		for (int i = 1; i <= n; i++) {
			distance[i] = (int) (1e9); // infinite
			parent[i] = i;
		}

		distance[1] = 0;

		// push the source node into the PQ (distance, node)
		pq.add(new Pair(0, 1));

		while (!pq.isEmpty()) {
			// Top most of the PQ will have the minimum distance value
			Pair it = pq.peek();
			int dist = it.first;
			int node = it.second;
			pq.remove();

			// Iterate through the adjacent node

			for (Pair iter : adj.get(node)) {
				int adjNode = iter.first;
				int edW = iter.second;

				/**
				 * Check the previously store distance value is greater than the current
				 * computed value or not, if yes then update the distance value.
				 **/

				if (dist + edW < distance[adjNode]) {
					distance[adjNode] = dist + edW;
					pq.add(new Pair(dist + edW, adjNode));

					// update the parent of the adjNode to the recent node where it come from.
					parent[adjNode] = node;
				}
			}
		}

		// Store the final path in the 'path' array
		List<Integer> path = new ArrayList<Integer>();

		// If distance to the node is not found, then return an array containing as -1.
		if (distance[n] == 1e9) {
			path.add(-1);
			return path;
		}

		int node = n;

		while (parent[node] != node) {
			path.add(node);
			node = parent[node];
		}
		path.add(1);

		// Since the path stored is in a reverse order, we reverse the array
		// to get the final answer and then return the array.
		Collections.reverse(path);
		return path;
	}
}
