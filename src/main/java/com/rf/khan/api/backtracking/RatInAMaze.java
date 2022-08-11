package com.rf.khan.api.backtracking;

import java.util.ArrayList;

public class RatInAMaze {
	public static ArrayList<String> searchMaze(int[][] arr, int n) {
		ArrayList<String> ans = new ArrayList<>();
		boolean[][] visited = new boolean[n][n];
		String path = "";
		if (arr[0][0] == 0) {
			return ans;
		}

		solve(0, 0, n, ans, arr, visited, path);

		return ans;
	}

	private static void solve(int x, int y, int n, ArrayList<String> ans, int[][] arr, boolean[][] visited,
			String path) {
		// base case: reached destination
		if (x == n - 1 && y == n - 1) {
			ans.add(new String(path));
			return;
		}

		// movement D, L, R, U

		// down
		if (isSafe(x + 1, y, n, visited, arr)) {
			visited[x][y] = true;
			solve(x + 1, y, n, ans, arr, visited, path + "D");
			visited[x][y] = false;
		}

		// left
		if (isSafe(x, y - 1, n, visited, arr)) {
			visited[x][y] = true;
			solve(x, y - 1, n, ans, arr, visited, path + "L");
			visited[x][y] = false;
		}

		// right
		if (isSafe(x, y + 1, n, visited, arr)) {
			visited[x][y] = true;
			solve(x, y + 1, n, ans, arr, visited, path + "R");
			visited[x][y] = false;
		}

		// up
		if (isSafe(x - 1, y, n, visited, arr)) {
			visited[x][y] = true;
			solve(x - 1, y, n, ans, arr, visited, path + "U");
			visited[x][y] = false;
		}

	}

	private static boolean isSafe(int newX, int newY, int n, boolean[][] visited, int[][] arr) {
		if ((newX >= 0 && newX < n) && (newY >= 0 && newY < n) && visited[newX][newY] == false
				&& arr[newX][newY] == 1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 0, 0, 0 }, { 1, 1, 0, 0 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };

		System.out.println(searchMaze(arr, 4));

	}
}
