package com.rf.khan.api.iq.array.ques;

/**
 * 
 * @author mkhan339
 *
 */
public class LongestNiceSubarrayLC2401 {

	/**
	 * This method will return the length of the longest array
	 * 
	 * @param nums
	 * @return
	 */
	public int longestNiceSubarray(int[] nums) {

		int ans = Integer.MIN_VALUE;
		int startIndex = 0;

		int bitsUnion = 0;

		for (int i = 0; i < nums.length; i++) {
			int newElement = nums[i];

			// violate the window
			while ((bitsUnion & newElement) != 0) {
				int startingElement = nums[startIndex];

				// Remove element from start
				bitsUnion ^= startingElement;
				startIndex++;
			}

			// happy case
			// Including new element
			bitsUnion = bitsUnion | newElement;
			ans = Math.max(ans, i - startIndex + 1);
		}

		return ans;
	}

	/**
	 * Driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LongestNiceSubarrayLC2401 l = new LongestNiceSubarrayLC2401();
		int arr[] = { 1, 3, 8, 48, 10 };
		System.out.println(l.longestNiceSubarray(arr));
		System.out.println(l.longestNiceSubarray(new int[] { 3, 1, 5, 11, 13 }));
	}
}
