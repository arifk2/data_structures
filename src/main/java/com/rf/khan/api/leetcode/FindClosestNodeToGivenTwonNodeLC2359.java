package com.rf.khan.api.leetcode;

import java.util.Arrays;

public class FindClosestNodeToGivenTwonNodeLC2359 {

	public static void main(String[] args) {
		int[] edges = { 2, 2, 3, -1 };
		int node1 = 0, node2 = 1;

		FindClosestNodeToGivenTwonNodeLC2359 close = new FindClosestNodeToGivenTwonNodeLC2359();
		System.out.println(close.closestMeetingNode(edges, node1, node2));
	}

	public int closestMeetingNode(int[] edges, int node1, int node2) {
		int n = edges.length;

		// Step 1: create distance array and initialize with -1
		int[] dist1 = new int[n];
		Arrays.fill(dist1, -1);

		int[] dist2 = new int[n];
		Arrays.fill(dist2, -1);

		// Step2: made 0 to the given nodes
		dist1[node1] = 0;
		dist2[node2] = 0;

		int dist = 0;
		int i = node1;

		// Step3: dfs
		while (true) {
			dist1[i] = dist++;
			i = edges[i];
			if (i == -1 || dist1[i] != -1) {
				break;
			}
		}

		dist = 0;
		i = node2;
		while (true) {
			dist2[i] = dist++;
			i = edges[i];
			if (i == -1 || dist2[i] != -1) {
				break;
			}
		}
		int ans = -1;
		int mini = Integer.MAX_VALUE;

		// Step 4: get the answer
		for (i = 0; i < n; i++) {
			if (dist1[i] == -1 || dist2[i] == -1)
				continue;

			if (mini > Math.max(dist1[i], dist2[i])) {
				mini = Math.max(dist1[i], dist2[i]);
				ans = i;
			}
		}
		return ans;
	}
}
