package com.rf.khan.api.coding.decoded;

import java.util.Arrays;

public class MaximumBagsWithFullCapacityLC2279 {

	public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
		int capacityLength = capacity.length;

		// Step 1: create vacancy array
		int[] vacancy = new int[capacityLength];

		for (int index = 0; index < capacityLength; index++) {
			vacancy[index] = capacity[index] - rocks[index];
		}

		// Step2: sort vacancy array
		Arrays.sort(vacancy);

		// Step3: get the count whose capacity reached to zero with the user of
		// additionalRocks
		int bagCount = 0;
		for (int index = 0; index < capacityLength; index++) {
			if (vacancy[index] == 0) {
				bagCount++;
			} else {
				if (additionalRocks >= vacancy[index]) {
					additionalRocks = additionalRocks - vacancy[index];
					bagCount++;
				} else {
					break;
				}
			}
		}
		return bagCount;
	}
}