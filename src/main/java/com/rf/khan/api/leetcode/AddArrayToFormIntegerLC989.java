package com.rf.khan.api.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddArrayToFormIntegerLC989 {
	public static void main(String[] args) {
		AddArrayToFormIntegerLC989 a = new AddArrayToFormIntegerLC989();
		System.out.println(a.addToArrayForm(new int[] { 1, 0 }, 5));
		System.out.println(a.addToArrayForm(new int[] { 1, 2, 0, 0 }, 34));
		System.out.println(a.addToArrayForm(new int[] { 2, 7, 4 }, 181));
		System.out.println(a.addToArrayForm(new int[] { 2, 1, 5 }, 806));
		System.out.println(a.addToArrayForm(new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 }, 1));
		System.out
				.println(a.addToArrayForm(new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 1));
	}

	public List<Integer> addToArrayForm(int[] num, int k) {
		int n = num.length;
		int curr = k;
		List<Integer> ans = new ArrayList<>();
		int index = n;
		while (--index >= 0 || curr > 0) {
			if (index >= 0) {
				curr += num[index];
			}
			ans.add(curr % 10);
			curr /= 10;
		}
		Collections.reverse(ans);
		return ans;
	}

}
