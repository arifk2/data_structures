package com.rf.khan.api.iq.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class RatMazeProblem {

	public static void main(String[] args) {
		int maze[][] = { { 1, 0, 0, 0 },
						{  1, 1, 0, 1 }, 
						{  1, 1, 0, 0 }, 
						{  0, 1, 1, 1 } };
		System.out.println(solveMaze(maze, maze.length));
	}

	private static ArrayList<String> solveMaze(int maze[][], int size) {
		ArrayList<String> ans = new ArrayList<>();
		//base condition no ans
		if (maze[0][0] == 0) {
			return ans;
		}

		int srcX = 0;
		int srcY = 0;

		// now create a visited array

		int[][] visitedArray = new int[maze.length][maze[0].length];
		// initializing with the 0 to the visited array

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				visitedArray[i][j] = 0;
			}
		}
		// printArray(visitedArray, visitedArray.length, visitedArray[0].length);
		String path = "";

		solve(maze, size, ans, srcX, srcY, visitedArray, path);
		Collections.sort(ans);

		return ans;
	}

	private static void solve(int[][] maze, int size, ArrayList<String> ans, int srcX, int srcY, int[][] visitedArray,
			String path) {

		// base case: reached to destination
		if (srcX == size - 1 && srcY == size - 1) {
			ans.add(new String(path));
			return;
		}
		// mark visited by 1
		visitedArray[srcX][srcY] = 1;

		// rat have 4 choices to move D, L, R, U

		// down
		int newSrcX = srcX + 1;
		int newSrcY = srcY;
		if (isSafeToMove(newSrcX, newSrcY, visitedArray, maze, size)) {
			path = path + "D";
			// recursive call
			solve(maze, size, ans, newSrcX, newSrcY, visitedArray, path);
			path = path.substring(0, path.length() - 1);
		}

		// left
		newSrcX = srcX;
		newSrcY = srcY - 1;
		if (isSafeToMove(newSrcX, newSrcY, visitedArray, maze, size)) {
			path = path + "L";
			// recursive call
			solve(maze, size, ans, newSrcX, newSrcY, visitedArray, path);
			path = path.substring(0, path.length() - 1);
		}

		// right
		newSrcX = srcX;
		newSrcY = srcY + 1;
		if (isSafeToMove(newSrcX, newSrcY, visitedArray, maze, size)) {
			path = path + "R";
			// recursive call
			solve(maze, size, ans, newSrcX, newSrcY, visitedArray, path);
			path = path.substring(0, path.length() - 1);
		}

		// up
		newSrcX = srcX - 1;
		newSrcY = srcY;
		if (isSafeToMove(newSrcX, newSrcY, visitedArray, maze, size)) {
			path = path + "U";
			// recursive call
			solve(maze, size, ans, newSrcX, newSrcY, visitedArray, path);
			path = path.substring(0, path.length() - 1);
		}

		// back tracking
		visitedArray[srcX][srcY] = 0;

	}

	private static boolean isSafeToMove(int newSrcX, int newSrcY, int[][] visitedArray, int[][] maze, int size) {
		if ((newSrcX >= 0 && newSrcX < size) && (newSrcY >= 0 && newSrcY < size)
				&& (visitedArray[newSrcX][newSrcY] == 0) && (maze[newSrcX][newSrcY] == 1)) {
			return true;
		}
		return false;
	}

	public static void printArray(int[][] arr, int row, int col) {
		System.out.println("********Printing 2D array********");
		int i = 0, j = 0;
		for (i = 0; i < row; i++) {
			for (j = 0; j < col; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("********Printing 2D array********");
	}
}
