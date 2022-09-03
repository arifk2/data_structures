package com.rf.khan.api.iq.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic Programming + Hashing
 * 
 * @author mkhan339
 *
 */
public class LongestArthemeticSequenceTabulation {

	int lengthOfLongestAP(int[] A, int n) {
		if (n <= 2)
			return n;

		int answer = 0;
		Map<Integer, Integer> dp = new HashMap<>(n + 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int diff = A[i] - A[j];
				int count = 1;

				// check if the answer is already present
				if (dp.containsKey(j) && dp.get(j) == diff)
					count = dp.get(j) + 1;

				dp.put(i, 1 + count);
				answer = Math.max(answer, dp.get(i));
			}
		}

		return answer;
	}

	/**
	 * This is driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 3, 6, 7, 12, 16, 17, 20, 21, 22, 24, 27, 30, 35, 40, 42, 46, 48, 52, 54, 56, 58 };
		int n = arr.length;

		LongestArthemeticSequenceTabulation l = new LongestArthemeticSequenceTabulation();
		System.out.println(l.lengthOfLongestAP(arr, n));
	}
}

//*************************C++******************************
//**********************************************************
//class Solution{   
//	public:
//	    int lengthOfLongestAP(int A[], int n) {
//	    if (n <= 2)
//				return n;
//
//			int answer = 0;
//		    unordered_map<int,int> dp[n + 1];
//
//			for (int i = 1; i < n; i++) {
//				for (int j = 0; j < i; j++) {
//				    
//					int diff = A[i] - A[j];
//					int count = 1;
//
//					// check if the answer is already present
//					if (dp[j].count(diff))
//						count = dp[j][diff];
//
//					dp[i][diff] = 1 + count;
//					
//					answer = max(answer, dp[i][diff]);
//				}
//			}
//
//			return answer;
//	    }
//	};
//	
//**********************************************************