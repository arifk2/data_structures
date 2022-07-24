package com.rf.khan.api.iq.recursion;

public class WayToReachCS {

	public static void main(String[] args) {
		System.out.println(countDistinctWayToClimbStair(3));
	}

	public static int countDistinctWayToClimbStair(long nStairs) {
		if (nStairs < 0) {
			return 0;
		}
		if (nStairs == 0) {
			return 1;
		}
		return countDistinctWayToClimbStair(nStairs - 1) + countDistinctWayToClimbStair(nStairs - 2);
	}
}
