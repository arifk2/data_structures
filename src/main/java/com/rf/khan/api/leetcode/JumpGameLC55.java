package com.rf.khan.api.leetcode;

public class JumpGameLC55 {
	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		JumpGameLC55 j = new JumpGameLC55();
		System.out.println(j.canJump(nums));
	}

	/**
	 * Approach: Keep track of the steps that can move on each index by adding index
	 * and current index value.
	 * 
	 * If steps reach to last index, it mean that reached, in this case return true
	 * 
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return true;

		int steps = 0;
		for (int index = 0; index < n - 1 && steps >= index; index++) {
			steps = Math.max(steps, index + nums[index]);

			if (steps >= n - 1)
				return true;
		}

		return false;
	}
}
