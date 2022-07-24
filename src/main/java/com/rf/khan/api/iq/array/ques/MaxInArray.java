package com.rf.khan.api.iq.array.ques;

public class MaxInArray {

	public static void main(String[] args) {

		int[] arr = { 3, 4, 5, 1, 3, 6, 7, 8, 2 };
		int maxi = 0, ansIndex = 0;

		for (int i = 0; i < arr.length; i++) {
			if (maxi < arr[i]) {
				maxi = arr[i];
				ansIndex = i;
			}
		}
		System.out.println("Maximum numbe in the Array is: " + arr[ansIndex]);
	}
}
