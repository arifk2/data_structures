package com.rf.khan.api.iq.dp;

import java.util.Arrays;

public class ReducingDishesSpaceOptimization {

	/**
	 * Solving using tabulation
	 * 
	 * @param satisfaction
	 * @return
	 */
	public int maxSatisfaction(int[] satisfaction) {

		return solveUsingOptimizaion(satisfaction);
	}

	public int maxSatisfactionOO(int[] A) {
		java.util.Arrays.sort(A);
		int res = 0, total = 0, n = A.length;
		for (int i = n - 1; i >= 0 && A[i] > -total; --i) {
			total += A[i];
			res += total;
		}
		return res;
	}

	// Greedy
	/**
	 * Solving by greedy approach o(1)
	 * 
	 * @param satisfaction
	 * @return
	 */
	int maxSatisfactionGreedy(int[] satisfaction) {
		Arrays.sort(satisfaction);
		int ans = 0;
		for (int i = 0; i < satisfaction.length; i++) {
			int sum = 0;
			int time = 1;
			for (int j = i; j < satisfaction.length; j++) {
				sum += satisfaction[j] * time;
				time++;
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}

	/**
	 * Solving using tabulation
	 * 
	 * @param satisfaction
	 * @param index
	 * @param time
	 * @return
	 */
	private int solveUsingOptimizaion(int[] satisfaction) {
		int n = satisfaction.length;

		int[] curr = new int[n + 1];
		int[] next = new int[n + 1];

		for (int index = n - 1; index >= 0; index--) {
			for (int time = index; time >= 0; time--) {
				int include = (satisfaction[index]) * (time + 1) + next[time + 1];
				int exclude = 0 + next[time];

				curr[time] = Math.max(include, exclude);
			}
			next = curr;
		}
		return next[0];
	}

	public static void main(String[] args) {
		int[] satisfaction = { -1, -8, 0, 5, -7 };
		Arrays.sort(satisfaction);
		ReducingDishesSpaceOptimization r = new ReducingDishesSpaceOptimization();
		System.out.println(r.maxSatisfaction(satisfaction));
		// System.out.println(r.maxSatisfactionGreedy(satisfaction));
	}

//	*********************************************************
//	class Solution {
//		public:
//		    int maxSatisfaction(vector<int>& satisfaction) {
//		        sort(satisfaction.begin(), satisfaction.end());
//		        return solveOptOn(satisfaction);
//		    }
//		    
//		    
//		    int solveOptOn(vector<int> satisfaction) {
//				int n = satisfaction.size();
//
//				vector<int> curr (n + 1, 0);
//				vector<int> next (n + 1, 0);
//
//				for (int index = n - 1; index >= 0; index--) {
//					for (int time = index; time >= 0; time--) {
//						int include = satisfaction[index] * (time + 1) + next[time + 1];
//						int exclude = 0 + next[time];
//
//						curr[time] = max(include, exclude);
//					}
//					next = curr;
//				}
//				return next[0];
//			}
//		};
//		*********************************************************
}
