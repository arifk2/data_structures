package com.rf.khan.api.iq.binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class AggressiveCows {
	public static void main(String[] args) {
		Integer[] inputArray = { 4, 2, 1, 3, 6 };

		ArrayList<Integer> inputList = (ArrayList<Integer>) Arrays.stream(inputArray).collect(Collectors.toList());
		int numberOfCow = 2;
		System.out.println(aggressiveCows(inputList, numberOfCow));
	}

	/**
	 * Binary Search Laga hua hai
	 * 
	 * @param stalls
	 * @param k
	 * @return
	 */
	public static int aggressiveCows(ArrayList<Integer> stalls, int k) {
		Collections.sort(stalls);
		int ans = -1;

		int start = 0;
		int maxi = -1;

		for (int i = 0; i < stalls.size(); i++) {
			maxi = Math.max(maxi, stalls.get(i));
		}
		int end = maxi;
		int mid = start + (end - start) / 2;

		while (start <= end) {
			if (isPossibleSolution(stalls, k, mid)) {
				// right me jao kyunki maximum chahiye
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = start + (end - start) / 2;
		}
		return ans;
	}

	private static boolean isPossibleSolution(ArrayList<Integer> stalls, int k, int mid) {
		int cowCount = 1;
		int lastPosition = stalls.get(0);

		for (int i = 0; i < stalls.size(); i++) {
			if ((stalls.get(i) - lastPosition) >= mid) {
				cowCount++;
				if (cowCount == k) {
					return true;
				}
				lastPosition = stalls.get(i);
			}
		}
		return false;
	}
}
