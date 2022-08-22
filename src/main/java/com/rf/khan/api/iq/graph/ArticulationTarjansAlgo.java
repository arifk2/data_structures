package com.rf.khan.api.iq.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is created to get the number or articulation point
 * 
 * Articulation Point: If we remove a node and its all edge, then graph breaks
 * into two or more component
 * 
 * Time complexity O(v+e) 
 * 
 * Space Complexity O(n)
 * 
 * @author mkhan339
 *
 */
public class ArticulationTarjansAlgo {

	/**
	 * This method will tell the number of articulation points in the graph
	 * 
	 * @param edges holds the information of the edges
	 * @param v     total number of nodes
	 * @param e     total number of edges
	 * @return list of articulation point
	 */
	public static List<Integer> findArticulationNode(int[][] edges, int v, int e) {
		Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
		for (int i = 0; i < v; i++)
			adjList.put(i, new ArrayList<>());

		prepareAdjList(adjList, edges, e);

		// required data-structure
		int timer = 0;
		int[] disc = new int[v];
		int[] low = new int[v];
		boolean[] visited = new boolean[v];

		List<Integer> articulationNode = new ArrayList<>();

		// Initialization
		for (int i = 0; i < v; i++) {
			disc[i] = -1;
			low[i] = -1;
			visited[i] = false;
		}

		// call dfs for all the nodes
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				dfs(i, -1, adjList, visited, disc, low, articulationNode, timer);
			}
		}

		return articulationNode;
	}

	/**
	 * DFS method
	 * 
	 * @param node
	 * @param parent
	 * @param adjList
	 * @param visited
	 * @param disc
	 * @param low
	 * @param articulaionNode
	 * @param timer
	 */
	private static void dfs(int node, int parent, Map<Integer, ArrayList<Integer>> adjList, boolean[] visited,
			int[] disc, int[] low, List<Integer> articulaionNode, int timer) {

		visited[node] = true;
		disc[node] = low[node] = timer++;
		int child = 0;
		for (int nbr : adjList.get(node)) {
			if (nbr == parent)
				continue;
			if (!visited[nbr]) {
				dfs(nbr, node, adjList, visited, disc, low, articulaionNode, timer);
				// agar child ka low update ho gaya to, apana low bhi update karna padega
				low[node] = Math.min(low[node], low[nbr]);

				// check articulation point or not
				if (low[nbr] >= disc[node] && parent != -1) {
					articulaionNode.add(node);
				}
				child++;
			} else {
				// back edge
				low[node] = Math.min(low[node], disc[nbr]);
			}
		}

		// starting node
		if (parent == -1 && child > 1) {
			articulaionNode.add(node);
		}
	}

	/**
	 * This method is created to get the information of the adjacency list
	 * 
	 * @param adjList holds the information of adjacency list
	 * @param edges   holds the information of edges
	 * @param e       total number of edges
	 */
	private static void prepareAdjList(Map<Integer, ArrayList<Integer>> adjList, int[][] edges, int e) {
		for (int i = 0; i < e; i++) {
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
	 * Driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] edges = { { 0, 3 }, { 3, 4 }, { 0, 4 }, { 0, 1 }, { 1, 2 } };

		int v = 5;
		int e = 5;
		System.out.println("Articulation Points are :-> " + findArticulationNode(edges, v, e));
	}
}
