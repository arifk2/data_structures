package com.rf.khan.api.coding.decoded;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleKLC974 {

	public static void main(String[] args) {
		SubarraySumsDivisibleKLC974 s = new SubarraySumsDivisibleKLC974();
		System.out.println(s.subarraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 }, 5));
		System.out.println(s.subarraysDivByK(new int[] { -1, 2, 9 }, 2));
	}

	public int subarraysDivByK(int[] nums, int k) {
		// <Reminder, Count>
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		// base case
		map.put(0, 1);
		int count = 0;
		int prefixSum = 0;

		for (int num : nums) {
			// update prefix sum
			prefixSum += num;

			// get remainder
			int remainder = prefixSum % k;
			if (remainder < 0) {
				remainder = remainder + k;
			}

			if (map.containsKey(remainder)) {
				int remCount = map.get(remainder);
				count += remCount;
				map.put(remainder, remCount + 1);
			} else {
				map.put(remainder, 1);
			}
		}
		return count;
	}
}
