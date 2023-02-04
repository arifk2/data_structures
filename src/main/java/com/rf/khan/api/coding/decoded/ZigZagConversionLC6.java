package com.rf.khan.api.coding.decoded;

import java.util.LinkedList;
import java.util.List;

public class ZigZagConversionLC6 {

	/**
	 * This method is created to do the zigzag conversion
	 * 
	 * @param s       holds the information of the s
	 * @param numRows holds the information of the numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
		List<List<Character>> list = new LinkedList<>();
		for (int i = 0; i < numRows; i++)
			list.add(new LinkedList<>());

		if (numRows == 1)
			return s;

		boolean flag = false;
		int index = 0;
		for (char ch : s.toCharArray()) {
			list.get(index).add(ch);

			if (index == 0 || index == numRows - 1) {
				flag = !flag;
			}

			if (flag) {
				index++;
			} else {
				index--;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (List<Character> ch : list) {
			for (char c : ch) {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	public String convertOPT(String s, int numRows) {
		String[] list = new String[numRows];
		for (int i = 0; i < numRows; i++) {
			list[i] = new String("");
		}

		if (numRows == 1)
			return s;

		boolean flag = false;
		int index = 0;
		for (char ch : s.toCharArray()) {
			list[index] = list[index] + ch;

			if (index == 0 || index == numRows - 1) {
				flag = !flag;
			}

			if (flag) {
				index++;
			} else {
				index--;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (String st : list) {
			sb.append(st);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		ZigZagConversionLC6 z = new ZigZagConversionLC6();
		System.out.println(z.convert("PAYPALISHIRING", 3));
		System.out.println(z.convert("PAYPALISHIRING", 4));
		System.out.println(z.convertOPT("PAYPALISHIRING", 4));
	}
}
