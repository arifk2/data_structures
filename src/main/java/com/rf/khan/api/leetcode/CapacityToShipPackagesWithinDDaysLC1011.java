package com.rf.khan.api.leetcode;

public class CapacityToShipPackagesWithinDDaysLC1011 {
	public static void main(String[] args) {
		CapacityToShipPackagesWithinDDaysLC1011 c = new CapacityToShipPackagesWithinDDaysLC1011();
		System.out.println(c.shipWithinDays(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5));
	}

	public int shipWithinDays(int[] weights, int days) {
		int min = 0;
		int max = 0;

		for (int weight : weights) {
			min = Math.max(min, weight);
			max += weight;
		}
		int retVal = 0;
		while (min <= max) { // O(log(max-min))
			int mid = (min + max) / 2;
			int daysRequired = numberOfDaysNeededWithCapacity(weights, mid);// O(n)
			if (daysRequired > days) {
				min = min + 1;
			} else {
				retVal = mid;
				max = mid - 1;
			}
		}
		return retVal;
	}

	private int numberOfDaysNeededWithCapacity(int[] weights, int capcity) {
		int daysRequired = 1;
		int current = 0;

		for (int w : weights) {
			current += w;
			if (current > capcity) {
				daysRequired++;
				current = w;
			}
		}
		return daysRequired;
	}

}
