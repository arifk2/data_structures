package com.rf.khan.api.java8.funtionalinterface;

public class MethodReference {

	public static void main(String[] args) {
		// Method reference
		ArthematicOperation operation = MethodReference::performAddition;
		operation.sumUp(10, 20);

		// Object reference
		MethodReference methodReference = new MethodReference();
		ArthematicOperation methodRefrenceArthematicOperation = methodReference::performAdditionn;
		methodRefrenceArthematicOperation.sumUp(20, 50);

	}

	public static int performAddition(int a, int b) {
		int sum = a + b;
		System.out.println("The sum of the given input value using method reference: -> " + sum);
		return a + b;
	}

	public int performAdditionn(int a, int b) {
		int sum = a + b;
		System.out.println("The sum of the given input value using object reference: -> " + sum);
		return a + b;
	}
}
