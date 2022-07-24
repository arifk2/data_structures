package com.rf.khan.api.iq.pattern;

public class Pattern21 {
	public static void main(String[] args) {

		int n = 4;
		int row = 1;
		while (row <= n) {

			// print space
			int space = row - 1;
			int count = 1;
			while (count <= space) {
				System.out.print(" ");
				count++;
			}
			space--;

			// print start
			int col = 1;
			int star = n - row + 1;
			while (col <= star) {
				System.out.print("*");
				col++;
			}
			System.out.println();
			row++;
		}
	}
}
