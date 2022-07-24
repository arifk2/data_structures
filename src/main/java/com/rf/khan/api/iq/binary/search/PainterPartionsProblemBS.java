package com.rf.khan.api.iq.binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class PainterPartionsProblemBS {
	public static void main(String[] args) {
		Integer[] inputArray = { 1, 5, 7, 1, 6, 2, 5, 7, 6, 8, 1, 2, 3, 2, 4, 6, 7, 6, 5, 0 };
		ArrayList<Integer> inputArrayList = (ArrayList<Integer>) Arrays.stream(inputArray).collect(Collectors.toList());
		int numberOfPainters = 4;
		int result = findLargestMinDistance(inputArrayList, numberOfPainters);
		System.out.println("Answer is: " + result);
	}

	public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
		Collections.sort(boards);
		int ans = -1;
		int start = 0;
		int end = 0;
		for (int i = 0; i < boards.size(); i++) {
			end += boards.get(i);
		}
		int mid = start + (end - start) / 2;

		while (start <= end) {
			if (isPossibleSolution(boards, boards.size(), k, mid)) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			mid = start + (end - start) / 2;
		}
		return ans;
	}

	private static boolean isPossibleSolution(ArrayList<Integer> boards, int size, int k, int mid) {
		int painterCount = 1;
		int boardPartion = 0;
		for (int i = 0; i < size; i++) {
			if (boardPartion + boards.get(i) <= mid) {
				boardPartion += boards.get(i);
			} else {
				painterCount++;
				if (painterCount > k || boards.get(i) > mid) {
					return false;
				}
				boardPartion = boards.get(i);
			}
		}
		return true;
	}
}
