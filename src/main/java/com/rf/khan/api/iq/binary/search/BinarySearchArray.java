package com.rf.khan.api.iq.binary.search;

public class BinarySearchArray {

	public static void main(String[] args) {
		int evenArray[] = { 2, 4, 6, 8, 12, 18 };
		int oddArray[] = { 3, 8, 11, 14, 16 };

		System.out.println(
				"Binary Search of the even array and the index of the target number is : " + searchIndex(evenArray, 0));
		System.out.println("Binary Search of the given odd array and the index of the target number is : "
				+ searchIndex(oddArray, 8));

	}

	/**
	 * This method is created to search the index by using binary Search algorithms
	 * 
	 * @param input  input array
	 * @param target target value to find the the given array
	 * @return return the index of the array if found else -1 not found
	 */
	private static int searchIndex(int[] input, int target) {

		// start Index
		int startIndex = 0;

		// End Index
		int endIndex = input.length - 1;

		// Mid Index
		// at a instant of point if the start index and end index have the maximum value
		// of the integer, then it will exceed the integer limit, so in that case we need to
		// change the equation.
		// integer midIndex = (startIndex + endIndex) / 2;

		int midIndex = startIndex + (endIndex - startIndex) / 2;
		while (startIndex <= endIndex) {

			// if the mid element is equal to the target then return the mid index
			if (target == input[midIndex]) {
				return midIndex;
			}

			// If the target is greater than the mid index element, then it means than
			// target should be after the mid index, so we need to increase the start index
			// with mid index and make it as a start index and end index should be same.
			if (target > input[midIndex]) {
				startIndex = midIndex + 1; // go right
			} else {
				endIndex = midIndex - 1; // go left
			}
			midIndex = startIndex + (endIndex - startIndex) / 2;
		}
		return -1;
	}
}
