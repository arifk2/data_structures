package com.rf.khan.api.conding.decoded;

import java.util.HashMap;
import java.util.Map;

public class ArtithematicSlicesIILC446 {

	public static void main(String[] args) {
		ArtithematicSlicesIILC446 a = new ArtithematicSlicesIILC446();
		System.out.println(a.numberOfArithmeticSlices(new int[] { 2, 4, 6, 8, 10 }));
	}

	public int numberOfArithmeticSlices(int[] nums) {
		int ans = 0;
		int len = nums.length;

		Map<Integer, Integer>[] map = new Map[len];

		for (int i = 0; i < len; i++) {
			map[i] = new HashMap<>(i);

			for (int j = 0; j < i; j++) {
				long difference = (long) (nums[j]) - nums[i];

				if (difference <= Integer.MIN_VALUE || difference > Integer.MAX_VALUE)
					continue;

				int diff = (int) difference;
				int n1 = map[j].getOrDefault(diff, 0);
				int n2 = map[i].getOrDefault(diff, 0);
				ans += n1;
				int freq = 1 + n1 + n2;

				map[i].put(diff, freq);
			}
		}

		return ans;
	}
}
