package com.rf.khan.api.gg.array;

/**
 * O(n)
 * 
 * @author mkhan339
 *
 */
public class KadaneAlgoMaxSumContSubArray {

	public static void main(String[] args) {
		int[] arr = { 4, -8, 9, -4, 1, -8, -1, 6 };
		int n = 8;
		System.out.println(maxSumContigiousSubArray(arr, n));
	}

	/**
	 * This method is created to get the max contiguous sum of sub-array
	 * 
	 * @param arr holds the information of the sub-array
	 * @param n   total size of array
	 * @return sum
	 */
	private static int maxSumContigiousSubArray(int[] arr, int n) {
		int maxSum = 0;
		int currentSum = 0;

		for (int i = 0; i < n; i++) {
			currentSum = currentSum + arr[i];

			if (currentSum > maxSum) {
				maxSum = currentSum;
			}

			if (currentSum < 0) {
				currentSum = 0;
			}
		}
		return maxSum;
	}
}
