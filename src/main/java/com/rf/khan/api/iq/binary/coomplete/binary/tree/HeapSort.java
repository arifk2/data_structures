package com.rf.khan.api.iq.binary.coomplete.binary.tree;

public class HeapSort {

	/**
	 * Heapify algorithm
	 * 
	 * @param arr
	 * @param n
	 * @param i
	 */
	public void heapify(int[] arr, int n, int i) {
		int largest = i;

		int left = 2 * i;
		int right = 2 * i + 1;

		if (left <= n && arr[largest] < arr[left]) {
			largest = left;
		}
		if (right <= n && arr[largest] < arr[right]) {
			largest = right;
		}

		if (largest != i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			heapify(arr, n, largest);
		}
	}

	/**
	 * This is the heap sort method created to sort the heap
	 * 
	 * @param arr
	 * @param n
	 */
	public void heapSort(int[] arr, int n) {
		int size = n;

		while (size > 1) {
			// Step1: swap the last element with the root element
			int temp = arr[size];
			arr[size] = arr[1];
			arr[1] = temp;

			// Step2: decrease the size
			size--;

			// Step 3: call the heapify method to put the root into the correct position
			heapify(arr, size, 1);
		}
	}

	/**
	 * print array
	 */
	public void print(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		HeapSort root = new HeapSort();

		int arr[] = { -1, 50, 70, 55, 45, 60 };
		int n = 5;
		for (int i = n / 2; i > 0; i--) {
			root.heapify(arr, n, i);
		}

		System.out.println("Printing heapify array: ");
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println("\nPrint the sorted array after heap sort");
		root.heapSort(arr, n);

		root.print(arr);

	}
}
