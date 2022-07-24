package com.rf.khan.api.iq.recursion;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {

		int[] inputArry = { 6, 6, -6, -2, -4, -6, 2, -6 };

		int size = inputArry.length;

		printArray(inputArry);
		quickSort(inputArry, 0, size - 1);

		printArray(inputArry);

	}

	private static void printArray(int[] inputArry) {
		Arrays.stream(inputArry).forEach(i -> {
			System.out.print(i + " ");
		});
		System.out.println();
	}

	/**
	 * 
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 */
	private static void quickSort(int[] arr, int startIndex, int endIndex) {

		// base case
		if (startIndex >= endIndex) {
			return;
		}

		// partition karo
		int partition = partitionArray(arr, startIndex, endIndex);

		// left part sort kardo
		quickSort(arr, startIndex, partition - 1);

		// right part sort kardo
		quickSort(arr, partition + 1, endIndex);
	}

	private static int partitionArray(int[] arr, int startIndex, int endIndex) {
		// assume pivot element
		int pivot = arr[startIndex];

		// get the exact position of the pivot (pivot ko apne sahi jagah pahucha do)
		int count = 0;
		for (int i = startIndex + 1; i <= endIndex; i++) {
			// count all the number less than pivot to get the index of the pivot element
			if (arr[i] <= pivot) {
				count++;
			}
		}
		// place pivot at right position
		int pivotIndex = startIndex + count;

		// swap to place the pivot element at it right place
		int temp = pivot;
		arr[startIndex] = arr[pivotIndex];
		arr[pivotIndex] = temp;

		// not at left side all the element should be smaller than pivot element and at
		// right all the element should be greater than pivot element

		int start = startIndex; //two pointer
		int end = endIndex;

		while (start < pivotIndex && end > pivotIndex) {
			/*if (arr[start] > arr[end]) {
				// swap kardo
				temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;

				start++;
				end--;

			} else if (arr[start] <= pivot) {
				start++;
			} else if (arr[end] > pivot) {
				end--;
			}
		}*/

			// move start++ till we find element greater than pivot element in left side
			while (arr[start] <= pivot) {
				start++;
			}
			// move end-- till we find smaller elements than pivot in right side
			while (arr[end] > pivot) {
				end--;
			}
			// swap the values if found
			if (start < pivotIndex && end > pivotIndex) {
				temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;

				start++;
				end--;
			}
		}
		
		return pivotIndex;
	}
}
