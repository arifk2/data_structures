package com.rf.khan.api.coding.decoded;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class LongestSubsequenceWithLimitedSumLC2389 {
	public static void main(String[] args) {
		int[] nums = { 4, 5, 2, 1 }, queries = { 3, 10, 21 };
		LongestSubsequenceWithLimitedSumLC2389 l = new LongestSubsequenceWithLimitedSumLC2389();

		int[] ans = l.answerQueries(nums, queries);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	public int[] answerQueries(int[] nums, int[] queries) {
		// Step1 : sort
		Arrays.sort(nums);

		// Step2 : build prefix sum array
		int[] prefixSum = new int[nums.length];
		prefixSum[0] = nums[0];

		// Step3: build prefix sum Map
		TreeMap<Integer, Integer> map = new TreeMap<>(); // prefixSum, index
		map.put(prefixSum[0], 0);
		for (int i = 1; i < nums.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i];
			map.put(prefixSum[i], i);
		}

		// Step4: build answer
		int[] ans = new int[queries.length];
		int i = 0;
		for (int query : queries) {
			Map.Entry<Integer, Integer> entry = map.floorEntry(query);
			if (entry != null) {
				ans[i] = entry.getValue() + 1;
			}
			i++;
		}
		return ans;
	}
}
