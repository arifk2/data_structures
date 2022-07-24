package com.rf.khan.api.iq.recursion;

public class FactorialRecursion {

	/**
	 * This method is created to get the factorial of the n number
	 * 
	 * @param n holds the information of the n number
	 * @return return the factorial value
	 */
	public static int factorial(int n) {

		if (n == 1 || n == 0) {
			return 1;
		}

		int recResult = factorial(n - 1);

		int result = n * recResult;
		return result;

	}

	public static void main(String[] args) {
		// System.out.println(factorial(5));

		// System.out.println("Sume of the total n number is: " + sum(6));
		System.out.println("Fab is " + fib(6));
	}

	/**
	 * This method is created to get the sum of the nth number
	 * 
	 * @param n holds the information of the n number
	 * @return sum of the n numbers
	 */
	public static int sum(int n) {
		if (n == 1) {
			return 1;
		}

		int recResult = sum(n - 1);
		int result = n + recResult;

		return result;
	}

	public static int fib(int n) {
		if (n <= 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}

}
