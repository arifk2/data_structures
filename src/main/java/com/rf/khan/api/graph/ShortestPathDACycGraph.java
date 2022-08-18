package com.rf.khan.api.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * This class is created to store the value of edges with weight
 * 
 * * Time complexity O(n+e)
 * 
 * * Space Complexity O(n+e)
 * 
 * @author mkhan339
 *
 * @param <T>
 */
class Pair<T> {
	T first;
	T second;

	public Pair() {
	}

	public Pair(T t1, T t2) {
		this.first = t1;
		this.second = t2;
	}
}

/**
 * This is a class to get the shortest path in a directed acyclic graph
 * 
 * @author mkhan339
 *
 */
public class ShortestPathDACycGraph {

	Map<Integer, List<Pair<Integer>>> adjList = new HashMap<>();

	/**
	 * This method is created to add the edge
	 * 
	 * @param u      information of the u
	 * @param v      information of the v
	 * @param weight information of the weight
	 */
	public void addEdge(int u, int v, int weight) {
		Pair<Integer> p = new Pair<Integer>(v, weight);
		List<Pair<Integer>> temp = adjList.get(u);
		temp.add(p);
		adjList.put(u, temp);
	}

	/**
	 * This method is created for the topological sort
	 * 
	 * @param nodes holds the information of the node
	 * @return
	 */
	public Stack<Integer> topologicalSort(int nodes) {
		// create visited array
		Map<Integer, Boolean> visited = new HashMap<>();
		for (int i = 0; i < nodes; i++)
			visited.put(i, false);

		Stack<Integer> topoStack = new Stack<>();
		// dfs call for all the nodes
		for (int i = 0; i < nodes; i++) {
			if (!visited.get(i)) {
				dfs(i, visited, topoStack);
			}
		}

		return topoStack;
	}

	/**
	 * This method is created for the depth first search
	 * 
	 * @param node      holds the information of the node
	 * @param visited   holds the information of the visited array
	 * @param adjList   holds the information of the adjacency node
	 * @param topoStack holds the information of stack
	 */
	private void dfs(int node, Map<Integer, Boolean> visited, Stack<Integer> topoStack) {
		visited.put(node, true);

		for (Pair<Integer> neighbour : adjList.get(node)) {
			if (!visited.get(neighbour.first)) {
				dfs(neighbour.first, visited, topoStack);
			}
		}
		topoStack.push(node);
	}

	/**
	 * This method is to print the adjacency list
	 */
	public void printAdjList() {
		for (Map.Entry<Integer, List<Pair<Integer>>> i : adjList.entrySet()) {
			System.out.print(i.getKey() + " -> ");
			for (Pair<Integer> j : i.getValue()) {
				System.out.print("(" + j.first + "," + j.second + "), ");
			}
			System.out.println();
		}
	}

	/**
	 * This method is created to initiate the graph
	 * 
	 * @param g holds the information of the class object
	 */
	public void initGraph(ShortestPathDACycGraph g) {
		int nodes = 6;
		for (int i = 0; i < nodes; i++)
			adjList.put(i, new ArrayList<>());

		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 2, 2);
		g.addEdge(1, 3, 6);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 4, -1);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(4, 5, -2);

		// Step 1: Topological sort to get the stack
		Stack<Integer> topStack = g.topologicalSort(nodes);

		int source = 1;

		// Step 2: Creating distance
		int[] distance = new int[nodes];
		for (int i = 0; i < nodes; i++)
			distance[i] = Integer.MAX_VALUE;

		// Step 3: Getting shortest distance
		g.shortestDistance(source, distance, topStack);

		System.out.println("Printing adjacency list with weights");
		// Step 4: printing adjacency node
		printAdjList();

		// Step 5:Printing answer
		System.out.println("\nShortest path in directed acyclic graph");
		Arrays.stream(distance).forEach(i -> System.out.print(i + ", "));

	}

	/**
	 * This method is created to get the shortest distance
	 * 
	 * @param source   holds the information of the source node
	 * @param distance holds the information of the distance
	 * @param topStack holds the information of the topological stack
	 */
	private void shortestDistance(int source, int[] distance, Stack<Integer> topStack) {
		distance[source] = 0;

		while (!topStack.isEmpty()) {
			int top = topStack.peek();
			topStack.pop();

			if (distance[top] != Integer.MAX_VALUE) {
				for (Pair<Integer> neighbour : adjList.get(top)) {
					if ((distance[top] + neighbour.second) < distance[neighbour.first]) {
						// update distance
						distance[neighbour.first] = distance[top] + neighbour.second;
					}
				}
			}
		}
	}

	/**
	 * Driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ShortestPathDACycGraph graph = new ShortestPathDACycGraph();
		graph.initGraph(graph);
	}
}
