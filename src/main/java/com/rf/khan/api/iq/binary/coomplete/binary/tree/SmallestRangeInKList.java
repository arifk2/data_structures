package com.rf.khan.api.iq.binary.coomplete.binary.tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class NodeN {
	int data;
	int row;
	int column;

	public NodeN(int data, int row, int column) {
		this.data = data;
		this.row = row;
		this.column = column;
	}

	@Override
	public String toString() {
		return "NodeN [data=" + data + ", row=" + row + ", column=" + column + "]";
	}

}

public class SmallestRangeInKList {

	static int[] findSmallestRange(int[][] KSortedArray, int n, int k) {
		int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
		PriorityQueue<NodeN> minHeap = new PriorityQueue<>(new Comparator<NodeN>() {

			@Override
			public int compare(NodeN o1, NodeN o2) {
				return o1.data - o2.data;
			}
		});

		// Step1: insert the first element of the each list and tracking the max and
		// min;
		for (int i = 0; i < k; i++) {
			int element = KSortedArray[i][0];
			mini = Math.min(mini, element);
			maxi = Math.max(maxi, element);
			minHeap.add(new NodeN(element, i, 0));
		}

		// Step2: get the start and end range
		int start = mini, end = maxi;

		// Step3: first element in the heap is min, so
		while (!minHeap.isEmpty()) {
			NodeN temp = minHeap.peek();
			minHeap.poll();
			mini = temp.data;

			if (maxi - mini < end - start) {
				start = mini;
				end = maxi;
			}

			// next element exits
			if (temp.column + 1 < n) {
				maxi = Math.max(maxi, KSortedArray[temp.row][temp.column + 1]);
				minHeap.add(new NodeN(KSortedArray[temp.row][temp.column + 1], temp.row, temp.column + 1));
			} else {
				// next element does not exit
				break;
			}
		}
		return new int[] { start, end };
	}

	public static void main(String[] args) {
		int n = 5, k = 3;
		int kSortedArray[][] = { { 1, 3, 5, 7, 9 }, { 0, 2, 4, 6, 8 }, { 2, 3, 5, 7, 11 } };
		System.out.println(Arrays.toString(findSmallestRange(kSortedArray, n, k)));

		int kSortedArray1[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int n1 = 4, k1 = 3;
		System.out.println(Arrays.toString(findSmallestRange(kSortedArray1, n1, k1)));
	}
}
