package com.rf.khan.api.iq.binary.complete.binary.tree;

/**
 * Heap class
 * 
 * @author mkhan339
 *
 */
class Heap {
	int[] arr;
	int size;

	public Heap() {
		arr = new int[100];
		arr[0] = -1;
		size = 0;
	}
}

/*
 ************************************************
 * Max Heap: children must have minimum elements
 * 
 * Step1:Always start from the left and
 * 
 * Step2: Then replace to it correct position
 * 
 * @param val
 */
public class HeapImpl {
	Heap heap;

	/*
	 * This method is created to insert the element in the heap O(logN)
	 */
	public void insert(int val) {
		heap.size = heap.size + 1;
		int index = heap.size;
		heap.arr[index] = val;

		while (index > 1) {
			int parentIndex = index / 2;
			if (heap.arr[parentIndex] < heap.arr[index]) {
				int temp = heap.arr[parentIndex];
				heap.arr[parentIndex] = heap.arr[index];
				heap.arr[index] = temp;
			} else {
				return;
			}
		}
	}

	/**
	 * Step 1: Put the last element to the first index
	 * 
	 * Step2: remove the last node
	 * 
	 * Step3: propagate the root node to it correct position
	 */
	public void delete() {
		if (heap.size == 0) {
			System.out.println("Nothing to delete");
			return;
		}

		// step1: swap or put the last node with the first node
		heap.arr[1] = heap.arr[heap.size];
		heap.size--;

		// take a root node to its correct position
		int i = 1;
		while (i < heap.size) {
			int leftIndex = 2 * i;
			int rightIndex = 2 * i + 1;

			if (leftIndex < heap.size && heap.arr[i] < heap.arr[leftIndex]) {
				// swap
				int temp = heap.arr[i];
				heap.arr[i] = heap.arr[leftIndex];
				heap.arr[leftIndex] = temp;

				i = leftIndex;

			} else if (leftIndex < heap.size && heap.arr[i] < heap.arr[rightIndex]) {
				// swap
				int temp = heap.arr[i];
				heap.arr[i] = heap.arr[rightIndex];
				heap.arr[rightIndex] = temp;

				i = rightIndex;
			} else {
				return;
			}
		}
	}

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

	void print() {
		for (int i = 1; i <= heap.size; i++) {
			System.out.print(heap.arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		HeapImpl root = new HeapImpl();
		root.heap = new Heap();

		root.insert(55);
		root.insert(50);
		root.insert(52);
		root.insert(53);
		root.insert(54);

		root.print();
		root.delete();
		System.out.println();
		root.print();
		System.out.println("\n" + "Size of the tree is: " + root.heap.size);

		int arr[] = { -1, 54, 53, 55, 52, 50 };
		int n = 5;
		for (int i = n / 2; i > 0; i--) {
			root.heapify(arr, n, i);
		}

		System.out.println("Printing heapify array: ");
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
