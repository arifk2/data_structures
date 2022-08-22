package com.rf.khan.api.iq.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * To get the strongly connected component in the graph, we need to apply
 * kosaraju's algorithms
 * 
 * Strongly connected graph are those, if every vertexes is reachable from every
 * other vertexes present in the graph
 * 
 * @author mkhan339
 *
 */
public class KosarajusAlgorithmStronglyConnectedComponent {

	/**
	 * This method is created to get the strongly connected graph
	 * 
	 * @param v     total number of vertexes
	 * @param edges edges information
	 * @return SCC count
	 */
	public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> edges) {

		// prepare adjacency list
		Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			adjList.put(i, new ArrayList<>());
			visited[i] = false;
		}
		prepareAdjList(edges, adjList);

		// Step 1: topological sort
		Stack<Integer> st = new Stack<>();

		// Step 2: call for all the nodes
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				dfs(i, adjList, st, visited);
			}
		}

		// Step 3: create a transpose graph
		Map<Integer, List<Integer>> transpose = new HashMap<>();
		for (int i = 0; i < v; i++)
			transpose.put(i, new ArrayList<>());

		for (int i = 0; i < v; i++) {
			visited[i] = false;

			ArrayList<Integer> nbrs = adjList.get(i);
			for (int nbr : nbrs) {
				List<Integer> temp = transpose.get(nbr);
				temp.add(i);
				transpose.put(nbr, temp);
			}
		}

		// Step 4: reverse dfs call using transpose graph
		int count = 0;
		while (!st.isEmpty()) {
			int top = st.peek();
			st.pop();
			if (!visited[top]) {
				count++;
				revDfs(top, visited, transpose);
			}
		}

		return count;
	}

	/**
	 * This method is created for the reverse dfs for the transpose graph
	 * 
	 * @param node    holds the information of the top node
	 * @param visited holds the information of the visited
	 * @param adjList holds the information of the adjacency list
	 */
	private static void revDfs(int node, boolean[] visited, Map<Integer, List<Integer>> adjList) {
		visited[node] = true;
		for (int nbr : adjList.get(node)) {
			if (!visited[nbr]) {
				revDfs(nbr, visited, adjList);
			}
		}
	}

	/**
	 * topo dfs
	 * 
	 * @param node
	 * @param adjList
	 * @param st
	 * @param visited
	 */
	private static void dfs(int node, Map<Integer, ArrayList<Integer>> adjList, Stack<Integer> st, boolean[] visited) {
		visited[node] = true;

		for (int neighbour : adjList.get(node)) {
			if (!visited[neighbour]) {
				dfs(neighbour, adjList, st, visited);
			}
		}
		st.push(node);
	}

	/**
	 * Prepare adjacency list
	 * 
	 * @param edges   edges information
	 * @param adjList adjacency list
	 */
	private static void prepareAdjList(ArrayList<ArrayList<Integer>> edges, Map<Integer, ArrayList<Integer>> adjList) {
		for (int i = 0; i < edges.size(); i++) {
			int u = edges.get(i).get(0);
			int v = edges.get(i).get(1);

			ArrayList<Integer> temp = adjList.get(u);
			temp.add(v);
			adjList.put(u, temp);

		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
		ArrayList<Integer> e1 = new ArrayList<>(Arrays.asList(new Integer[] { 1, 0 }));
		ArrayList<Integer> e2 = new ArrayList<>(Arrays.asList(new Integer[] { 1, 2 }));
		ArrayList<Integer> e3 = new ArrayList<>(Arrays.asList(new Integer[] { 0, 2 }));
		ArrayList<Integer> e4 = new ArrayList<>(Arrays.asList(new Integer[] { 2, 3 }));
		ArrayList<Integer> e5 = new ArrayList<>(Arrays.asList(new Integer[] { 3, 4 }));

		int v = 5;

		edges.add(e1);
		edges.add(e2);
		edges.add(e3);
		edges.add(e4);
		edges.add(e5);

		System.out.println(stronglyConnectedComponents(v, edges));
	}
}
