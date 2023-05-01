package com.rf.khan.api.leetcode;

public class AvgSalExMinMaxLC1491 {

	public double average(int[] salary) {
		int minSal = Integer.MAX_VALUE;
		int maxSal = Integer.MIN_VALUE;
		int sum = 0;
		for (int sal : salary) {
			sum += sal;

			minSal = Math.min(minSal, sal);
			maxSal = Math.max(maxSal, sal);

		}
		return (double) (sum - minSal - maxSal) / (double) (salary.length - 2);
	}
}