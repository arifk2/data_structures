package com.rf.khan.api.iq.array.ques;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);

		Integer[] objects = (Integer[]) al.toArray();

		// Printing array of objects
		for (int obj : objects)
			System.out.print(obj + " ");
	}
}
