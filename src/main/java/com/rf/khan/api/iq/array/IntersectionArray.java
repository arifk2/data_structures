package com.rf.khan.api.iq.array;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntersectionArray {

	public static void main(String[] args) {

		Integer[] inputArray = { 1, 2, 2, 2, 3, 4 };
		ArrayList<Integer> arrayList1 = Stream.of(inputArray).collect(Collectors.toCollection(ArrayList::new));

		Integer inputArray2[] = { 2, 2, 3, 3 };
		ArrayList<Integer> arrayList2 = Stream.of(inputArray2).collect(Collectors.toCollection(ArrayList::new));

		ArrayList<Integer> result = findArrayIntersection(arrayList1, arrayList1.size(), arrayList2, arrayList2.size());
		System.out.println(result);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + ", ");
		}

	}

	public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2,
			int m) {
		ArrayList<Integer> result = new ArrayList<>();
		int i = 0, j = 0;

		while (i < n && j < m) {

			if (arr1.get(i) == arr2.get(j)) {
				// add in list
				result.add(arr1.get(i));
				i++;
				j++;
			} else if (arr1.get(i) < arr2.get(j)) {
				i++;
			} else {
				j++;
			}

		}
		return result;
	}

	public static ArrayList<Integer> findArrayIntersectionTLE(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2,
			int m) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int element = arr1.get(i);
			for (int j = 0; j < m; j++) {
				if (element < arr2.get(j)) {
					break;
				}

				// checking equality of the element
				if (element == arr2.get(j)) {
					// add in list
					result.add(element);

					// update the number with some negative value;
					// arr2.add(arr2.get(j), Integer.MIN_VALUE);
					arr2.set(j, Integer.MIN_VALUE);
					break;
				}
			}
		}

		return result;
	}

}
