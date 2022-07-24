package com.rf.khan.api.iq.array.sort;

public class BubbleSort {
	public static void main(String[] args) {
		bubbleSort(new int[] { 64, 25, 12, 22, 11 }, 5);
	}

	public static void bubbleSort(int[] arr, int n) {
		for (int i = 1; i < n; i++) {

			// optimizing- round at which no swap happens
			boolean isSwapped = false;

			// j< n-1 because humko last wala nhi check karna, last me largest value hogi
			for (int j = 0; j < n - i; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap kardo arr[i] ko arr[j+1] kyunki large ko last me bhejna hai..
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSwapped = true;
				}
			}
			if (isSwapped == false) {
				// already sorted
				break;
			}
		}
		printArray(arr);
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
}
