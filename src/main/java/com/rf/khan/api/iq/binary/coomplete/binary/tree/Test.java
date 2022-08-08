package com.rf.khan.api.iq.binary.coomplete.binary.tree;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		int[] a = { 10, 5, 6, 2 };
		int[] b = { 12, 7, 9 };
		int[] c = new int[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		System.out.println(Arrays.toString(c));
	}
}
