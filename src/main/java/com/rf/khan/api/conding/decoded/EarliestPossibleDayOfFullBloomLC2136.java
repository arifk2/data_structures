package com.rf.khan.api.conding.decoded;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EarliestPossibleDayOfFullBloomLC2136 {
	public static void main(String[] args) {
		int[] plantTime = { 1, 4, 3 };
		int[] growTime = { 2, 3, 1 };

		EarliestPossibleDayOfFullBloomLC2136 e = new EarliestPossibleDayOfFullBloomLC2136();
		System.out.println(e.earliestFullBloom(plantTime, growTime));

	}

	/**
	 * TC O(logN) SC O(n)
	 * 
	 * @param plantTime
	 * @param growTime
	 * @return
	 */
	public int earliestFullBloom(int[] plantTime, int[] growTime) {
		List<Seeds> plant = new ArrayList<>();

		for (int i = 0; i < plantTime.length; i++) {
			plant.add(new Seeds(plantTime[i], growTime[i]));
		}

		// go for the max grow time
		Collections.sort(plant, (a, b) -> (b.growTime - a.growTime));

		int time = 0;
		int max = 0;
		for (int i = 0; i < plantTime.length; i++) {
			time += plant.get(i).plantTime;
			max = Math.max(max, time + plant.get(i).growTime);
		}

		return max;
	}

	private class Seeds {
		int plantTime;
		int growTime;

		public Seeds(int plantTime, int growTime) {
			this.plantTime = plantTime;
			this.growTime = growTime;
		}
	}
}
