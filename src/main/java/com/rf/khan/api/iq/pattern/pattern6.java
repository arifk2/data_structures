package com.rf.khan.api.iq.pattern;

public class pattern6 {

	public static void main(String[] args) {
		int n = 10;
		int row = 1;
		while (row <= n) {

			int col = 1;
			while (col <= row) {
				System.out.print(row +" ");
				col++;
			}
			System.out.println();
			row++;
		}
	}
}
