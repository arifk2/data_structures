package com.rf.khan.api.iq.pattern;

public class Pattern12 {
	public static void main(String[] args) {

		int n = 3;
		int i = 1;
		// int count = 1;
		char num = 'A';

		while (i <= n) {
			int j = 1;
			while (j <= n) {
				// char ch = (char) ('A' + count - 1);
				// System.out.print(ch);
				System.out.print(num);
				num++;
				// count++;
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
