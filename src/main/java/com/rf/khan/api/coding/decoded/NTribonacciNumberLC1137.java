package com.rf.khan.api.coding.decoded;

public class NTribonacciNumberLC1137 {

	public static void main(String[] args) {
		NTribonacciNumberLC1137 tri = new NTribonacciNumberLC1137();
		System.out.println(tri.tribonacci(4));
		System.out.println(tri.tribonacci(25));
	}

	public int tribonacci(int n) {
		if (n == 0)
			return 0;
		else if (n <= 2)
			return 1;
		else {
			// n is greater than 2
			int a = 0;
			int b = 1;
			int c = 1;
			int sum = 0;
			int index = 3;
			while (index <= n) {
				sum = a + b + c;
				a = b;
				b = c;
				c = sum;
				index++;
			}
			return sum;
		}
	}
}
