package com.rf.khan.api.iq.binary.search;

public class FirstAndLastOccuranceBS {
	public static void main(String[] args) {
		int[] inputArray = { 8, 9, 9, 10, 10 };
		int key = 9;

		System.out.println("First Occurance is: " + findFirstOccuranceNum(inputArray, key));
		System.out.println("Last Occurannce is: " + findLastOccuranceNum(inputArray, key));

		int totalNumberOfOccurance = (findLastOccuranceNum(inputArray, key) - findFirstOccuranceNum(inputArray, key))
				+ 1;
		System.out.println("Occurance of the given number is : " + totalNumberOfOccurance);
	}

	public static int findFirstOccuranceNum(int[] inputArray, int key) {
		int startIndex = 0;
		int endIndex = inputArray.length - 1;
		int midIndex = startIndex + (endIndex - startIndex) / 2;
		int ans = -1;
		while (startIndex <= endIndex) {
			if (inputArray[midIndex] == key) {
				ans = midIndex;
				endIndex = midIndex - 1;
			} else if (key > inputArray[midIndex]) { // right me jao
				startIndex = midIndex + 1;
			} else if (key < inputArray[midIndex]) { // left me jao
				endIndex = midIndex - 1;
			}
			midIndex = startIndex + (endIndex - startIndex) / 2;
		}
		return ans;
	}

	public static int findLastOccuranceNum(int[] inputArray, int key) {
		int startIndex = 0;
		int endIndex = inputArray.length - 1;
		int midIndex = startIndex + (endIndex - startIndex) / 2;
		int ans = -1;
		while (startIndex <= endIndex) {
			if (inputArray[midIndex] == key) {
				ans = midIndex;
				startIndex = midIndex + 1;
			} else if (key > inputArray[midIndex]) { // right me jao
				startIndex = midIndex + 1;
			} else if (key < inputArray[midIndex]) { // left me jao
				endIndex = midIndex - 1;
			}
			midIndex = startIndex + (endIndex - startIndex) / 2;
		}
		return ans;
	}
}