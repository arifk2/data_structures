package com.rf.khan.api.iq.dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumHeightStackingCuboids {

	/**
	 * Solving using dp and binary search tree with greedy approach
	 * 
	 * @param cuboids
	 * @return
	 */
	public int maxHeight(int[][] cuboids) {
		int n = cuboids.length;

		// Step 1: sort all dimension for every cuboid
		for (int[] arr : cuboids)
			Arrays.sort(arr);

		// Step 2: sort all dimension on the basis of widh or length
//		Arrays.sort(cuboids, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				if (o1[0] == o2[0])
//					return Integer.compare(o1[1], o2[1]);
//
//				return Integer.compare(o1[0], o2[0]);
//			}
//		});
		
		Arrays.sort(cuboids);

		// Step 3: use LIS logic
		return solveUsingTabulationOpt(cuboids, n);
	}

	private static int solveUsingTabulationOpt(int[][] a, int n) {

		int[] currRow = new int[n + 1];
		int[] nextRow = new int[n + 1];

		for (int current = n - 1; current >= 0; current--) {
			for (int previous = current - 1; previous >= -1; previous--) {

				// include
				int include = 0;

				// previous == -1 first element
				if (previous == -1 || check(a[current], a[previous]))
					include = a[current][2] + nextRow[current + 1];

				// exclude
				int exclude = 0 + nextRow[previous + 1];

				currRow[previous + 1] = Math.max(include, exclude);
			}
			nextRow = currRow;
		}

		return nextRow[0];
	}

	/**
	 * Condition give in question
	 * 
	 * @param oldBox
	 * @param newBox
	 * @return
	 */
	private static boolean check(int[] oldBox, int[] newBox) {
		if (newBox[0] <= oldBox[0] && newBox[1] <= oldBox[1] && newBox[2] <= oldBox[2])
			return true;

		return false;
	}

	public static void main(String[] args) {
		MaximumHeightStackingCuboids m = new MaximumHeightStackingCuboids();
		int[][] cuboids = { { 92, 47, 83 }, { 75, 20, 87 }, { 68, 12, 83 }, { 12, 85, 15 }, { 16, 24, 47 },
				{ 69, 65, 35 }, { 96, 56, 93 }, { 89, 93, 11 }, { 86, 20, 41 }, { 69, 77, 12 }, { 83, 80, 97 },
				{ 90, 22, 36 } };

		System.out.println(m.maxHeight(cuboids));
	}
}
