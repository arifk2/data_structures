package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class ReducingDishesRecur {

	/**
	 * Solving using recursion
	 * 
	 * @param satisfaction
	 * @return
	 */
	public int maxSatisfaction(int[] satisfaction) {

		return solveUsingRecursion(satisfaction, 0, 0);
	}

	/**
	 * Solving using recursion
	 * 
	 * @param satisfaction
	 * @param index
	 * @param time
	 * @return
	 */
	private int solveUsingRecursion(int[] satisfaction, int index, int time) {
		// base case
		if (index == satisfaction.length)
			return 0;

		int include = satisfaction[index] * (time + 1) + solveUsingRecursion(satisfaction, index + 1, time + 1);
		int exclude = 0 + solveUsingRecursion(satisfaction, index + 1, time);

		return Math.max(include, exclude);
	}

	public static void main(String[] args) {
		int[] satisfaction = { 4, 3, 2 };
		Arrays.sort(satisfaction);
		ReducingDishesRecur r = new ReducingDishesRecur();
		System.out.println(r.maxSatisfaction(satisfaction));
	}
}
