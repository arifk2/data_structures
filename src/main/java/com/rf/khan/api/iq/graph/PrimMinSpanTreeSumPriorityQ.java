package com.rf.khan.api.iq.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PrimMinSpanTreeSumPriorityQ {

	static class Pair implements Comparable<Pair> {
		int first;
		int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public int compareTo(Pair that) {
			return this.second - that.second;
		}

	}

	/**
	 * This method is created to calculate the minimum spanning tree
	 * 
	 * @param n total number of nodes: start from 1
	 * @param m total number of edges
	 * @param g information of the edges
	 * @return
	 */
	public static int calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g) {

		// Step 1: create adjacency list
		Map<Integer, ArrayList<Pair>> adjList = new HashMap<>();
		for (int i = 0; i < n; i++)
			adjList.put(i, new ArrayList<>());
		prepareAdjList(m, g, adjList);

		// create required data structure
		PriorityQueue<Pair> key = new PriorityQueue<>();

		boolean[] mst = new boolean[n];

		// initialize
		for (int i = 0; i < n; i++) {
			mst[i] = false;
		}

		int source = 0;
		key.add(new Pair(source, 0));
		int answer = 0;
		// for all the nodes
		while (!key.isEmpty()) {
			// get minimum weight in queue
			Pair current = key.peek();
			key.poll();
			int u = current.first;
			if (mst[u]) {
				continue;
			}
			answer += current.second;
			// mark mst as true for min
			mst[u] = true;

			// check for the adjacency node
			for (Pair neighbour : adjList.get(u)) {
				int node = neighbour.first;
				int weight = neighbour.second;

				if (mst[node] == false) {
					key.add(new Pair(node, weight));
				}
			}
		}

		return answer;
	}

	/**
	 * This method is created to prepare adjacency list
	 * 
	 * @param m       total numbers of edges
	 * @param g       information of the edges
	 * @param adjList adjacency list
	 */
	private static void prepareAdjList(int m, ArrayList<ArrayList<Integer>> g, Map<Integer, ArrayList<Pair>> adjList) {
		for (int i = 0; i < m; i++) {
			int u = g.get(i).get(0);
			int v = g.get(i).get(1);
			int w = g.get(i).get(2);

			ArrayList<Pair> temp = adjList.get(u);
			temp.add(new Pair(v, w));
			adjList.put(u, temp);

			temp = adjList.get(v);
			temp.add(new Pair(u, w));
			adjList.put(v, temp);
		}
	}

	/**
	 * Driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 5;
		int m = 6;
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		ArrayList<Integer> e1 = new ArrayList<>(Arrays.asList(new Integer[] { 0, 3, 6 }));
		ArrayList<Integer> e2 = new ArrayList<>(Arrays.asList(new Integer[] { 0, 1, 2 }));
		ArrayList<Integer> e3 = new ArrayList<>(Arrays.asList(new Integer[] { 3, 1, 8 }));
		ArrayList<Integer> e4 = new ArrayList<>(Arrays.asList(new Integer[] { 1, 2, 3 }));
		ArrayList<Integer> e5 = new ArrayList<>(Arrays.asList(new Integer[] { 1, 4, 5 }));
		ArrayList<Integer> e6 = new ArrayList<>(Arrays.asList(new Integer[] { 2, 4, 7 }));

		g.add(e1);
		g.add(e2);
		g.add(e3);
		g.add(e4);
		g.add(e5);
		g.add(e6);
		System.out.println("Weight of the spanning tree is: " + calculatePrimsMST(n, m, g));

	}
}
