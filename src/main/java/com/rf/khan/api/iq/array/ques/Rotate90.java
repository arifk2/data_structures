package com.rf.khan.api.iq.array.ques;

import java.util.ArrayList;
import java.util.Collections;

public class Rotate90 {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
		Collections.reverse(a);

		// transpose
		for (int i = 0; i < a.size(); i++) {
			for (int j = i; j < a.get(0).size(); j++) {
				int temp = a.get(i).get(j);
				a.get(i).set(j, a.get(j).get(i));
				a.get(j).set(i, temp);
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		ArrayList<Integer> a1 = new ArrayList<>();
		a1.add(1);
		a1.add(2);

		ArrayList<Integer> a2 = new ArrayList<>();
		a2.add(3);
		a2.add(4);

		a.add(a1);
		a.add(a2);

		Rotate90 r = new Rotate90();
		r.rotate(a);

	}
}
