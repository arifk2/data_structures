package com.rf.khan.api.iq.gfg.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicateInArray {

	public static void main(String[] args) {
		System.out.println(duplicates(new int[] { 3, 4, 12, 3, 12, 3, 4, 4, 12, 7, 11, 6, 5 }, 13));
		System.out.println(duplicates(new int[] { 2, 4, 3, 0, 4 }, 5));
		System.out.println(duplicatesZ(new int[] { 2, 4, 3, 0, 4 }, 5));
		System.out.println(duplicatesZ(new int[] { 3, 4, 12, 3, 12, 3, 4, 4, 12, 7, 11, 6, 5 }, 13));
	}

	public static ArrayList<Integer> duplicatesL(int arr[], int n) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			if (!set.add(arr[i]) && !ans.contains(arr[i])) {
				ans.add(arr[i]);
			}
		}

		if (ans.size() == 0)
			ans.add(-1);

		Collections.sort(ans);
		return ans;
	}

	public static ArrayList<Integer> duplicates(int arr[], int n) {
		// First check all the values that are
		// present in an array then go to that
		// values as indexes and increment by
		// the size of array

		for (int i = 0; i < n; i++) {
			int index = arr[i] % n;
			arr[index] += n;
		}

		// Now check which value exists more
		// than once by dividing with the size
		// of array
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int flag = 0;
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

	public static ArrayList<Integer> duplicatesZ(int arr[], int n) {
		int[] freq = new int[n];

		for (int i = 0; i < n; i++) {
			freq[arr[i]] += 1;
		}

		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (freq[i] > 1)
				ans.add(i);
		}
		return ans;

	}
}
