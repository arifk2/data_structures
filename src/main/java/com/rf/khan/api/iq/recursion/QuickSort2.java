package com.rf.khan.api.iq.recursion;

public class QuickSort2 {

	public static void main(String[] args) {
		int[] arr = { 6, 6, -6, -2, -4, -6, 2, -6 };
		int size = arr.length;

		quickSort(arr, 0, size - 1);

		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void quickSort(int[] arr, int startIndex, int endIndex) {
		// base case
		if (startIndex >= endIndex)
			return;

		// take the partition
		int partition = partitionArray(arr, startIndex, endIndex);

		// left part sort
		quickSort(arr, startIndex, partition - 1);

		// right part sort
		quickSort(arr, partition + 1, endIndex);

	}

	public static int partitionArray(int[] arr, int startIndex, int endIndex) {

		int pivot = arr[startIndex];
		int count = 0;
		// count of elements smaller than pivot element
		for (int i = startIndex + 1; i <= endIndex; i++) {
			if (arr[i] <= pivot)
				count++;
		}

		int pivotIndex = startIndex + count;

		// put pivot element at correct position
		int temp = pivot;
		arr[startIndex] = arr[pivotIndex];
		arr[pivotIndex] = temp;

		int start = startIndex;
		int end = endIndex;

		// make smaller elements lie before pivot & larger elements after pivot
		while (start < pivotIndex && end > pivotIndex) {

			// move sIdx++ till we find element greater than pivot element in left side
			while (arr[start] <= pivot) {
				start++;
			}
			// move eIdx-- till we find smaller elements than pivot in right side
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
