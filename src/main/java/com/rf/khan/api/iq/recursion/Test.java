package com.rf.khan.api.iq.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		System.out.println(solveMaze(maze, maze.length));
	}

	private static ArrayList<String> solveMaze(int[][] maze, int size) {
		ArrayList<String> ans = new ArrayList<>();

		if (maze[0][0] == 0) {
			return ans;
		}

		int srcX = 0;
		int srcY = 0;

		// create a visited array of the same size and insert the value as zero
		int[][] visitedArray = new int[size][maze[0].length];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				visitedArray[i][j] = 0;
			}
		}

		String path = "";
		solve(maze, size, ans, visitedArray, srcX, srcY, path);
		Collections.sort(ans);

		return ans;
	}

	private static void solve(int[][] maze, int size, ArrayList<String> ans, int[][] visitedArray, int srcX, int srcY,
			String path) {
		// base case: reached at destination
		if (srcX == size - 1 && srcY == size - 1) {
			ans.add(new String(path));
			return;
		}

		// reached at destination
		visitedArray[srcX][srcY] = 1;

		// rat has 4 choice to move
		// down
		int newSrcX = srcX + 1;
		int newSrcY = srcY;
		if (safeCheckMove(maze, size, visitedArray, newSrcX, newSrcY)) {
			path = path + "D";
			solve(maze, size, ans, visitedArray, newSrcX, newSrcY, path);
			path = path.substring(0, path.length() - 1);
		}

		// left
		newSrcX = srcX;
		newSrcY = srcY - 1;
		if (safeCheckMove(maze, size, visitedArray, newSrcX, newSrcY)) {
			path = path + "L";
			solve(maze, size, ans, visitedArray, newSrcX, newSrcY, path);
			path = path.substring(0, path.length() - 1);
		}

		// right
		newSrcX = srcX;
		newSrcY = srcY + 1;
		if (safeCheckMove(maze, size, visitedArray, newSrcX, newSrcY)) {
			path = path + "R";
			solve(maze, size, ans, visitedArray, newSrcX, newSrcY, path);
			path = path.substring(0, path.length() - 1);
		}

		// up
		newSrcX = srcX - 1;
		newSrcY = srcY;
		if (safeCheckMove(maze, size, visitedArray, newSrcX, newSrcY)) {
			path = path + "U";
			solve(maze, size, ans, visitedArray, newSrcX, newSrcY, path);
			path = path.substring(0, path.length() - 1);
		}
		visitedArray[srcX][srcY] = 0;
	}

	private static boolean safeCheckMove(int[][] maze, int size, int[][] visitedArray, int newSrcX, int newSrcY) {
		if ((newSrcX >= 0 && newSrcX < size) && (newSrcY >= 0 && newSrcY < size) && maze[newSrcX][newSrcY] == 1
				&& visitedArray[newSrcX][newSrcY] == 0) {
			return true;
		}
		return false;
	}

}
