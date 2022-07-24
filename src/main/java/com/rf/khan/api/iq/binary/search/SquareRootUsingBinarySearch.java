package com.rf.khan.api.iq.binary.search;

public class SquareRootUsingBinarySearch {

	public static void main(String[] args) {
		// System.out.println(binarySearch(2147395599));
		int n = 101;
		int tempSol = binarySearch(n);
		System.out.println(tempSol);
		float pressionAns = morePrecission(n, 3, tempSol);
		System.out.println("Ans is: " + pressionAns);

	}

	/**
	 * This method is created to get the square root using BS
	 * 
	 * @param n
	 * @return
	 */
	public static int binarySearch(int n) {

		long start = 0;
		long end = n;
		long mid = start + (end - start) / 2;

		long ans = -1;

		while (start <= end) {
			long square = mid * mid;
			if (square == n) {
				return (int) mid;
			}
			if (square < n) {
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = start + (end - start) / 2;
		}
		return (int) ans;
	}

	public static float morePrecission(int n, int precession, int tempSol) {
		double factor = 0.1;
		double ans = tempSol;

		for (int i = 0; i < precession; i++) {
			factor = factor / 10;
			for (double j = ans; j * j < n; j = j + factor) {
				ans = j;
			}
		}

		return (float) ans;
	}

}
