package com.rf.khan.api.iq.string;

import java.util.TreeSet;

public class ContainDuplicateIIILC220 {

	public static void main(String[] args) {
		ContainDuplicateIIILC220 c = new ContainDuplicateIIILC220();
		int[] nums = { 1, 2, 3, 1 };
		int indexDiff = 3;
		int valueDiff = 0;

		System.out.println(c.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
		System.out.println(c.containsNearbyAlmostDuplicate(new int[] { 1, 2, 2, 3, 4, 5 }, 3, 0));
		System.out.println(c.containsNearbyAlmostDuplicateO(new int[] { 1, 2, 2, 3, 4, 5 }, 3, 0));
		System.out.println(c.containsNearbyAlmostDuplicateOptimized(new int[] { 1, 2, 2, 3, 4, 5 }, 3, 0));
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
		int n = nums.length;

		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (Math.abs(nums[i] - nums[j]) <= valueDiff && j - i <= indexDiff) {
					return true;
				}

		return false;
	}

	public boolean containsNearbyAlmostDuplicateO(int[] nums, int indexDiff, int valueDiff) {
		int n = nums.length;

		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= i + indexDiff; j++)
				if (j < n && Math.abs(nums[i] - nums[j]) <= valueDiff && j - i <= indexDiff) {
					return true;
				}

		return false;
	}

	/**
	 * This method is created using treeset data structure because of the ceiling
	 * and floor method.
	 * 
	 * @param nums      hold he information of the array
	 * @param indexDiff holds the information of the index difference
	 * @param valueDiff holds the information of he value difference
	 * @return true/false
	 */
	public boolean containsNearbyAlmostDuplicateOptimized(int[] nums, int indexDiff, int valueDiff) {
		TreeSet<Integer> set = new TreeSet<>();

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];

			Integer floor = set.floor(num);
			Integer ceil = set.ceiling(num);

			if (floor != null && Math.abs(floor - num) <= valueDiff) {
				return true;
			}

			if (ceil != null && Math.abs(ceil - num) <= valueDiff) {
				return true;
			}
			set.add(num);

			if (set.size() > indexDiff) {
				set.remove(nums[i - indexDiff]);
			}

		}
		return false;
	}
}
