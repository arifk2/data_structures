package com.rf.khan.api;

public class StringNameValidation {
	public static void main(String[] args) {
		System.out.println(isvalidString("Name"));
		System.out.println(isvalidString("ProjectArif_1"));
		System.out.println(isvalidString("Name_"));
		System.out.println(isvalidString("Name_1"));
		System.out.println(isvalidString("Name_2"));
		System.out.println(isvalidString("Name_12"));
		System.out.println(isvalidString("Name_1A"));
		System.out.println(isvalidString("Name_1A1"));
		System.out.println(isvalidString(""));
		
		System.out.println("INVALID_NAME".contains("INVALID_NAME"));

	}

	public static boolean isvalidString(String input) {
		String[] str = input.split("_");
		if (input.isEmpty() || input.charAt(input.length() - 1) == '_' || isNumeric(str[str.length - 1])) {
			return false;
		}
		return true;
	}

	public static boolean isNumeric(final String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}
}
