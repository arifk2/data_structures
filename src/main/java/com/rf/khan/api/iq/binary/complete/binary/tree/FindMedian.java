package com.rf.khan.api.iq.binary.complete.binary.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedian {
	/**
	 * This method is to get the median
	 * 
	 * @param element
	 * @param maxHeap
	 * @param minHeap
	 * @param median
	 * @return
	 */
	static int getMedian(int element, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int median) {

		switch ((int) Math.signum(maxHeap.size() - minHeap.size())) {
		case 0:
			if (element > median) {
				minHeap.add(element);
				median = minHeap.peek();
			} else {
				maxHeap.add(element);
				median = maxHeap.peek();
			}
			break;
		case 1:
			if (element > median) {
				minHeap.add(element);
				median = (minHeap.peek() + maxHeap.peek()) / 2;
			} else {
				minHeap.add(maxHeap.peek());
				maxHeap.poll();
				maxHeap.add(element);
				median = (minHeap.peek() + maxHeap.peek()) / 2;
			}
			break;
		case -1:
			if (element > median) {
				maxHeap.add(minHeap.peek());
				minHeap.poll();
				minHeap.add(element);
				median = (minHeap.peek() + maxHeap.peek()) / 2;
			} else {
				maxHeap.add(element);
				median = (minHeap.peek() + maxHeap.peek()) / 2;
			}
			break;
		}
		return median;
	}

	public static int[] findMedian(int[] arr, int n) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		// for max values
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		// for min values
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		int median = 0;

		for (int i = 0; i < n; i++) {
			median = getMedian(arr[i], maxHeap, minHeap, median);
			ans.add(median);
		}
		System.out.println("-> " + ans);
		int[] intAns = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			intAns[i] = ans.get(i);
		}
		return intAns;
	}

	public static void main(String[] args) {
		int[] arr = {5, 15, 10, 20, 3};
		int n = 5;
		System.out.println(Arrays.toString(findMedian(arr, n)));
	}
}
