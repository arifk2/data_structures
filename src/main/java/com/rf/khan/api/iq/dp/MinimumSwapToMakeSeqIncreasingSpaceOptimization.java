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
public class MinimumSwapToMakeSeqIncreasingSpaceOptimization {

	/**
	 * Solving using recursion
	 * 
	 * @param nums1 holds the information of array1
	 * @param nums2 holds the information of array2
	 * @return minimum swap count
	 */
	public int minSwap(int[] nums1, int[] nums2) {

		// Step 1: insert -1 at the first index of each array
		int[] newNum1 = new int[nums1.length + 1];
		int[] newNum2 = new int[nums2.length + 1];

		newNum1[0] = -1;
		newNum2[0] = -1;

		System.arraycopy(nums1, 0, newNum1, 1, nums1.length);
		System.arraycopy(nums2, 0, newNum2, 1, nums2.length);

		return solveUsingSpaceOptimization(newNum1, newNum2);
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
	private int solveUsingSpaceOptimization(int[] nums1, int[] nums2) {

		// Step 1: create dp array
		int n = nums1.length;

		int swap = 0;
		int noSwap = 0;
		int currSwap = 0;
		int currNoSwap = 0;

		for (int index = n - 1; index >= 1; index--) {
			for (int isSwapped = 1; isSwapped >= 0; isSwapped--) {

				int ans = Integer.MAX_VALUE;
				int prev1 = 0;
				int prev2 = 0;
				if (index - 1 >= 0) {
					prev1 = nums1[index - 1];
					prev2 = nums2[index - 1];
				}

				// catch -> if swapped is true then swap prev1 and prev2
				if (isSwapped == 1) {
					int temp = prev1;
					prev1 = prev2;
					prev2 = temp;
				}

				// no swap
				if (nums1[index] > prev1 && nums2[index] > prev2)
					ans = noSwap;

				// swap
				if (nums1[index] > prev2 && nums2[index] > prev1)
					ans = Math.min(ans, 1 + swap);

				if (isSwapped == 1)
					currSwap = ans;
				else if (isSwapped == 0)
					currNoSwap = ans;
			}

			swap = currSwap;
			noSwap = currNoSwap;
		}
		return Math.min(swap, noSwap);
	}

	/**
	 * This is driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 5, 4 }, nums2 = { 1, 2, 3, 7 };

		MinimumSwapToMakeSeqIncreasingSpaceOptimization min = new MinimumSwapToMakeSeqIncreasingSpaceOptimization();
		System.out.println(min.minSwap(nums1, nums2));
	}
}
