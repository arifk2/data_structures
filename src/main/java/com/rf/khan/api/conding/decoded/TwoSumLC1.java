package com.rf.khan.api.conding.decoded;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumLC1 {

	public static void main(String[] args) {
		TwoSumLC1 t = new TwoSumLC1();
		int[] res = t.twoSum(new int[] { 2, 7, 11, 15 }, 9);

		Arrays.stream(res).forEach(System.out::print);
		System.out.println();
		Arrays.stream(t.twoSum(new int[] { 2, 7, 11, 15 }, 9)).forEach(System.out::print);
	}

	public int[] twoSum(int[] nums, int target) {
		int[] arr = new int[2];

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					arr[0] = i;
					arr[1] = j;
				}
			}
		}
		return arr;
	}

	public int[] twoSumUsingHashMap(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int requiredSum = target - nums[i];
			if (map.containsKey(requiredSum)) {
				return new int[] { map.get(requiredSum), i };
			}
			map.put(nums[i], i);
		}

		return null;
	}
}
