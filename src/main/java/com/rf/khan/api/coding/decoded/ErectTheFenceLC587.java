package com.rf.khan.api.coding.decoded;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class ErectTheFenceLC587 {
	private class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int[][] outerTrees(int[][] trees) {
		List<Point> points = new ArrayList<>();

		for (int[] point : trees) {
			points.add(new Point(point[0], point[1]));
		}

		List<Point> res = new ArrayList<>();
		if (points.size() == 1) {
			return trees;
		}

		int n = points.size();
		Collections.sort(points, (a, b) -> a.y == b.y ? a.x - b.x : a.y - b.y);
		HashSet<ArrayList<Integer>> dup = new HashSet<>();

		Stack<Point> hull = new Stack<>();
		hull.push(points.get(0));
		hull.push(points.get(1));

		// lower hull
		for (int i = 2; i < n; i++) {
			Point top = hull.pop();
			while (!hull.isEmpty() && ccw(hull.peek(), top, points.get(i)) < 0) {
				top = hull.pop();
			}
			hull.push(top);
			hull.push(points.get(i));
		}

		// upper hull
		for (int i = n - 2; i >= 0; i--) {
			Point top = hull.pop();
			while (!hull.isEmpty() && ccw(hull.peek(), top, points.get(i)) < 0) {
				top = hull.pop();
			}
			hull.push(top);
			hull.push(points.get(i));
		}

		for (Point x : hull) {
			ArrayList<Integer> tmp = new ArrayList<>();
			tmp.add(x.x);
			tmp.add(x.y);

			if (dup.contains(tmp))
				continue;
			dup.add(tmp);
			res.add(x);
		}

		int[][] ans = new int[res.size()][2];
		int i = 0;
		for (Point p : res) {
			ans[i][0] = p.x;
			ans[i][1] = p.y;
			i++;
		}
		return ans;
	}

	private int ccw(Point a, Point b, Point c) {
		double crossProduct = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
		if (crossProduct < 0)
			return -1;
		else if (crossProduct > 0)
			return +1;
		else
			return 0;
	}

}
