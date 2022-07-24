package com.rf.khan.api.iq.array.ques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SumOfTwoArray {

	public static void main(String[] args) {
		int[] inputArray1 = { 1, 2, 3, 4 };
		int n = inputArray1.length;
		int[] inputArray2 = { 6 };
		int m = inputArray2.length;

		int[] result = findArraySum(inputArray1, n, inputArray2, m);

		Arrays.stream(result).forEach(i -> {
			System.out.print(i + " ");
		});

	}

	public static int[] findArraySum(int[] a, int n, int[] b, int m) {

		ArrayList<Integer> result = new ArrayList<>();
		
		// last se chalna right ko
		int i = n - 1;
		int j = m - 1;
		int carry = 0;

		// for the equal array
		while (i >= 0 && j >= 0) {
			
			// get the value from both the array
			int val1 = a[i];
			int val2 = b[j];

			int sum = val1 + val2 + carry;

			carry = sum / 10;
			sum = sum % 10;

			result.add(sum);

			i--;
			j--;
		}

		// first case: array 1 bada hai aur bacha hai
		while (i >= 0) {
			int sum = a[i] + carry;
			carry = sum / 10;
			sum = sum % 10;

			result.add(sum);

			i--;
		}

		// second case array 2 bada hai aur bacaha hai.
		while (j >= 0) {
			int sum = b[j] + carry;
			carry = sum / 10;
			sum = sum % 10;

			result.add(sum);
			j--;
		}

		// third carry bacha hai dono array equal hai

		while (carry != 0) {
			int sum = carry;
			carry = sum / 10;
			sum = sum % 10;
			result.add(sum);
		}

		Collections.reverse(result);

		return convertListToArray(result);
	}

	public static int[] convertListToArray(ArrayList<Integer> result) {
		int[] resultantArray = new int[result.size()];

		for (int i = 0; i < result.size(); i++) {
			resultantArray[i] = result.get(i);
		}
		return resultantArray;
	}
}
