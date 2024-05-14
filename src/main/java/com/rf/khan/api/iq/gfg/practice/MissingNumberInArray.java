package com.rf.khan.api.iq.gfg.practice;

public class MissingNumberInArray {

	public static void main(String[] args) {
		MissingNumberInArray m = new MissingNumberInArray();
		System.out.println(m.missingNumber(new int[] { 1, 2, 3, 5 }, 5));
		System.out.println(m.missingNumber(new int[] { 6, 1, 2, 8, 3, 4, 7, 10, 5 }, 10));
		System.out.println(m.missingNumber(new int[] { 1 }, 2));
	}

	int missingNumber(int array[], int n) {
		int total;
		total = (n + 1) * (n) / 2;

		for (int i = 0; i < n - 1; i++) {
			total -= array[i];
		}
		return total;
	}
}
