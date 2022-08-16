package com.rf.khan.api.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Disconnected graph
 * 
 * @author mkhan339
 *
 */
public class DfsTraversalUndirectedCS {
	public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		// prepare adjacent list
		Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
		for (int i = 0; i < v; i++)
			adjList.put(i, new ArrayList<>());

		getAdjList(adjList, edges, e);
		Map<Integer, Boolean> visted = new HashMap<>();
		for (int i = 0; i < v; i++)
			visted.put(i, false);

		for (int i = 0; i < v; i++) {
			if (!visted.get(i)) {
				ArrayList<Integer> component = new ArrayList<Integer>();
				dfs(i, visted, adjList, component);
				ans.add(component);
			}
		}
		return ans;
	}

	/**
	 * DFS method
	 * 
	 * @param node      holds the information of the node
	 * @param visted    holds the information of the visited node
	 * @param adjList   holds the information of the adjacent node
	 * @param component hold the information of the component
	 */
	private static void dfs(int node, Map<Integer, Boolean> visted, Map<Integer, ArrayList<Integer>> adjList,
			ArrayList<Integer> component) {

		component.add(node);
		visted.put(node, true);

		// every connected node recursive call
		ArrayList<Integer> ad = adjList.get(node);
		for (int i : ad) {
			if (!visted.get(i)) {
				dfs(i, visted, adjList, component);
			}
		}
	}

	/**
	 * This method s created to get the adjacent node
	 * 
	 * @param adjList hold the output as a adjacent node
	 * @param edges   holds the information of the edge
	 * @param e       size of the edge
	 */
	private static void getAdjList(Map<Integer, ArrayList<Integer>> adjList, ArrayList<ArrayList<Integer>> edges,
			int e) {
		for (int i = 0; i < e; i++) {
			int uu = edges.get(i).get(0);
			int vv = edges.get(i).get(1);

			ArrayList<Integer> temp = adjList.get(uu);
			temp.add(vv);
			adjList.put(uu, temp);

			temp = adjList.get(vv);
			temp.add(uu);
			adjList.put(vv, temp);

		}
	}
}
