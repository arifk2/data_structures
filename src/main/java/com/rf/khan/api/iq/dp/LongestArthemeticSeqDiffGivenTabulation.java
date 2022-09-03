package com.rf.khan.api.iq.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Arthemetic sequence with given difference
 * 
 * @author mkhan339
 *
 */
public class LongestArthemeticSeqDiffGivenTabulation {

	/**
	 * Dp + hashing pattern
	 * 
	 * @param arr
	 * @param difference
	 * @return
	 */
	public int longestSubsequence(int[] arr, int difference) {
		HashMap<Integer, Integer> dp = new HashMap<>();

		int ans = 0;

		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i] - difference;
			int tempAns = 0;

			// check in map
			if (dp.containsKey(temp))
				tempAns = dp.get(temp);

			dp.put(arr[i], 1 + tempAns);

		}

		// get the max from the hashMap value
		for (Map.Entry<Integer, Integer> mt : dp.entrySet()) {
			ans = Math.max(ans, mt.getValue());
		}

		return ans;
	}

	/**
	 * Driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 2, -6, -3, -6, 2, 0 };
		int diff = -2;

		LongestArthemeticSeqDiffGivenTabulation l = new LongestArthemeticSeqDiffGivenTabulation();
		System.out.println(l.longestSubsequence(arr, diff));

	}
}
