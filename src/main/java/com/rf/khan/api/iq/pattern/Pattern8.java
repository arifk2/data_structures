package com.rf.khan.api.iq.pattern;

public class Pattern8 {
	public static void main(String[] args) {
		method1();
		method2();
	}

	public static void method1() {
		System.out.println("********method one start************ ");
		int n = 4;

		int row = 1;
		while (row <= n) {
			int col = 1;
			int value = row;
			while (col <= row) {
				System.out.print(value);
				value++;
				col++;
			}
			System.out.println();
			row++;
		}
		System.out.println("********method one end************ ");
	}

	public static void method2() {
		System.out.println("********method two start************ ");
		int n = 4;
		int row = 1;
		while (row <= n) {
			int col = 1;
			while (col <= row) {
				System.out.print(row + col - 1);
				col++;
			}
			System.out.println();
			row++;
		}
		System.out.println("********method two end************ ");
	}
}
