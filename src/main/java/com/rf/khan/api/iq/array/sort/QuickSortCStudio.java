package com.rf.khan.api.iq.array.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSortCStudio {

	public static void main(String[] args) {

		int[] inputArry = { 5, 3, 2, 6, 4, 4 };

		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < inputArry.length; i++) {
			arr.add(inputArry[i]);
		}
		System.out.println(arr);
		int startIndex = 0;
		int endIndex = arr.size() - 1;

		quickSortAlgo(arr, startIndex, endIndex);

		System.out.println(arr);
	}

	/**
	 * 
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 */
	private static void quickSortAlgo(List<Integer> arr, int startIndex, int endIndex) {

		// Step:a) base case
		if (startIndex >= endIndex) {
			return;
		}

		// Step:b)
		int partition = partitionArray(arr, startIndex, endIndex);

		// Step:c) left part sort kardo
		quickSortAlgo(arr, startIndex, partition - 1);

		// Step:d) right part sort kardo
		quickSortAlgo(arr, partition + 1, endIndex);
	}

	private static int partitionArray(List<Integer> arr, int startIndex, int endIndex) {
		// Step 1: identify the pivot element
		int pivot = arr.get(startIndex);

		// Step 2: get the exact position of the pivot (pivot ko apne sahi jagah pahucha
		// do)
		int count = 0;
		for (int i = startIndex + 1; i <= endIndex; i++) {
			// count all the number less than pivot to get the index of the pivot element
			if (arr.get(i) <= pivot) {
				count++;
			}
		}
		// Step 3: place pivot at right position
		int pivotIndex = startIndex + count;

		// Step:4: swap to place the pivot element at it right place : pivot reach its right place
		Collections.swap(arr, pivotIndex, startIndex);

		// Step5:
		// now at left side all the element should be smaller than pivot element and at
		// right all the element should be greater than pivot element

		int start = startIndex;
		int end = endIndex;

		while (start < pivotIndex && end > pivotIndex) {
			if (arr.get(start) > arr.get(end)) { //= bhi tha
				// swap kardo
				Collections.swap(arr, start, end);

				start++;
				end--;

			} else if (arr.get(start) < pivot) { //= bhi tha
				start++;

			} else if (arr.get(end) > pivot) {
				end--;
			}
		}
		return pivotIndex;
	}
}
