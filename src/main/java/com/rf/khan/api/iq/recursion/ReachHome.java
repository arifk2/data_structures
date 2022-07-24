package com.rf.khan.api.iq.recursion;

public class ReachHome {
	public static void main(String[] args) {
		reachHome(1, 10);
	}

	private static void reachHome(int src, int dest) {
		System.out.println("Source is: " + src + " destination is: " + dest);
		if (src == dest) {
			System.out.println("Reached Home");
			return;
		}
		src++;
		reachHome(src, dest);
	}
}
