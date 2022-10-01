package com.rf.khan.api.iq.array;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * @author mkhan339
 *
 */
public class MaximumSubarrayKadaneArray {

	/**
	 * TC O(n3)
	 * 
	 * This method is created to get the max sub-array
	 * 
	 * @param nums holds the information of the given array
	 * @return result
	 */
	public int maxSubArrayBFO3(int[] nums) {
		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += nums[k];
				}
				ans = Math.max(ans, sum);
			}
		}
		return ans;
	}

	/**
	 * TC O(n2)
	 * 
	 * @param nums
	 * @return
	 */

	public int maxSubArrayBFO2(int[] nums) {

		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				ans = Math.max(ans, sum);
			}
		}
		return ans;
	}

	/**
	 * Solving using Kadane's Algorithm
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		int maxi = nums[0];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			maxi = Math.max(maxi, sum);

			if (sum < 0)
				sum = 0;
		}

		return maxi;
	}

	/**
	 * This is driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		MaximumSubarrayKadaneArray m = new MaximumSubarrayKadaneArray();
		System.out.println(m.maxSubArray(nums));
	}

}
