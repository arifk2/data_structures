package com.rf.khan.api.iq.pattern;

public class Pattern19 {

	public static void main(String[] args) {

		int n = 4;
		int row = 1;

		while (row <= n) {
			// print spaces
			int space = n - row;
			int l = 1;
			while (l <= space) {
				System.out.print(" ");
				l++;
			}
			space = space - 1;
			// print star
			int col = 1;
			while (col <= row) {
				System.out.print("*");
				col++;
			}
			System.out.println();
			row++;
		}
	}
}
