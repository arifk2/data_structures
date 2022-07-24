package com.rf.khan.api.iq.array;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 7, 3, 2, 11, 2, 1 };
		int target = 13;

		// brute force

		/*
		 * for (int i = 0; i < nums.length - 1; i++) { for (int j = i + 1; j <
		 * nums.length; j++) {
		 * 
		 * if (nums[i] + nums[j] == target) {
		 * 
		 * System.out.println(i + ", " + j); } } }
		 */

		HashMap<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int requiredSum = target - nums[i];
			if (indexMap.containsKey(requiredSum)) {
				System.out.println(indexMap.get(requiredSum) + " " + i);
			}

			indexMap.put(nums[i], i);
		}

	}
}
