package com.rf.khan.api.gg.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * https://www.geeksforgeeks.org/k-maximum-sum-combinations-two-arrays/
 * 
 * * TC O(NlogN)
 * 
 * * SC O(n)
 * 
 * @author mkhan339
 *
 */

public class KMaxCombinationsOpt {

	/**
	 * Pair class
	 * 
	 * @author mkhan339
	 *
	 */
	static class Pair {
		int l;
		int m;

		public Pair(int l, int m) {
			this.l = l;
			this.m = m;
		}

		@Override
		public int hashCode() {
			return Objects.hash(l, m);
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
			return l == other.l && m == other.m;
		}

	}

	/**
	 * Pair Sum class
	 * 
	 * @author mkhan339
	 *
	 */
	static class PairSum implements Comparable<PairSum> {

		int l;
		int m;
		int sum;

		public PairSum(int l, int m, int sum) {
			this.l = l;
			this.m = m;
			this.sum = sum;
		}

		@Override
		public int compareTo(PairSum o) {

			return Integer.compare(o.sum, sum);
		}

	}

	/**
	 * Optimized: assuming k<=n
	 * 
	 * @param arrayA
	 * @param arrayB
	 * @param n
	 * @param K
	 */
	static void KMaxCombinations(int arrayA[], int arrayB[], int n, int k) {
		// sort both the arrays
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);

		PriorityQueue<PairSum> sums = new PriorityQueue<PairSum>();

		HashSet<Pair> pairs = new HashSet<>();

		int l = n - 1;
		int m = n - 1;

		pairs.add(new Pair(l, m));
		sums.add(new PairSum(l, m, arrayA[l] + arrayB[m]));

		// iterate upto k
		for (int i = 0; i < k; i++) {
			PairSum max = sums.poll();
			System.out.println(max.sum);

			// assuming l arrayB last element is greater than arrrayA
			l = max.l - 1;
			m = max.m;

			// insert only if the l and m is greater than zero and pair is not present
			if (l >= 0 && m >= 0 && !pairs.contains(new Pair(l, m))) {
				sums.add(new PairSum(l, m, arrayA[l] + arrayB[m]));
				pairs.add(new Pair(l, m));
			}

			// assuming l arrayA last element is greater than arrrayB
			l = max.l;
			m = max.m - 1;

			// insert only if the l and m is greater than zero and pair is not present
			if (l >= 0 && m >= 0 && !pairs.contains(new Pair(l, m))) {
				sums.add(new PairSum(l, m, arrayA[l] + arrayB[m]));
				pairs.add(new Pair(l, m));
			}
		}

	}

	/**
	 * This is a driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int arrayA[] = { 4, 2, 5, 1 };
		int arrayB[] = { 8, 0, 5, 3 };
		int n = arrayA.length;
		int K = 3;

		// Function Call
		KMaxCombinations(arrayA, arrayB, n, K);
	}
}
