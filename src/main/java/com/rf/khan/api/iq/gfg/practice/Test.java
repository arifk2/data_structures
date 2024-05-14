package com.rf.khan.api.iq.gfg.practice;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {

		System.out.println(duplicates(new int[] { 3, 4, 12, 3, 12, 3, 4, 4, 12, 7, 11, 6, 5 }, 13));
		System.out.println(duplicates(new int[] { 2, 4, 3, 0, 4 }, 5));

	}

	private static ArrayList<Integer> duplicates(int[] arr, int n) {

		for (int i = 0; i < n; i++) {
			int index = arr[i] % n;
			arr[index] += n;
		}

		int flag = 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if ((arr[i] / n) > 1) {
				ans.add(i);
				flag = 1;
			}
		}
		if (flag == 0)
			ans.add(-1);
		return ans;
	}
}
