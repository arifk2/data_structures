package com.rf.khan.api.iq.array.sort;

public class MergeSortRecursion {
	public static void main(String[] args) {

		int arr[] = { 3, 7, 0, 1, 5, 8, 3, 2, 34, 66, 87, 23, 12, 12, 12 };

		int arrSize = arr.length - 1;
		mergeSort(arr, 0, arrSize);

		printArray(arr);

	}

	private static void printArray(int[] arr) {
		java.util.Arrays.stream(arr).forEach(i -> {
			System.out.print(i + " ");
		});

	}

	/**
	 * This method is created to break arrays into the sub-arrays
	 * 
	 * @param arr        holds the information of the array
	 * @param startIndex holds the information of the start index
	 * @param endIndex   holds the information of the end index
	 */
	private static void mergeSort(int[] arr, int startIndex, int endIndex) {

		// base case
		// at that point when the start and end is point to each other, since one
		// element will always be sorted
		if (startIndex >= endIndex) {
			return;
		}

		int midIndex = startIndex + (endIndex - startIndex) / 2;

		// to sort the left part using recursion.
		mergeSort(arr, startIndex, midIndex);

		// to sort the right part using recursion.
		mergeSort(arr, midIndex + 1, endIndex);

		// now merge arrays
		mergeArray(arr, startIndex, endIndex);
	}

	private static void mergeArray(int[] arr, int startIndex, int endIndex) {

		int midIndex = startIndex + (endIndex - startIndex) / 2;

		int len1 = midIndex - startIndex + 1;
		int len2 = endIndex - midIndex;

		int[] firstArray = new int[len1];
		int[] secondArray = new int[len2];

		// copy values to second array
		int mainIndex = startIndex;

		for (int i = 0; i < len1; i++) {
			firstArray[i] = arr[mainIndex++];
		}
		
		// copy values to second array
		mainIndex = midIndex + 1;

		for (int i = 0; i < len2; i++) {
			secondArray[i] = arr[mainIndex++];
		}

		int i = 0, j = 0;

		mainIndex = startIndex;

		while (i < len1 && j < len2) {
			if (firstArray[i] < secondArray[j]) {
				arr[mainIndex++] = firstArray[i++];
			} else {
				arr[mainIndex++] = secondArray[j++];
			}
		}

		while (i < len1) {
			arr[mainIndex++] = firstArray[i++];
		}

		while (j < len2) {
			arr[mainIndex++] = secondArray[j++];
		}
	}
}
