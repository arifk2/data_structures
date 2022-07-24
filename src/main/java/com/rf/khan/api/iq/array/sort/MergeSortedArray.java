package com.rf.khan.api.iq.array.sort;

import java.util.Arrays;

public class MergeSortedArray {
	public static void main(String[] args) {
		int inputArray1[] = { 3, 6, 9 };
		int inputArray2[] = { 4, 10 };

		int[] result = ninjaAndSortedArrays(inputArray1, inputArray2, 3, 2);

		Arrays.stream(result).forEach(i -> {
			System.out.print(i + ", ");
		});
	}

	public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
		int arr3[] = new int[5];
		int i = 0;
		int j = 0;
		int k = 0;

		// loop upto the same size
		while (i < m && j < n) {

			// if any of the element is smaller, put it on third array
			if (arr1[i] < arr2[j]) {
				arr3[k] = arr1[i];
				i++;
				k++;
			} else {
				arr3[k] = arr2[j];
				j++;
				k++;
			}
		}
		// means second array is greater size than the first array
		while (i < m) {
			arr3[k] = arr1[i];
			k++;
			i++;
		}

		while (j < n) {
			arr3[k] = arr2[j];
			k++;
			j++;
		}
		return arr3;
	}

}
