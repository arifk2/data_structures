package com.rf.khan.api.leetcode;

public class MaximumNumberAchievableTransferRequestsLC1601 {
	public static void main(String[] args) {
		int n = 5;
		int[][] requests = { { 0, 1 }, { 1, 0 }, { 0, 1 }, { 1, 2 }, { 2, 0 }, { 3, 4 } };
		MaximumNumberAchievableTransferRequestsLC1601 max = new MaximumNumberAchievableTransferRequestsLC1601();
		System.out.println(max.maximumRequests(n, requests));
	}

	int answer = 0;

	public int maximumRequests(int n, int[][] requests) {
		int[] indegree = new int[n];

		maxRequest(requests, indegree, n, 0, 0);
		return answer;
	}

	private void maxRequest(int[][] requests, int[] indegree, int n, int index, int count) {
		// base case
		if (index == requests.length) {
			for (int i = 0; i < n; i++) {
				if (indegree[i] != 0) {
					return;
				}
			}
			answer = Math.max(answer, count);
			return;
		}

		indegree[requests[index][0]]--;
		indegree[requests[index][1]]++;

		maxRequest(requests, indegree, n, index + 1, count + 1);

		// backtracking
		indegree[requests[index][0]]++;
		indegree[requests[index][1]]--;

		maxRequest(requests, indegree, n, index + 1, count);

	}
}
