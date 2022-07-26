package com.rf.khan.api.iq.queue;

import java.util.Deque;
import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {
		System.out.println(sumMinMaxSubArrayUsingQueue(new Integer[] { 2, 5, -1, 7, -3, -1, -2 }, 4));
		System.out.println(sumMinMaxSubArrayUsingQueue(new Integer[] { 2, 5, -1, 7 }, 3));
	}

	private static int sumMinMaxSubArrayUsingQueue(Integer[] arr, int k) {
		int sum = 0;
		int n = arr.length;

		Deque<Integer> maxi = new LinkedList<>(), mini = new LinkedList<>();

		// for the kth window

		for (int i = 0; i < k; i++) {
			// removing greater element from the last queue

			while (!mini.isEmpty() && arr[mini.peekLast()] >= arr[i]) {
				mini.removeLast();
			}

			while (!maxi.isEmpty() && arr[maxi.peekLast()] <= arr[i]) {
				maxi.removeLast();
			}

			mini.addLast(i);
			maxi.addLast(i);
		}

		// for the rest of the elements

		for (int i = k; i < n; i++) {
			// sum karlo
			sum += arr[mini.peekFirst()] + arr[maxi.peekFirst()];

			// remove element from the window
			while (!mini.isEmpty() && mini.peekFirst() <= i - n) {
				mini.removeFirst();
			}

			while (!maxi.isEmpty() && maxi.peekFirst() <= i - n) {
				maxi.removeFirst();
			}

			while (!mini.isEmpty() && arr[mini.peekLast()] >= arr[i]) {
				mini.removeLast();
			}

			while (!maxi.isEmpty() && arr[maxi.peekLast()] <= arr[i]) {
				maxi.removeLast();
			}

			mini.addLast(i);
			maxi.addLast(i);
		}

		sum += arr[mini.peekFirst()] + arr[maxi.peekFirst()];

		return sum;
	}

}
