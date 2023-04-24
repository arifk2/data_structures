package com.rf.khan.api.leetcode;

import java.util.PriorityQueue;

public class LastStoneWeightLC1046 {
	public static void main(String[] args) {
		LastStoneWeightLC1046 l = new LastStoneWeightLC1046();
		System.out.println(l.lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
	}

	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);

		for (int stone : stones)
			maxHeap.add(stone);

		while (maxHeap.size() > 1) {
			int top1 = maxHeap.poll();
			int top2 = maxHeap.poll();

			int diff = Math.abs(top1 - top2);

			if (diff != 0)
				maxHeap.add(diff);
		}

		if (!maxHeap.isEmpty()) {
			return maxHeap.peek();
		} else {
			return 0;
		}
	}
}
