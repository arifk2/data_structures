package com.rf.khan.api.iq.array.ques;

public class Rotate2DArray {

	public void rotateArray(int[][] arr) {

		transposeArray(arr);
		reverseArray(arr);
	}

	/**
	 * This method is created to transpose the array
	 * 
	 * @param arr holds the information of the array
	 */
	private void transposeArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr[0].length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}

	/**
	 * This method is created to reverse the array
	 * 
	 * @param arr holds the information of the array
	 */
	private void reverseArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][arr.length - 1];
				arr[i][arr.length - 1] = temp;
			}
		}
	}

	/**
	 * This method is created to print the array
	 * 
	 * @param arr
	 */
	private void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * main driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		Rotate2DArray rotate2dArray = new Rotate2DArray();

		System.out.println("Input Array:" + "\n");
		rotate2dArray.printArray(arr);

		rotate2dArray.transposeArray(arr);
		System.out.println("Transpose Array:" + "\n");
		rotate2dArray.printArray(arr);

		System.out.println("90 degree rotate Array:" + "\n");
		rotate2dArray.reverseArray(arr);
		rotate2dArray.printArray(arr);
	}
}
