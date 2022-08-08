package com.rf.khan.api.iq.binary.coomplete.binary.tree;

import java.util.ArrayList;
import java.util.Collections;

public class HeapSort2 {
	public static ArrayList<Integer> heapSort(ArrayList<Integer> arr, int n) {
		for (int i = (n / 2) - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		ArrayList<Integer> ans = arr;

		ArrayList<Integer> arry = heapIt(ans, n);
		return arry;
	}

	public static ArrayList<Integer> heapIt(ArrayList<Integer> arr, int n) {
		int size = n - 1;
		while (size > 0) {
			// swap root element to the last and heapify
			Collections.swap(arr, size, 0);
			heapify(arr, size, 0);
			size--;
		}
		return arr;
	}

	public static void heapify(ArrayList<Integer> arr, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && arr.get(largest) < arr.get(left)) {
			largest = left;
		}
		if (right < n && arr.get(largest) < arr.get(right)) {
			largest = right;
		}

		if (largest != i) {
			// swap

			Collections.swap(arr, largest, i);
			heapify(arr, n, largest);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();

		arr.add(5);
		arr.add(-2);
		arr.add(3);
		arr.add(-1);
		arr.add(8);

		/*
		 * arr.add(10); arr.add(7); arr.add(8); arr.add(11);
		 */
		heapSort(arr, 5);

		System.out.println(arr);
	}
}