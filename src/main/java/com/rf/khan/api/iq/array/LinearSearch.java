package com.rf.khan.api.iq.array;

public class LinearSearch {
	public static void main(String[] args) {

		int[] inputArry = { 1, 5, -4, -2, 7, 4, 12 };
		int num = 10;
		boolean isPresent = false;

		for (int i = 0; i < inputArry.length; i++) {
			if (num == inputArry[i]) {
				isPresent = true;
				break;
			}

		}
		System.out.println("Is given elent present in the array? " + isPresent);
	}

}
