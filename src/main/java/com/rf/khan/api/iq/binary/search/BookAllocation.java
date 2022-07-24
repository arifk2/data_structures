package com.rf.khan.api.iq.binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class BookAllocation {

	public static void main(String[] args) {
		Integer[] inputArray = { 20, 17, 10, 5, 12, 4, 14, 5, 5, 5, 14, 17, 14, 12, 11, 1, 15, 5, 9, 0 };
		Arrays.sort(inputArray);
		ArrayList<Integer> inputArrayList = (ArrayList<Integer>) Arrays.stream(inputArray).collect(Collectors.toList());
		int lengthOfInputArrayList = inputArrayList.size();
		int numberOfStudent = 4;
		int result = allocateBooks(inputArrayList, lengthOfInputArrayList, numberOfStudent);
		System.out.println("Answer is: " + result);
	}

	public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {
		Collections.sort(arr);
		int start = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			end += arr.get(i);
		}
		int ans = -1;
		int mid = start + (end - start) / 2;

		while (start <= end) {
			if (isPossibleSolution(arr, n, m, mid)) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}

			mid = start + (end - start) / 2;
		}
		return ans;
	}

	private static boolean isPossibleSolution(ArrayList<Integer> arr, int n, int m, int mid) {
		int studentCount = 1;
		int pageSum = 0;
		for (int i = 0; i < n; i++) {
			if (pageSum + arr.get(i) <= mid) {
				pageSum += arr.get(i);
			} else {
				studentCount++;
				// check karo kahin student count to jyda nahi ho gaya with given student no
				// or arr ki vakue jo value assign karne wale ho wo mid se badi na ho
				if (studentCount > m || arr.get(i) > mid) {
					return false;
				}
				pageSum = arr.get(i);
			}
		}
		return true;
	}

}
