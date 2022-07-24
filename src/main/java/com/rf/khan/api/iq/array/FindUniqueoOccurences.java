package com.rf.khan.api.iq.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindUniqueoOccurences {
	public static void main(String[] args) {
		int[] inputArray = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
		System.out.println(uniqueOrNot(inputArray));
	}

	public static boolean uniqueOrNot(int[] inputArray) {

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < inputArray.length; i++) {
			if (hashMap.containsKey(inputArray[i])) {
				hashMap.put(inputArray[i], hashMap.get(inputArray[i]) + 1);
			} else {
				hashMap.put(inputArray[i], 1);
			}
		}

		System.out.println(hashMap);

		Set<Integer> set = new HashSet<>();
		boolean flag = true;

		for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " - " + "Value: " + entry.getValue());
			if (set.add(entry.getValue()) == false) {
				flag = false;
				
			}
		}
		return flag;
	}
}
