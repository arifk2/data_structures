package com.rf.khan.api.coding.decoded;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.bouncycastle.util.Arrays;

public class CheapestFlightsWithinKStopsLC787 {
	public static void main(String[] args) {
		CheapestFlightsWithinKStopsLC787 cheap = new CheapestFlightsWithinKStopsLC787();
		int[][] flights = new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
		int n = 4, src = 0, dst = 3, k = 1;
		System.out.println(cheap.findCheapestPrice(n, flights, src, dst, k));
		System.out.println(
				cheap.findCheapestPrice(3, new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } }, 0, 2, 1));

		System.out.println(cheap.findCheapestPrice(18, new int[][] { { 16, 1, 81 }, { 15, 13, 47 }, { 1, 0, 24 },
				{ 5, 10, 21 }, { 7, 1, 72 }, { 0, 4, 88 }, { 16, 4, 39 }, { 9, 3, 25 }, { 10, 11, 28 }, { 13, 8, 93 },
				{ 10, 3, 62 }, { 14, 0, 38 }, { 3, 10, 58 }, { 3, 12, 46 }, { 3, 8, 2 }, { 10, 16, 27 }, { 6, 9, 90 },
				{ 14, 8, 6 }, { 0, 13, 31 }, { 6, 4, 65 }, { 14, 17, 29 }, { 13, 17, 64 }, { 12, 5, 26 }, { 12, 1, 9 },
				{ 12, 15, 79 }, { 16, 11, 79 }, { 16, 15, 17 }, { 4, 0, 21 }, { 15, 10, 75 }, { 3, 17, 23 },
				{ 8, 5, 55 }, { 9, 4, 19 }, { 0, 10, 83 }, { 3, 7, 17 }, { 0, 12, 31 }, { 11, 5, 34 }, { 17, 14, 98 },
				{ 11, 14, 85 }, { 16, 7, 48 }, { 12, 6, 86 }, { 5, 17, 72 }, { 4, 12, 5 }, { 12, 10, 23 }, { 3, 2, 31 },
				{ 12, 7, 5 }, { 6, 13, 30 }, { 6, 7, 88 }, { 2, 17, 88 }, { 6, 8, 98 }, { 0, 7, 69 }, { 10, 15, 13 },
				{ 16, 14, 24 }, { 1, 17, 24 }, { 13, 9, 82 }, { 13, 6, 67 }, { 15, 11, 72 }, { 12, 0, 83 },
				{ 1, 4, 37 }, { 12, 9, 36 }, { 9, 17, 81 }, { 9, 15, 62 }, { 8, 15, 71 }, { 10, 12, 25 }, { 7, 6, 23 },
				{ 16, 5, 76 }, { 7, 17, 4 }, { 3, 11, 82 }, { 2, 11, 71 }, { 8, 4, 11 }, { 14, 10, 51 }, { 8, 10, 51 },
				{ 4, 1, 57 }, { 6, 16, 68 }, { 3, 9, 100 }, { 1, 14, 26 }, { 10, 7, 14 }, { 8, 17, 24 }, { 1, 11, 10 },
				{ 2, 9, 85 }, { 9, 6, 49 }, { 11, 4, 95 } }, 7, 2, 6));
	}

	private class Pair {
		int first;
		int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	private class Tuple {
		int stops;
		Pair nodeCost;

		public Tuple(int stops, Pair nodeCost) {
			this.stops = stops;
			this.nodeCost = nodeCost;
		}
	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

		// Step 1: prepare a adjacency list
		ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		int m = flights.length;
		for (int i = 0; i < m; i++) {
			adjList.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
		}
		// Step 2: create q data structure to track of the stop with reference of node
		// and distance.
		Queue<Tuple> q = new LinkedList<>();
		// stops, source, price
		q.add(new Tuple(0, new Pair(src, 0)));

		int[] distance = new int[n];
		Arrays.fill(distance, (int) 1e9);
		distance[src] = 0;

		// Step 3:
		while (!q.isEmpty()) {
			Tuple t = q.poll();
			int stops = t.stops;
			int node = t.nodeCost.first;
			int cost = t.nodeCost.second;

			if (stops > k)
				continue;

			for (Pair it : adjList.get(node)) {
				int adjNode = it.first;
				int edW = it.second;

				if (cost + edW < distance[adjNode] && stops <= k) {
					distance[adjNode] = cost + edW;
					q.add(new Tuple(stops + 1, new Pair(adjNode, cost + edW)));
				}
			}
		}

		if (distance[dst] == (int) 1e9) {
			return -1;
		}
		return distance[dst];
	}
}
