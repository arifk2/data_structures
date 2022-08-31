package com.rf.khan.api.iq.dp;

/**
 * 
 * @author mkhan339
 *
 */
public class PizzaWithNSlicesSpaceOpt {

	/**
	 * Solving using recursion
	 * 
	 * @param slices
	 * @return
	 */
	public int maxSizeSlices(int[] slices) {
		return solveUsingSpaceOpt(slices);
	}

	/**
	 * Solving using Tabulation
	 * 
	 * @param slices
	 * @return
	 */
	private int solveUsingSpaceOpt(int[] slices) {
		int k = slices.length;

		int[] prev1 = new int[k + 1];
		int[] curr1 = new int[k + 1];
		int[] next1 = new int[k + 1];

		int[] prev2 = new int[k + 1];
		int[] curr2 = new int[k + 1];
		int[] next2 = new int[k + 1];

		for (int index = k - 2; index >= 0; index--) {
			for (int n = 1; n <= k / 3; n++) {

				int take = slices[index] + next1[n - 1];
				int nottake = 0 + curr1[n];

				prev1[n] = Math.max(take, nottake);

			}
			next1 = curr1;
			curr1 = prev1;
		}

		int case1 = curr1[k / 3];

		for (int index = k - 1; index >= 1; index--) {
			for (int n = 1; n <= k / 3; n++) {

				int take = slices[index] + next2[n - 1];
				int nottake = 0 + curr2[n];

				prev2[n] = Math.max(take, nottake);
			}

			next2 = curr2;
			curr2 = prev2;
		}

		int case2 = curr2[k / 3];

		return Math.max(case1, case2);
	}

	/**
	 * This is a main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] slices = { 8, 9, 8, 6, 1, 1 };
		PizzaWithNSlicesSpaceOpt p = new PizzaWithNSlicesSpaceOpt();
		System.out.println(p.maxSizeSlices(slices));

	}
}

//**************************************
//*********IN C++***********************
//class Solution {
//public:
//    int maxSizeSlices(vector<int>& slices) {
//        return solveTabulation(slices);
//    }
//    
//      int solveTabulation(vector<int>& slices){
//       	int k = slices.size();
//
//		vector<int> prev1(k+1, 0);
//		vector<int> curr1(k+1, 0);
//		vector<int> next1(k+1, 0);
//
//		vector<int> prev2(k+1, 0);
//		vector<int> curr2(k+1, 0);
//		vector<int> next2(k+1, 0);
//
//		for (int index = k - 2; index >= 0; index--) {
//			for (int n = 1; n <= k / 3; n++) {
//
//				int take = slices[index] + next1[n - 1];
//				int nottake = 0 + curr1[n];
//
//				prev1[n] = max(take, nottake);
//
//			}
//			next1 = curr1;
//			curr1 = prev1;
//		}
//
//		int case1 = curr1[k / 3];
//
//		for (int index = k - 1; index >= 1; index--) {
//			for (int n = 1; n <= k / 3; n++) {
//
//				int take = slices[index] + next2[n - 1];
//				int nottake = 0 + curr2[n];
//
//				prev2[n] = max(take, nottake);
//			}
//
//			next2 = curr2;
//			curr2 = prev2;
//		}
//
//		int case2 = curr2[k / 3];
//
//		return max(case1, case2);
//    }
//};
//******************************************
