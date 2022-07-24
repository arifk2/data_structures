package com.rf.khan.api.iq.pattern;

public class Pattern4 {

	public static void main(String[] args) {

		int n = 3;
		int i = 1;
		int count = 1;
		while (i <= n) {
			int j = 1;
			while (j <= n) {
				System.out.print(count + " ");
				count++;
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
