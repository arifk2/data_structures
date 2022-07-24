package com.rf.khan.api.iq.recursion;

public class SayDigit2 {
	public static void main(String[] args) {
		String[] inputArray = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		sayDigit(512, inputArray);
	}

	private static void sayDigit(int number, String[] inputArray) {

		if (number == 0) {
			return;
		}

		int digit = number % 10;
		number = number / 10;

		sayDigit(number, inputArray);
		System.out.print(inputArray[digit] + " ");

	}
}
