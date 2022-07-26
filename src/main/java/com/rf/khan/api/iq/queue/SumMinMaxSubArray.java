package com.rf.khan.api.iq.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SumMinMaxSubArray {

	public static void main(String[] args) {
		System.out.println(sumMinMaxSubArrayBruteForce(new Integer[] { 2, 5, -1, 7, -3, -1, -2 }, 4));
		System.out.println(sumMinMaxSubArrayUsingQueue(new Integer[] { 2, 5, -1, 7, -3, -1, -2 }, 4));
	}

	public static int sumMinMaxSubArrayBruteForce(Integer[] integers, int k) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			for (int j = i; j < i + k; j++) {
				// System.out.print(integers[j] + " ");
				max = Math.max(max, integers[j]);
				min = Math.min(min, integers[j]);
			}
			// System.out.println();
			sum += max + min;
		}
		return sum;
	}

	public static int sumMinMaxSubArrayUsingQueue(Integer[] arr, int k) {
		int sum = 0;
		int n = arr.length;

		// Step:1 Create maxi and mini dequeue
		Deque<Integer> maxi = new LinkedList<>(), mini = new LinkedList<>();

		// Step2: Process for the first kth window
		for (int i = 0; i < k; i++) {

			// remove all previous greater element
			while (!mini.isEmpty() && arr[mini.peekLast()] >= arr[i]) {
				mini.removeLast();
			}

			// remove all previous smaller element
			while (!maxi.isEmpty() && arr[maxi.peekLast()] <= arr[i]) {
				maxi.removeLast();
			}

			// add current element to the queue
			maxi.addLast(i);
			mini.addLast(i);
		}

		// Step3: Process rest of the array k-n
		for (int i = k; i < n; i++) {

			// Step 4: element present in the front having largest and smallest element of
			// the
			// previous window
			sum += arr[mini.peekFirst()] + arr[maxi.peekFirst()];

			// Step 5: remove all the element which is out of the window
			while (!mini.isEmpty() && mini.peekFirst() <= i - k) {
				mini.removeFirst();
			}
			while (!maxi.isEmpty() && maxi.peekFirst() <= i - k) {
				maxi.removeFirst();
			}

			// Step 6: remove all previous greater element
			while (!mini.isEmpty() && arr[mini.peekLast()] >= arr[i]) {
				mini.removeLast();
			}
			// remove all previous smaller element
			while (!maxi.isEmpty() && arr[maxi.peekLast()] <= arr[i]) {
				maxi.removeLast();
			}

			maxi.addLast(i);
			mini.addLast(i);
		}

		sum += arr[mini.peekFirst()] + arr[maxi.peekFirst()];

		return sum;
	}
}
