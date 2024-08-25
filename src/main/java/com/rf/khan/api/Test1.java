package com.rf.khan.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test1 {

	public static void main(String[] args) {
		Test1 test = new Test1();
		int n = 4;
		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
		int src = 0, dst = 3, k = 1;
		int[][] flight2 = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };

		System.out.println(test.findCheapestPrice(n, flights, src, dst, k));
		System.out.println(test.findCheapestPrice(3, flight2, 0, 2, 1));

	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

		// Step 1 create adjacency node
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<>());

		int m = flights.length;

		for (int i = 0; i < m; i++) {
			adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
		}

		// Step2: create queue of type {stop, node, cost}
		Queue<Tupple> q = new LinkedList<>();
		q.add(new Tupple(0, src, 0));

		// Step3: Create distance array
		int[] distance = new int[n];
		Arrays.fill(distance, (int) 1e9);
		distance[src] = 0;

		// iterate over queue
		while (!q.isEmpty()) {
			Tupple itr = q.poll();
			int stops = itr.stop;
			int node = itr.node;
			int cost = itr.cost;

			// if we reach more than stops then no need of execution
			if (stops > k)
				continue;

			// iterate over adj node
			for (Pair iter : adj.get(node)) {
				int adjNode = iter.first;
				int edW = iter.second;
				if (cost + edW < distance[adjNode] && stops <= k) {
					distance[adjNode] = cost + edW;

					// put it in the queue
					q.add(new Tupple(stops + 1, adjNode, cost + edW));
				}
			}
		}

		if (distance[dst] == 1e9)
			return -1;

		return distance[dst];
	}

	class Pair {
		int first;
		int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	class Tupple {
		int stop;
		int node;
		int cost;

		public Tupple(int stop, int node, int cost) {
			this.stop = stop;
			this.node = node;
			this.cost = cost;
		}
	}
}
