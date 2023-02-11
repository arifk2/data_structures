package com.rf.khan.api.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPULC1834 {

	public static void main(String[] args) {
		SingleThreadedCPULC1834 s = new SingleThreadedCPULC1834();
		int[][] tasks = { { 1, 2 }, { 2, 4 }, { 3, 2 }, { 4, 1 } };
		int[] ans = s.getOrder(tasks);

		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	public int[] getOrder(int[][] tasks) {
		// Step: create task enqueue time, processing time, index.
		int[][] sortedTasks = new int[tasks.length][3];
		for (int i = 0; i < tasks.length; i++) {
			sortedTasks[i][0] = tasks[i][0];
			sortedTasks[i][1] = tasks[i][1];
			sortedTasks[i][2] = i;
		}
		// Sort the array based on eq time and processing time and index
		Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));

		// Step: create min heap such based on processing time or min task index
		PriorityQueue<int[]> newTask = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
		int[] taskProcessingOrder = new int[tasks.length];
		long currTime = 0;
		int taskIndex = 0;
		int ansIndex = 0;

		// stop when no task in array and pq is empty
		while (taskIndex < tasks.length || !newTask.isEmpty()) {
			if (newTask.isEmpty() && currTime < sortedTasks[taskIndex][0]) {
				// when heap is empty try updating current time to next task time
				currTime = sortedTasks[taskIndex][0];
			}

			// put all the task whose currTIme is same or less than in pq
			while (taskIndex < tasks.length && currTime >= sortedTasks[taskIndex][0]) {
				newTask.add(sortedTasks[taskIndex]);
				taskIndex++;
			}
			int processTime = newTask.peek()[1];
			int index = newTask.peek()[2];
			newTask.remove();

			currTime += processTime;
			taskProcessingOrder[ansIndex++] = index;
		}
		return taskProcessingOrder;
	}
}
