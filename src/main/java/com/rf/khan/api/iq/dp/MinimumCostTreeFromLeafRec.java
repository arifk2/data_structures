package com.rf.khan.api.iq.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Pair {
	private int first;
	private int secoond;

	public Pair(int first, int secoond) {
		this.first = first;
		this.secoond = secoond;
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, secoond);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		return first == other.first && secoond == other.secoond;
	}

	@Override
	public String toString() {
		return "Range [start=" + first + ", end=" + secoond + "]";
	}

}

public class MinimumCostTreeFromLeafRec {

	/**
	 * This method is created to get the minimum cost from the leaf value
	 * 
	 * @param arr
	 * @return
	 */
	public int mctFromLeafValues(int[] arr) {
		Map<Pair, Integer> maxiInRange = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			maxiInRange.put(new Pair(i, i), arr[i]);

			for (int j = i + 1; j < arr.length; j++) {
				maxiInRange.put(new Pair(i, j), Math.max(arr[j], maxiInRange.get(new Pair(i, j - 1))));
			}
		}

//		for (Map.Entry<Pair, Integer> map : maxiInRange.entrySet()) {
//			System.out.println(map.getKey() + " --> " + map.getValue());
//		}

		return solveRecursion(arr, maxiInRange, 0, arr.length - 1);
	}

	/**
	 * This method is created to solve the problem using recursion
	 * 
	 * @param arr         holds the information of the array
	 * @param maxiInRange holds the information of the max number within the range
	 * @param left        holds the information of the left index
	 * @param right       holds the information of the right index
	 * @return
	 */
	private int solveRecursion(int[] arr, Map<Pair, Integer> maxiInRange, int left, int right) {
		if (left == right)
			return 0;

		int ans = Integer.MAX_VALUE;
		for (int i = left; i < right; i++) {
			int temp = maxiInRange.get(new Pair(left, i)) * maxiInRange.get(new Pair(i + 1, right));

			ans = Math.min(ans,
					temp + solveRecursion(arr, maxiInRange, left, i) + solveRecursion(arr, maxiInRange, i + 1, right));
		}

		return ans;
	}

	/**
	 * Driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumCostTreeFromLeafRec m = new MinimumCostTreeFromLeafRec();
		int arr[] = { 6, 2, 4 };

		System.out.println(m.mctFromLeafValues(arr));
	}
}
