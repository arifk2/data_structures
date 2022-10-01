package com.rf.khan.api.iq.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.util.Arrays;

/**
 * https://leetcode.com/problems/find-all-good-indices/
 * 
 * 
 * We call an index i in the range k <= i < n - k good if the following
 * conditions are satisfied:
 * 
 * The k elements that are just before the index i are in non-increasing order.
 * 
 * The k elements that are just after the index i are in non-decreasing order.
 * 
 * @author mkhan339
 *
 */
public class FindAllGoodIndices2420 {
	public List<Integer> goodIndices(int[] nums, int k) {

		int n = nums.length;

		// descending
		int[] nonIncreasingCount = new int[n];
		Arrays.fill(nonIncreasingCount, 1);

		// pre-computing the non- increasing count
		for (int i = 1; i < n; i++) {
			if (nums[i - 1] >= nums[i]) {
				nonIncreasingCount[i] = 1 + nonIncreasingCount[i - 1];
			}
		}

		// ascending
		int[] nonDecreasingCount = new int[n];
		Arrays.fill(nonDecreasingCount, 1);

		// pre-computing the non - decreasing count
		for (int i = n - 2; i >= 0; i--) {
			if (nums[i + 1] >= nums[i]) {
				nonDecreasingCount[i] = 1 + nonDecreasingCount[i + 1];
			}
		}

		List<Integer> goodIndices = new ArrayList<>();
		// find good indices k <= i < n - k
		for (int i = k; i < n - k; i++) {
			if (nonIncreasingCount[i - 1] >= k && nonDecreasingCount[i + 1] >= k)
				goodIndices.add(i);
		}

		return goodIndices;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 2, 1, 1, 1, 3, 4, 1 };
		int k = 2;
		FindAllGoodIndices2420 f = new FindAllGoodIndices2420();
		System.out.println(f.goodIndices(nums, k));
	}
}
