package com.rf.khan.api.iq.dp;

public class PartitionEqualSubsetSumSpaceOptmization {

	static int equalPartition(int N, int arr[]) {
		int total = 0;
		for (int i = 0; i < N; i++) {
			total += arr[i];
		}
		if (total % 2 != 0)
			return 0;

		if (solveRecursionSpaceOptimization(N, arr, total))
			return 1;

		return 0;
	}

	/**
	 * Solving using tabulation
	 * 
	 * @param n     size of array
	 * @param arr   array information
	 * @param total total sum in the array
	 * @return
	 */
	static boolean solveRecursionSpaceOptimization(int n, int[] arr, int total) {

		boolean[] curr = new boolean[total + 1];
		boolean[] next = new boolean[total + 1];

		curr[0] = true;
		next[0] = true;

		for (int index = n - 1; index >= 0; index--) {
			for (int target = 0; target <= total / 2; target++) {

				boolean include = false;
				if (target - arr[index] >= 0)
					include = next[target - arr[index]];

				boolean exclude = next[target];

				curr[target] = include || exclude;
			}
			next = curr;
		}
		return next[total / 2];
	}

	/**
	 * This is driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 4;
		int[] arr = { 1, 5, 11, 5 };

		int N1 = 3;
		int[] arr1 = { 1, 3, 5 };

		int N2 = 8;
		int[] arr2 = { 478, 757, 314, 471, 729, 100, 459, 618 };

		System.out.println(equalPartition(N, arr));
		System.out.println(equalPartition(N1, arr1));
		System.out.println(equalPartition(N2, arr2));
	}
}

//****************IN C++**************************
//************************************************
////{ Driver Code Starts
////Initial Template for C++
//
//#include <bits/stdc++.h>
//using namespace std;
//
////} Driver Code Ends
////User function Template for C++
//
//class Solution{
//public:
// int equalPartition(int N, int arr[])
// {
//  	int total = 0;
//		for (int i = 0; i < N; i++) {
//			total += arr[i];
//		}
//		if (total % 2 != 0)
//			return 0;
//
//		return solveRecursionSpaceOptimization(N, arr, total);
//	}
//
// bool solveRecursionSpaceOptimization(int n, int arr [], int total) {
//
//		vector<int> curr (total/2 + 1, 0);
//	    vector<int> next (total/2 + 1, 0);
//
//		curr[0] = 1;
//		next[0] = 1;
//
//		for (int index = n - 1; index >= 0; index--) {
//			for (int target = 0; target <= total / 2; target++) {
//
//				bool include = 0;
//				if (target - arr[index] >= 0)
//					include = next[target - arr[index]];
//
//				bool exclude = next[target];
//
//				curr[target] = include || exclude;
//			}
//			next = curr;
//		}
//		return next[total / 2];
//	}
// 
// 
//};
//
////{ Driver Code Starts.
//
//int main(){
// int t;
// cin>>t;
// while(t--){
//     int N;
//     cin>>N;
//     int arr[N];
//     for(int i = 0;i < N;i++)
//         cin>>arr[i];
//     
//     Solution ob;
//     if(ob.equalPartition(N, arr))
//         cout<<"YES\n";
//     else
//         cout<<"NO\n";
// }
// return 0;
//}
////} Driver Code Ends
