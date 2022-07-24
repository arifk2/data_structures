package com.rf.khan.api.iq.array;

import java.util.ArrayList;

public class TripletsArray {
	public static void main(String[] args) {

		int input[] = { -10, 5, 5, -5, 2 };
		findTriplets(input, input.length);
		System.out.println(findTripletsT(input, input.length));

	}

	public static void findTriplets(int[] arr, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (arr[i] + arr[j] + arr[k] == 0) {
						System.out.println(arr[i] + ", " + arr[j] + ", " + arr[k]);
					}
				}
			}
		}
	}
	
	
	public static ArrayList<ArrayList<Integer>> findTripletsT(int[] arr, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	      for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[k]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
	}
}
