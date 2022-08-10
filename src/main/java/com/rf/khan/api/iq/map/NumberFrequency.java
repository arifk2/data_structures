package com.rf.khan.api.iq.map;

import java.util.HashMap;
import java.util.Map;

public class NumberFrequency {

	/**
	 * driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 3, 1, 3, 4 };
		int n = 5;
		System.out.println(findFrequency(arr, n));
	}

	/**
	 * This method is created to find the frequency of the maximum, if two element
	 * contains the same frequency return the first element
	 * 
	 * @param arr holds the information of the array
	 * @param n   holds the size of the array
	 * @return max frequency number
	 */
	private static int findFrequency(int[] arr, int n) {
		Map<Integer, Integer> count = new HashMap<>();

		int maxFreq = 0;
		int maxAns = 0;

		for (int i : arr) {
			count.put(i, count.getOrDefault(i, 0) + 1);
			maxFreq = Math.max(maxFreq, count.get(i));
		}

		for (int i = 0; i < n; i++) {
			if (count.containsKey(arr[i]) && maxFreq == count.get(arr[i])) {
				maxAns = arr[i];
				break;
			}
		}
		return maxAns;
	}
}
