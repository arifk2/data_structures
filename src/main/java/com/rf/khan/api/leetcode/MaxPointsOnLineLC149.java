package com.rf.khan.api.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLineLC149 {
	public static void main(String[] args) {
		int[][] points = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
		MaxPointsOnLineLC149 m = new MaxPointsOnLineLC149();
		System.out.println(m.maxPoints(points));
		System.out.println(m.maxPoints(new int[][] { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } }));
	}

	public int maxPoints(int[][] points) {
		// base case
		if (points.length <= 0)
			return 0;
		if (points.length <= 2)
			return points.length;

		int max = 0;

		for (int[] point1 : points) {
			// <Slope, count>
			Map<Double, Integer> map = new HashMap<>();
			for (int[] point2 : points) {
				if (point1 == point2)
					continue;

				double slope = 0;
				// if x1 and x2 are equal then they are vertical
				if (point2[0] == point1[0])
					slope = Double.POSITIVE_INFINITY;
				else {
					// s = (y2 - y1) / (x2 - x1)
					slope = (point2[1] - point1[1]) / (double) (point2[0] - point1[0]);
				}
				map.put(slope, map.getOrDefault(slope, 0) + 1);

				// update max value
				max = Math.max(max, map.get(slope));
//				if (map.get(slope) > max) {
//					max = map.get(slope);
//				}
			}
		}
		return max + 1;
	}
}
