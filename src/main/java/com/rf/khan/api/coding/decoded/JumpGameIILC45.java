package com.rf.khan.api.coding.decoded;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIILC45 {

	public static void main(String[] args) {
		JumpGameIILC45 jum = new JumpGameIILC45();
		System.out.println(jum.jump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(jum.jump(new int[] { 2, 2, 1, 1, 4 }));
		System.out.println(jum.jumGreedy(new int[] { 2, 2, 1, 1, 4 }));
	}

	// TLE
	public int jump(int[] nums) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[nums.length];
		int level = 0;

		// start index
		q.add(0);

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int currIndex = q.poll();

				if (visited[currIndex]) {
					continue;
				}
				if (currIndex == nums.length - 1) {
					return level;
				}
				int maxIndex = Math.min(currIndex + nums[currIndex], nums.length - 1);

				while (maxIndex > currIndex) {
					if (visited[maxIndex] == false) {
						q.add(maxIndex);
					}
					maxIndex--;
				}
				visited[currIndex] = true;
			}
			level++;
		}
		return level;
	}

	// 2, 2, 1, 1, 4
	public int jumGreedy(int[] nums) {
		// The starting range of the first jump is [0, 0]
		int answer = 0, n = nums.length;
		int curEnd = 0, curFar = 0;

		for (int i = 0; i < n - 1; ++i) {
			// Update the farthest reachable index of this jump.
			curFar = Math.max(curFar, i + nums[i]);

			// If we finish the starting range of this jump,
			// Move on to the starting range of the next jump.
			if (i == curEnd) {
				answer++;
				curEnd = curFar;
			}
		}

		return answer;
	}
}
