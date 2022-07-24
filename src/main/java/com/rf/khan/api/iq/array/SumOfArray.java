package com.rf.khan.api.iq.array;

public class SumOfArray {

	public static void main(String[] args) {

		int[] inputArry = { 1, 5, -4, -2, 7, 4, 12 };
		int sum = 0;

		for (int i = 0; i < inputArry.length; i++) {
			sum = sum + inputArry[i];
		}
		System.out.println("Sum of the given array is : " + sum);
	}
}
