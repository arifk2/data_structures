package com.rf.khan.api.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasketLC904 {
	public static void main(String[] args) {
		FruitsInBasketLC904 fruits = new FruitsInBasketLC904();
		System.out.println(fruits.totalFruit(new int[] { 0, 1, 2, 2 }));
		System.out.println(fruits.totalFruit(new int[] { 1, 2, 1 }));
		System.out.println(fruits.totalFruit(new int[] { 1, 2, 3, 2, 2 }));
		System.out.println(fruits.totalFruit(new int[] { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 }));
		System.out.println("=".repeat(100));
		System.out.println(fruits.totalFruitOpt(new int[] { 0, 1, 2, 2 }));
		System.out.println(fruits.totalFruitOpt(new int[] { 1, 2, 1 }));
		System.out.println(fruits.totalFruitOpt(new int[] { 1, 2, 3, 2, 2 }));
		System.out.println(fruits.totalFruitOpt(new int[] { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 }));
	}

	public int totalFruit(int[] fruits) {
		int left = 0, right;
		Map<Integer, Integer> basket = new HashMap<>();
		int n = fruits.length;

		for (right = 0; right < n; right++) {
			basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

			if (basket.size() > 2) {
				basket.put(fruits[left], basket.get(fruits[left]) - 1);
				if (basket.get(fruits[left]) == 0) {
					basket.remove(fruits[left]);
				}
				left++;
			}
		}
		return right - left;
	}

	public int totalFruitOpt(int[] fruits) {
		int left = 0, right;
		Map<Integer, Integer> basket = new HashMap<>();
		int n = fruits.length;
		int maxPicked = 0;

		for (right = 0; right < n; right++) {
			basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

			if (basket.size() > 2) {
				basket.put(fruits[left], basket.get(fruits[left]) - 1);
				if (basket.get(fruits[left]) == 0) {
					basket.remove(fruits[left]);
				}
				left++;
			}
			maxPicked = Math.max(maxPicked, right - left + 1);
		}
		return maxPicked;
	}
}
