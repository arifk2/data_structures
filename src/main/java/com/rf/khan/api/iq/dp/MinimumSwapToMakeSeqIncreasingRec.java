package com.rf.khan.api.iq.dp;

/**
 * Minimum Swap counts to make the sequences increasing
 * 
 * * Step 1: Insert -1 at the beginning of both the array
 * 
 * * Step2: make recursive call of the swap(check the previous element in the
 * array is less than current then no swap) or not swap
 * 
 * @author mkhan339
 *
 */
public class MinimumSwapToMakeSeqIncreasingRec {

	/**
	 * Solving using recursion
	 * 
	 * @param nums1 holds the information of array1
	 * @param nums2 holds the information of array2
	 * @return minimum swap count
	 */
	public int minSwap(int[] nums1, int[] nums2) {
		boolean swapped = false;

		// Step 1: insert -1 at the first index of each array
		int[] newNum1 = new int[nums1.length + 1];
		int[] newNum2 = new int[nums2.length + 1];

		newNum1[0] = -1;
		newNum2[0] = -1;

		System.arraycopy(nums1, 0, newNum1, 1, nums1.length);
		System.arraycopy(nums2, 0, newNum2, 1, nums2.length);

		return solveUsingRecursion(newNum1, newNum2, 1, swapped);
	}

	/**
	 * Solving using recursion
	 * 
	 * @param nums1   holds the information of array1
	 * @param nums2   holds the information of array2
	 * @param index   current index
	 * @param swapped is previous index element swapped
	 * @return
	 */
	private int solveUsingRecursion(int[] nums1, int[] nums2, int index, boolean swapped) {

		// base case
		if (index == nums1.length)
			return 0;

		int ans = Integer.MAX_VALUE;

		int prev1 = nums1[index - 1];
		int prev2 = nums2[index - 1];

		// catch -> if swapped is true then swap prev1 and prev2
		if (swapped) {
			int temp = prev1;
			prev1 = prev2;
			prev2 = temp;
		}

		// no swap
		if (nums1[index] > prev1 && nums2[index] > prev2)
			ans = solveUsingRecursion(nums1, nums2, index + 1, false);

		// swap
		if (nums1[index] > prev2 && nums2[index] > prev1)
			ans = Math.min(ans, 1 + solveUsingRecursion(nums1, nums2, index + 1, true));

		return ans;
	}

	/**
	 * This is driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 5, 4 }, nums2 = { 1, 2, 3, 7 };

		MinimumSwapToMakeSeqIncreasingRec min = new MinimumSwapToMakeSeqIncreasingRec();
		System.out.println(min.minSwap(nums1, nums2));
	}
}
