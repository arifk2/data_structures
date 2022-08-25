package com.rf.khan.api.gg.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Find median in stream
 * 
 * @author mkhan339
 *
 */
public class FindMedian {

	private static double solveToGetMedian(int element, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap,
			double median) {
		switch ((int) Math.signum(maxHeap.size() - minHeap.size())) {
		case 0:
			if (element > median) {
				minHeap.add(element);
				median = (double) minHeap.peek();
			} else {
				maxHeap.add(element);
				median = (double) maxHeap.peek();
			}
			break;
		case 1:
			if (element > median) {
				minHeap.add(element);
				median = (double) (maxHeap.peek() + minHeap.peek()) / 2;
			} else {
				minHeap.add(maxHeap.peek());
				maxHeap.poll();
				maxHeap.add(element);
				median = (double) (maxHeap.peek() + minHeap.peek()) / 2;
			}
			break;
		case -1:
			if (element > median) {
				maxHeap.add(minHeap.peek());
				minHeap.poll();
				minHeap.add(element);
				median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
			} else {
				maxHeap.add(element);
				median = (double) (maxHeap.peek() + minHeap.peek()) / 2;
			}
		}
		return median;

	}

	public static ArrayList<Double> findMedian(int[] arr, int n) {
		ArrayList<Double> answer = new ArrayList<>();
		// for max values;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		// for min values
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		double median = 0;

		// check for all the input element
		for (int i = 0; i < n; i++) {
			median = solveToGetMedian(arr[i], maxHeap, minHeap, median);
			// add median to answer
			answer.add(median);
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 15, 10, 20, 3 };
		int n = 5;
		System.out.println(findMedian(arr, n));
	}

}
