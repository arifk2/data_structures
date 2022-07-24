package com.rf.khan.api.iq.array.sort;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		insertionSort(5, new int[] { 64, 25, 12, 22, 11 });
	}

	public static void insertionSort(int n, int[] arr) {

		for (int i = 1; i < n; i++) {
			int temp = arr[i];
			int j = i - 1;
			for (; j >= 0; j--) {

				if (arr[j] > temp) {
					// shift karde right side
					arr[j + 1] = arr[j];
				} else {
					// ruk jao
					break;
				}
			}
			arr[j + 1] = temp;
		}
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		Arrays.stream(arr).forEach(i -> {
			System.out.print(i + ", ");
		});

	}
}
