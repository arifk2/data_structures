package com.rf.khan.api.iq.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DirectedGraphBFS {
	// Function to return Breadth First Traversal of given graph.
	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Map<Integer, Boolean> visited = new HashMap<>();
		for (int i = 0; i < V; i++) {
			visited.put(i, false);
		}

		bfs(adj, visited, ans, 0);
		return ans;
	}

	public void bfs(ArrayList<ArrayList<Integer>> adj, Map<Integer, Boolean> visited, ArrayList<Integer> ans,
			int node) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node);
		visited.put(node, true);

		while (!q.isEmpty()) {
			int frontNode = q.peek();
			q.poll();

			ans.add(frontNode);

			// traverse neighbours
			ArrayList<Integer> nb = adj.get(frontNode);
			for (int i : nb) {
				if (!visited.get(i)) {
					q.add(i);
					visited.put(i, true);
				}
			}
		}
	}
}