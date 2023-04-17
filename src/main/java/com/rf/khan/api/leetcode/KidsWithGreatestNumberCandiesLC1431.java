package com.rf.khan.api.leetcode;

import java.util.LinkedList;
import java.util.List;

public class KidsWithGreatestNumberCandiesLC1431 {
	/**
	 * This is a main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] candies = { 2, 3, 5, 1, 3 };
		int extraCandies = 3;

		KidsWithGreatestNumberCandiesLC1431 k = new KidsWithGreatestNumberCandiesLC1431();
		System.out.println(k.kidsWithCandies(candies, extraCandies));
		System.out.println(k.kidsWithCandies(new int[] { 4, 2, 1, 1, 2 }, 1));
		System.out.println(k.kidsWithCandies(new int[] { 12, 1, 12 }, 10));
	}

	/**
	 * This method is created to get the kids with candies
	 * 
	 * @param candies      holds the information of the candies
	 * @param extraCandies holds the information of the extra candies
	 * @return
	 */
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		int maxCandies = Integer.MIN_VALUE;

		for (int candy : candies)
			maxCandies = Math.max(maxCandies, candy);

		List<Boolean> result = new LinkedList<>();
		for (int candy : candies) {
			if (candy + extraCandies >= maxCandies) {
				result.add(Boolean.TRUE);
			} else {
				result.add(Boolean.FALSE);
			}
		}
		return result;
	}
}
