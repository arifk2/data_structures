package com.rf.khan.api.iq.lc;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {

		TwoSum out = new TwoSum();

		int[] a = { 2, 7, 11, 15 };
		int target = 18;

		int[] result = out.twoSum(a, target);

		for (int each : result) {
			System.out.println(each);
		}
	}

	private int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int requiredSum = target - nums[i];
			if (indexMap.containsKey(requiredSum)) {
				return new int[] { indexMap.get(requiredSum), i };
			} else {
				indexMap.put(nums[i], i);
			}
		}
		return null;
	}
}
