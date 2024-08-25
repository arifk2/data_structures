package com.rf.khan.api.iq.graph.striver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G39MinMultiplicationToReachEnd {
	public static void main(String[] args) {
		int arr[] = { 2, 5, 7 };
		int start = 3, end = 30;
		G39MinMultiplicationToReachEnd g = new G39MinMultiplicationToReachEnd();
		System.out.println(g.minimumMultiplications(arr, start, end));

		System.out.println(g.minimumMultiplications(new int[] { 9, 12, 18, 19 }, 4, 55));

	}

	int minimumMultiplications(int[] arr, int start, int end) {
		// Create a queue for storing the numbers as a result of multiplication
		// of the numbers in the array and the start number.
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(start, 0));

		// Create a distance array to store the no. of multiplications to reach
		// a particular number from the start number.
		int[] dist = new int[100000];
		Arrays.fill(dist, (int) 1e9);
		dist[start] = 0;
		int mod = 100000;
		int n = arr.length;
		// O(100000 * N)

		// Multiply the start no. with each of numbers in the arr
		// until we get the end no.
		while (!q.isEmpty()) {
			int node = q.peek().first;
			int steps = q.peek().second;
			q.remove();

			for (int i = 0; i < n; i++) {
				int num = (arr[i] * node) % mod;

				// If the no. of multiplications are less than before
				// in order to reach a number, we update the dist array.
				if (steps + 1 < dist[num]) {
					dist[num] = steps + 1;

					// Whenever we reach the end number
					// return the calculated steps
					if (num == end)
						return steps + 1;
					q.add(new Pair(num, steps + 1));
				}
			}
		}
		// If the end no. is unattainable.
		return -1;
	}

	class Pair {
		int first;
		int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

	}
}
