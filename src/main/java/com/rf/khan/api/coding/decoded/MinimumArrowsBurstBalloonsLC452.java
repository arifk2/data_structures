package com.rf.khan.api.coding.decoded;

import java.util.Arrays;

public class MinimumArrowsBurstBalloonsLC452 {

	public static void main(String[] args) {
		MinimumArrowsBurstBalloonsLC452 m = new MinimumArrowsBurstBalloonsLC452();
		System.out.println(m.findMinArrowShots(new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } }));
	}

	public int findMinArrowShots(int[][] points) {
		//Arrays.sort(points, (a, b) -> a[1] - b[1]);
		Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
		
		int arrow = 1;
		int reach = points[0][1];

		for (int i = 1; i < points.length; i++) {
			if (points[i][0] > reach) {
				arrow++;
				reach = points[i][1];
			}
		}
		return arrow;
	}
}
