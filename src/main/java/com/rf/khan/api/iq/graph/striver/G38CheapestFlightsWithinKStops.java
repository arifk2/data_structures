package com.rf.khan.api.iq.graph.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
 */
public class G38CheapestFlightsWithinKStops {

	public static void main(String[] args) {
		int n = 4;
		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
		int src = 0, dst = 3, k = 1;

		G38CheapestFlightsWithinKStops flight = new G38CheapestFlightsWithinKStops();
		System.out.println(flight.findCheapestPrice(n, flights, src, dst, k));
		System.out.println(
				flight.findCheapestPrice(3, new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } }, 0, 2, 1));
	}

	/**
	 * This method is created to find the cheapest price
	 * 
	 * @param n       number of node
	 * @param flights given as the flight node with the price
	 * @param src     source
	 * @param dst     destination
	 * @param k       stops
	 * @return
	 */
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

		// Step 1: create adjency node
		ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		int m = flights.length;
		for (int i = 0; i < m; i++) {
			adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
		}

		// Step 2: create queue of type {stops, node, cost}
		Queue<Tupple> q = new LinkedList<>();
		q.add(new Tupple(0, src, 0));

		// Step3: create distance array
		int[] distance = new int[n];
		Arrays.fill(distance, (int) (1e9));
		distance[src] = 0;

		while (!q.isEmpty()) {
			Tupple it = q.poll();
			int stops = it.first;
			int node = it.second;
			int cost = it.third;

			// if stops get more then skip others.
			if (stops > k)
				continue;

			for (Pair iter : adj.get(node)) {
				int adjNode = iter.first;
				int edW = iter.second;

				if (cost + edW < distance[adjNode] && stops <= k) {
					distance[adjNode] = cost + edW;
					q.add(new Tupple(stops + 1, adjNode, cost + edW));
				}
			}
		}

		// Step last: conclude
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
		int first;
		int second;
		int third;

		public Tupple(int first, int second, int third) {
			this.first = first;
			this.second = second;
			this.third = third;
		}
	}
}
