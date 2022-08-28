package com.rf.khan.api.gg.array;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://www.geeksforgeeks.org/k-maximum-sum-combinations-two-arrays/
 * 
 * @author mkhan339
 *
 */
public class KMaxCombinationsBruteForce {

	/**
	 * Brute Force approach
	 * 
	 * @param arrayA
	 * @param arrayB
	 * @param n
	 * @param K
	 */
	static void KMaxCombinations(int arrayA[], int arrayB[], int n, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		// put all combination sum into maxHeap
		for (int i = 0; i < n; i++) {
			for (int j = 0; i < n; i++) {
				maxHeap.add(arrayA[i] + arrayB[j]);
			}
		}

		// pop you will get the max sum utp k
		int count = k;
		while (count > 0) {
			System.out.println(maxHeap.peek());
			maxHeap.poll();
			count = count - 1;
		}

	}

	/**
	 * This is a driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int arrayA[] = { 4, 2, 5, 1 };
		int arrayB[] = { 8, 0, 5, 3 };
		int n = arrayA.length;
		int K = 3;

		// Function Call
		KMaxCombinations(arrayA, arrayB, n, K);
	}
}
