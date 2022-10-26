package com.rf.khan.api.iq.string;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySumLC523 {

	public static void main(String[] args) {
		int[] nums = { 23, 2, 6, 4, 7 };
		int k = 6;

		ContinuousSubarraySumLC523 c = new ContinuousSubarraySumLC523();
		System.out.println(c.checkSubarraySum(nums, k));
	}

	public boolean checkSubarraySum(int[] nums, int k) {

		for (int i = 0; i < nums.length; i++) {
			int current = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				current += nums[j];
				if (current % k == 0)
					return true;
			}
		}
		return false;
	}

	public boolean checkSubarraySumOp(int[] nums, int k) {

		Map<Integer, Integer> sumIndex = new HashMap<>();

		// if k is zero then, we need to have two seros in the array to make this
		// condition true else false
		if (k == 0) {
			boolean zeroes = false;
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] == 0 && nums[i - 1] == 0) {
					zeroes = true;
				}
			}
			return zeroes;
		}

		sumIndex.put(0, -1);
		int prefixSum = 0;
		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			if (sumIndex.containsKey(prefixSum % k)) {
				if (i - sumIndex.get(prefixSum % k) > 1) {
					return true;
				}
			}
			sumIndex.put(prefixSum % k, i);
		}
		return false;
	}

}
