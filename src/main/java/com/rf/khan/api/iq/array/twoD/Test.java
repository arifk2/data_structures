package com.rf.khan.api.iq.array.twoD;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		int[][] arr = new int[3][4];
		int count = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = count++;
			}
		}

		int row = 0, col = 0;

		for (row = 0; row < 3; row++) {
			for (col = 0; col < 4; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int[] in : arr) {
			System.out.println(Arrays.toString(in));
		}
	}

}
