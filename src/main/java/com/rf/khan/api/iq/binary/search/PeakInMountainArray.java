package com.rf.khan.api.iq.binary.search;

public class PeakInMountainArray {
	public static void main(String[] args) {
		System.out.println(peakIndexInMountainArray(new int[] { 0, 10, 5, 2 }));
	}

	public static int peakIndexInMountainArray(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int mid = start + (end - start) / 2;

		while (start < end) {
			if (arr[mid] < arr[mid + 1]) {
				start = mid + 1;
			} else {
				end = mid;
			}

			mid = start + (end - start) / 2;
		}

		return start;
	}
}
