package com.rf.khan.api.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class KahnsAlgoTopologicalSort {
	/**
	 * This method is created for the topological sort using kahns Algorithm
	 * 
	 * @param edges holds the information of edges
	 * @param v     total number of nodes/vertexes
	 * @param e     total number of edge list
	 * @return answer
	 */
	public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {

		// Step 1: create adjacency list
		Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
		for (int i = 0; i < v; i++)
			adjList.put(i, new ArrayList<Integer>());

		getAdjList(adjList, e, edges);

		// Step 2: get all in-degree
		Map<Integer, Integer> inDegree = new HashMap<Integer, Integer>(v);
		for (int i = 0; i < v; i++)
			inDegree.put(i, 0);

		getAllInDegree(inDegree, adjList);

		// Step3: push all the 0 in-degree to the queue;
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < inDegree.size(); i++) {
			if (inDegree.get(i) == 0)
				q.add(i);
		}
		// Step 4: do BFS for all the component in the graph
		ArrayList<Integer> ans = new ArrayList<>();

		while (!q.isEmpty()) {
			int frontNode = q.peek();
			q.poll();

			// add the answer
			ans.add(frontNode);

			ArrayList<Integer> neigbours = adjList.get(frontNode);
			for (int neigbour : neigbours) {
				inDegree.put(neigbour, inDegree.get(neigbour) - 1);
				if (inDegree.get(neigbour) == 0)
					q.add(neigbour);
			}
		}

		return ans;
	}

	/**
	 * This method is created to get the in-degree of the graph
	 * 
	 * @param inDegree holds the information of the in-degree
	 * @param adjList  holds the information of the adjacency list
	 */
	private static void getAllInDegree(Map<Integer, Integer> inDegree, Map<Integer, ArrayList<Integer>> adjList) {

		for (Map.Entry<Integer, ArrayList<Integer>> i : adjList.entrySet()) {
			for (int j : i.getValue()) {
				inDegree.put(j, inDegree.get(j) + 1);
			}
		}
	}

	/**
	 * This method is created to get the adjacency list
	 * 
	 * @param adjList holds the information of the adjacency list
	 * @param e       total edges
	 * @param edges   edges list
	 */
	private static void getAdjList(Map<Integer, ArrayList<Integer>> adjList, int e,
			ArrayList<ArrayList<Integer>> edges) {

		for (int i = 0; i < e; i++) {
			int u = edges.get(i).get(0);
			int v = edges.get(i).get(1);

			ArrayList<Integer> temp = adjList.get(u);
			temp.add(v);
			adjList.put(u, temp);
		}
	}

	/**
	 * This is a driver method to give the input and call the function
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> e1 = new ArrayList<Integer>();
		e1.add(0);
		e1.add(1);

		ArrayList<Integer> e2 = new ArrayList<Integer>();
		e2.add(0);
		e2.add(2);

		ArrayList<Integer> e3 = new ArrayList<Integer>();
		e3.add(2);
		e3.add(3);

		ArrayList<Integer> e4 = new ArrayList<Integer>();
		e4.add(1);
		e4.add(3);

		ArrayList<Integer> e5 = new ArrayList<Integer>();
		e5.add(3);
		e5.add(4);

		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
		edges.add(e1);
		edges.add(e2);
		edges.add(e3);
		edges.add(e4);
		edges.add(e5);

		int v = 5;
		int e = 5;
		System.out.println(topologicalSort(edges, v, e));
	}
}
