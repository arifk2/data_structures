package com.rf.khan.api.iq.binary.search;

public class SearchInSortedRotatedArray {

	public static void main(String[] args) {
		int inputArry[] = { 2, 5, -3, 0 };

		System.out.println(search(inputArry, 0));

	}

	public static int getPivotIndex(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int mid = start + (end - start) / 2;
		while (start < end) {
			if (arr[mid] >= arr[0]) {
				start = mid + 1;
			} else {
				end = mid;
			}
			mid = start + (end - start) / 2;
		}
		return start;
	}

	public static int binarySearch(int[] arr, int start, int end, int target) {
		int mid = start + (end - start) / 2;
		while (start <= end) {
			if (target == arr[mid]) {
				return mid;
			}
			// if target is smaller than mid it means we need to traverse left
			if (target < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

			mid = start + (end - start) / 2;
		}
		return -1;
	}

	public static int search(int arr[], int key) {
		int pivotIndex = getPivotIndex(arr);
		int n = arr.length;
		System.out.println("pivot is : " + pivotIndex);
		// binary search on last line
		if (arr[pivotIndex] <= key && key <= arr[n - 1]) {
			return binarySearch(arr, pivotIndex, n - 1, key);
			// binary search on first line
		} else {
			return binarySearch(arr, 0, pivotIndex - 1, key);
		}

	}
}
