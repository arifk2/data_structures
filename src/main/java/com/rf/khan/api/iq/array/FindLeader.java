package com.rf.khan.api.iq.array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a program to print all the LEADERS in the array. An element is a leader
 * if it is greater than all the elements to its right side. And the rightmost
 * element is always a leader.
 * 
 * For example:
 * 
 * Input: arr[] = {16, 17, 4, 3, 5, 2}, Output: 17, 5, 2
 * 
 * Input: arr[] = {1, 2, 3, 4, 5, 2},  Output: 5, 2
 */

public class FindLeader {

	public static void main(String[] args) {
//		int arr[] = { 16, 17, 4, 3, 5, 2 };
		int arr[] = { 31, 40, 93, 40, 98 };
		ArrayList<Integer> leaderList = new ArrayList<Integer>();

		int size = arr.length;

		// Step 1: define the leader;
		int leader = arr[size - 1];

		// step 2: store leader
		leaderList.add(leader);

		// step 3: starting loop from last -1, because already include last as a leader
		for (int i = size - 2; i >= 0; i--) {
			if (leader <= arr[i]) {
				leader = arr[i];
				leaderList.add(arr[i]);
			}
		}
		Collections.reverse(leaderList);
		System.out.println(leaderList);
	}
}
