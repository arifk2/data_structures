package com.rf.khan.api.iq.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Chocolate distribution problem
 * 
 * @author mkhan339
 *
 */
public class ChocolateDistributionProblem {

	/**
	 * This method is created to find the min in the given window
	 * 
	 * @param a holds the information of the number of chocolates in the packet
	 * @param n holds the information of the size of the array
	 * @param m number of students
	 * @return min
	 */
	public long findMinDiff(ArrayList<Integer> a, int n, int m) {
		int i = 0;
		int j = m - 1;
		int ans = Integer.MAX_VALUE;

		// sort: to ensure that in each window i = smaller and j is larger
		Collections.sort(a);

		while (j < n) {
			int diff = a.get(j) - a.get(i);
			ans = Math.min(ans, diff);

			i++;
			j++;
		}

		return ans;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ChocolateDistributionProblem c = new ChocolateDistributionProblem();
		int N = 8, M = 5;
		Integer[] A = { 3, 4, 1, 9, 56, 7, 9, 12 };
		ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(A));

		System.out.println(c.findMinDiff(al, N, M));
	}
}
