package com.rf.khan.api.iq.array.sort;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {

		int inputArray1[] = { 3, 6, 9, 100 };
		int inputArray2[] = { 4, 10, 23, 24, 28, 30 };

		int[] result = ninjaAndSortedArrays(inputArray1, inputArray2, inputArray1.length, inputArray2.length);

		Arrays.stream(result).forEach(i -> {
			System.out.print(i + ", ");
		});

	}

	private static int[] ninjaAndSortedArrays(int[] inputArray1, int[] inputArray2, int m, int n) {
		int[] outputArray = new int[inputArray1.length + inputArray2.length];

		int i = 0;
		int j = 0;
		int k = 0;

		// loop jab tak jab tak dono array equal hai..
		while (i < m && j < n) {

			if (inputArray1[i] < inputArray2[j]) {
				// then insert the smaller into the third array.
				// and increase both the array
				outputArray[k] = inputArray1[i];
				i++;
				k++;
			} else {
				outputArray[k] = inputArray2[j];
				j++;
				k++;
			}
		}

		// array1 is greater size than array2

		while (i < m) {
			outputArray[k] = inputArray1[i];
			i++;
			k++;
		}

		while (j < n) {
			outputArray[k] = inputArray2[j];
			i++;
			j++;
		}

		return outputArray;
	}
}
