package com.rf.khan.api.iq.queue;

import java.util.ArrayList;
import java.util.List;

public class SumMinMaxSubArray {

	public static void main(String[] args) {
		System.out.println(sumMinMaxSubArrayBruteFroce(new Integer[] { 2, 5, -1, 7, -3, -1, -2 }, 4));
	}

	public static List<Integer> sumMinMaxSubArrayBruteFroce(Integer[] integers, int k) {
		List<Integer> ans = new ArrayList<>();
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			for (int j = i; j < i + k; j++) {
				System.out.print(integers[j] + " ");
				max = Math.max(max, integers[j]);
				min = Math.min(min, integers[j]);
			}
			System.out.println();
			sum = max + min;
			ans.add(sum);
		}
		return ans;
	}
}
