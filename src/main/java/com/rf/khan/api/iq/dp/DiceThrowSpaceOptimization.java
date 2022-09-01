package com.rf.khan.api.iq.dp;

/**
 * This class is create to get the number of the distinct throw of dice to make
 * the target.
 * 
 * @author mkhan339
 *
 */
public class DiceThrowSpaceOptimization {

	static long noOfWays(int M, int N, int X) {

		return solveUsingSpaceOptimization(N, M, X);
	}

	/**
	 * Soling using recursion
	 * 
	 * @param d number of dices
	 * @param f number of faces
	 * @param t target value
	 * @return
	 */
	private static long solveUsingSpaceOptimization(int d, int f, int t) {

		long[] prev = new long[t + 1];
		long[] curr = new long[t + 1];

		// analyze base case
		prev[0] = 1;

		for (int dice = 1; dice <= d; dice++) {
			for (int target = 1; target <= t; target++) {
				long ans = 0;
				for (int i = 1; i <= f; i++) {
					if ((target - i) >= 0)
						ans = ans + prev[target - i];
				}
				curr[target] = ans;
			}
			prev = curr;
		}

		return prev[t];
	}

	/**
	 * Driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int M = 6, N = 3, X = 12;
		System.out.println(noOfWays(M, N, X));
	}
}

//******************************************************************
//class Solution {
//	  public:
//	    long long noOfWays(int M , int N , int X) {
//	       return solveUsingSpaceOptimization(N, M, X);
//	    }
//	    
//	    long long solveUsingSpaceOptimization(int d, int f, int t) {
//
//			vector<long long> prev (t + 1);
//			vector<long long> curr (t + 1);
//
//			// analyze base case
//			prev[0] = 1;
//
//			for (int dice = 1; dice <= d; dice++) {
//				for (int target = 1; target <= t; target++) {
//					long ans = 0;
//					for (int i = 1; i <= f; i++) {
//						if ((target - i) >= 0)
//							ans = ans + prev[target - i];
//					}
//					curr[target] = ans;
//				}
//				prev = curr;
//			}
//
//			return prev[t];
//		}
//	};
//******************************************************************