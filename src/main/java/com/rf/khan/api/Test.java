package com.rf.khan.api;

public class Test {

	public static void main(String[] args) {
		System.out.println(sumOrProduct(15, 2));
		System.out.println("*".repeat(100));
	}

	public static long sumOrProduct(int n, int q) {
		long ans = 1;
		int m = 1000000007;
		if (q == 1) {
			ans = n * (n + 1) / 2;
			return ans;
		} else if (q == 2) {
			for (int i = 1; i <= n; i++) {
				ans = (ans * i) % m;
			}
			return ans;
		}
		return -1;
	}

}
