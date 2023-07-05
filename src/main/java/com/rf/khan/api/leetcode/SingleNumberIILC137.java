package com.rf.khan.api.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberIILC137 {
	public static void main(String[] args) {
		int[] nums = { 2, 2, 3, 2 };
		int[] nums1 = { 0, 1, 0, 1, 0, 1, 99 };
		SingleNumberIILC137 s = new SingleNumberIILC137();
		System.out.println(s.singleNumber(nums));
		System.out.println(s.singleNumber(nums1));
	}

	public int singleNumber(int[] nums) {
		Map<Integer, Integer> mapCount = new HashMap<>();

		for (int i : nums)
			mapCount.put(i, mapCount.getOrDefault(i, 0) + 1);

		for (Map.Entry<Integer, Integer> entrySet : mapCount.entrySet()) {
			if (entrySet.getValue() == 1)
				return entrySet.getKey();
		}
		return -1;
	}
}
