package com.rf.khan.api.leetcode;

import java.util.Arrays;

public class OnlineStockSpanLC901 {

	public static void main(String[] args) {
		OnlineStockSpanLC901 o = new OnlineStockSpanLC901();
		int[] arr = { 100, 80, 60, 70, 60, 75, 85 };
		int[] ans = o.stockSpan(arr, arr.length);
		Arrays.stream(ans).forEach(i -> {
			System.out.print(i + " ");
		});
	}

	private int[] stockSpan(int[] arr, int length) {
		int[] ans = new int[length];

		for (int i = 0; i < length; i++) {
			int span = 1;
			for (int j = i - 1; j >= 0 && arr[i] >= arr[j]; j--) {
				span++;
			}
			ans[i] = span;
		}
		return ans;
	}
}
