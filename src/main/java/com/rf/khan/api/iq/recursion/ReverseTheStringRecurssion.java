package com.rf.khan.api.iq.recursion;

public class ReverseTheStringRecurssion {
	public static void main(String[] args) {
		String name = "arifkhan";
		char[] in = name.toCharArray();
		

		reverseStringUsingRecurssion(in, 0, in.length - 1);
		System.out.println(in);
	}

	private static void reverseStringUsingRecurssion(char[] inputString, int start, int end) {

		// if the pointer ends
		if (start > end) {
			return;
		}

		// swap the start index elemnt to the last index element
		char temp = inputString[start];
		inputString[start] = inputString[end];
		inputString[end] = temp;

		// System.out.print(temp);
		start++;
		end--;

		reverseStringUsingRecurssion(inputString, start, end);
	}
}
