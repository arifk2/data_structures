package com.rf.khan.api.iq.recursion;

import java.util.Arrays;

public class InversionCount {

	public static void main(String[] args) {

		int arr[] = {8, 4, 2, 1};

		int endIndex = arr.length - 1;
		System.out.println("Answer is : " + mergeSortCount(arr, 0, endIndex));

		printArray(arr);

	}

	/**
	 * This method is created to
	 * 
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	private static int mergeSortCount(int[] arr, int startIndex, int endIndex) {
		// base case
		if (startIndex >= endIndex) {
			return 0;
		}

		int midIndex = startIndex + (endIndex - startIndex) / 2;
		int count = 0;

		// recursive call for the left part of the array
		count = mergeSortCount(arr, startIndex, midIndex);

		// recursive call for the right part of the array
		count += mergeSortCount(arr, midIndex + 1, endIndex);

		// merging small arrays
		count += mergeArray(arr, startIndex, endIndex);

		return count;
	}

	/**
	 * This method is created to merge two array
	 * 
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	private static int mergeArray(int[] arr, int startIndex, int endIndex) {

		int ans = 0;

		int midIndex = startIndex + (endIndex - startIndex) / 2;

		int len1 = midIndex - startIndex + 1;
		int len2 = endIndex - midIndex;

		// create two array
		int[] firstArray = new int[len1];
		int[] secondArray = new int[len2];

		// copy the element in the first array;
		int mainArrayIndex = startIndex;

		for (int i = 0; i < len1; i++) {
			firstArray[i] = arr[mainArrayIndex++];
		}
		// updating the mainIndex
		mainArrayIndex = midIndex + 1;

		// copy the element in the second array
		for (int i = 0; i < len2; i++) {
			secondArray[i] = arr[mainArrayIndex++];
		}

		// no merging the arrays
		int i = 0, j = 0;
		mainArrayIndex = startIndex;

		while (i < len1 && j < len2) {
			if (firstArray[i] > secondArray[j]) {
				// new
				ans += len1 - i;

				arr[mainArrayIndex++] = secondArray[j++];
			} else {
				arr[mainArrayIndex++] = firstArray[i++];
			}
		}

		while (i < len1) {
			arr[mainArrayIndex++] = firstArray[i++];
		}

		while (j < len2) {
			arr[mainArrayIndex++] = secondArray[j++];
		}

		return ans;
	}

	/**
	 * This is created to print the array
	 * 
	 * @param arr
	 */
	private static void printArray(int[] arr) {
		Arrays.stream(arr).forEach(i -> {
			System.out.print(i + " ");
		});
	}
}
