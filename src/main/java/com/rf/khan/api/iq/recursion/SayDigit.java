package com.rf.khan.api.iq.recursion;

public class SayDigit {

	public static void main(String[] args) {
		String[] inputArray = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		sayDigit(512, inputArray);

	}

	public static void sayDigit(int number, String[] arr) {
		if (number == 0) {
			return;
		}

		// processing
		int digit = number % 10;
		number = number / 10;

		sayDigit(number, arr);
		System.out.print(arr[digit] + " ");
	}

}
