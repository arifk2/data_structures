package com.rf.khan.api.iq.string;

import java.util.HashMap;
import java.util.Map;

public class ContainDuplicateIILC219 {

	/**
	 * This is driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 0, 1, 1 };
		int k = 1;
		ContainDuplicateIILC219 c = new ContainDuplicateIILC219();
		System.out.println(c.containsNearbyDuplicateBF(nums, k));
		System.out.println(c.containsNearbyDuplicate(nums, k));
	}

	/**
	 * This method is created to get the near by duplicate in the given range
	 * 
	 * @param nums holds the information of the array
	 * @param k    holds the information of the k-range
	 * @return true/false
	 */
	public boolean containsNearbyDuplicateBF(int[] nums, int k) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j] && j - i <= k) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * This is optimized code using hashmap
	 * 
	 * @param nums holds the information of the nums array
	 * @param k
	 * @return
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int element = nums[i];
			// verify that the previous index is lies in the range or not
			if (map.containsKey(element) && Math.abs(map.get(element) - i) <= k) {
				return true;
			}
			map.put(element, i);
		}
		return false;
	}
}
