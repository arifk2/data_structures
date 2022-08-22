package com.rf.khan.api.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Time Complexity : O(E log V) Space complexity : O(V+E)
 * 
 * @author mkhan339
 *
 */
public class DijkstraAlgoShortestPath {

	static class Pair<T> {
		public T first;
		public T second;

		public Pair(T t1, T t2) {
			this.first = t1;
			this.second = t2;
		}
	}

	/**
	 * This method is created to get the shortest path from the source
	 * 
	 * @param vec      holds the information of the u , v and weight
	 * @param vertices total number of nodes
	 * @param edges    total number of edges
	 * @param source   source
	 * @return shortest distance array
	 */
	public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> vec, int vertices, int edges, int source) {

		// Step 1: Create adjacency list
		Map<Integer, ArrayList<Pair<Integer>>> adjList = new HashMap<>();
		for (int i = 0; i < vertices; i++)
			adjList.put(i, new ArrayList<>());

		getAdjList(adjList, vec, edges);

		// print adjacency list
		printAdjList(adjList);

		// Step 2: create distance array
		Integer[] distance = new Integer[vertices];
		for (int i = 0; i < vertices; i++)
			distance[i] = Integer.MAX_VALUE;

		// Step 3 (a): create set to get always minimum distance value : (distance -
		// node)
		SortedSet<Pair<Integer>> st = new TreeSet<>(new Comparator<Pair<Integer>>() {
			public int compare(Pair<Integer> p1, Pair<Integer> p2) {
				return p1.first.compareTo(p2.first);
			}
		});

		// Step 3 (b) : Creation of source node on the basis of <distance-node>
		// insert in set
		distance[source] = 0;
		st.add(new Pair<Integer>(0, source));

		// Step 4: dijkstra algorithms
		while (!st.isEmpty()) {

			// 4(a) fetch top record
			Pair<Integer> top = st.first();
			int nodeDistance = top.first;
			int node = top.second;

			// 4(b) remove top record
			st.remove(st.first());

			// 4(c) Traverse on neighbor
			ArrayList<Pair<Integer>> neighbours = adjList.get(node);
			for (Pair<Integer> neighbour : neighbours) {
				if (nodeDistance + neighbour.second < distance[neighbour.first]) {

					// Pair<Integer> pair = new Pair<Integer>(distance[neighbour.first],
					// neighbour.first);

					Iterator<Pair<Integer>> it = st.iterator();
					while (it.hasNext()) {
						if (it.next().second == neighbour.first)
							it.remove();
						break;
					}

					// 4(d) update distance
					distance[neighbour.first] = nodeDistance + neighbour.second;

					// 4(e) insert into the set
					st.add(new Pair<Integer>(distance[neighbour.first], neighbour.first));
				}
			}
		}
		return new ArrayList<Integer>(Arrays.asList(distance));
	}

	/**
	 * This method is created to print the adjacency list
	 * 
	 * @param adjList holds the information of the adjacency list
	 */
	private static void printAdjList(Map<Integer, ArrayList<Pair<Integer>>> adjList) {
		for (Map.Entry<Integer, ArrayList<Pair<Integer>>> p : adjList.entrySet()) {
			System.out.print(p.getKey() + " -> ");
			for (Pair<Integer> n : p.getValue()) {
				System.out.print("(" + n.first + "," + n.second + "), ");
			}
			System.out.println();
		}
	}

	/**
	 * This method is created to prepare adjacency list
	 * 
	 * @param adjList holds the information of the adjacency list
	 * @param vec     holds the information of the u , v and weight
	 * @param edges   holds the information of the edges
	 */
	private static void getAdjList(Map<Integer, ArrayList<Pair<Integer>>> adjList, ArrayList<ArrayList<Integer>> vec,
			int edges) {
		for (int i = 0; i < edges; i++) {
			int u = vec.get(i).get(0);
			int v = vec.get(i).get(1);
			int w = vec.get(i).get(2);

			ArrayList<Pair<Integer>> temp = adjList.get(u);
			temp.add(new Pair<Integer>(v, w));
			adjList.put(u, temp);

			temp = adjList.get(v);
			temp.add(new Pair<Integer>(u, w));
			adjList.put(v, temp);
		}
	}

	/**
	 * This is a driver method to provide input and call the methods
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> vec = new ArrayList<>();
		int vertices = 5;
		int edges = 7;
		int source = 0;

		ArrayList<Integer> e1 = new ArrayList<>(Arrays.asList(new Integer[] { 0, 1, 7 }));
		ArrayList<Integer> e2 = new ArrayList<>(Arrays.asList(new Integer[] { 0, 2, 1 }));
		ArrayList<Integer> e3 = new ArrayList<>(Arrays.asList(new Integer[] { 0, 3, 2 }));
		ArrayList<Integer> e4 = new ArrayList<>(Arrays.asList(new Integer[] { 1, 2, 3 }));
		ArrayList<Integer> e5 = new ArrayList<>(Arrays.asList(new Integer[] { 1, 3, 5 }));
		ArrayList<Integer> e6 = new ArrayList<>(Arrays.asList(new Integer[] { 1, 4, 1 }));
		ArrayList<Integer> e7 = new ArrayList<>(Arrays.asList(new Integer[] { 3, 4, 7 }));

		vec.add(e1);
		vec.add(e2);
		vec.add(e3);
		vec.add(e4);
		vec.add(e5);
		vec.add(e6);
		vec.add(e7);
		System.out.println("Shortest Path arrays");
		System.out.println(dijkstra(vec, vertices, edges, source));
	}
}
