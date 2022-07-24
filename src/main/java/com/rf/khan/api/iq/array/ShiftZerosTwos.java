package com.rf.khan.api.iq.array;

/**
 * Two pointer approach
 * 
 * @author mkhan339
 *
 */
public class ShiftZerosTwos {

	public static void main(String[] args) {
		int[] inputArray = { 1, 1, 0, 1, 0, 1, 1 };
		shiftZerosTwos(inputArray);
	}

	public static void shiftZerosTwos(int[] inputArray) {
		int start = 0, end = inputArray.length - 1;
		while (start < end) {
			while (inputArray[start] == 0) {
				start++;
			}
			while (inputArray[end] == 1) {
				end--;
			}

			// inputArray[start] == 1 and inputArray[end] == 0
			// swap both and increase start and decrease end
			if (start < end) {
				int temp = inputArray[start];
				inputArray[start] = inputArray[end];
				inputArray[end] = temp;
			}
		}

		printArray(inputArray);
	}

	public static void printArray(int[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + ", ");
		}
	}
}
