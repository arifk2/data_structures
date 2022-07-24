package com.rf.khan.api.iq.array;

public class FindUnique {
	public static void main(String[] args) {
		int[] inputArray = { 1, 3, 5, 1, 3, 5, 6 };
		int ans = 0;
		for (int i = 0; i < inputArray.length; i++) {
			ans = ans ^ inputArray[i];
		}
		System.out.println(ans);
	}

}
