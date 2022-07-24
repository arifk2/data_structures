package com.rf.khan.api.iq.pattern;

public class FarehToCelcius {
	public static void main(String[] args) {

		int fareh = 64;

		double cel = ((fareh - 32) * 5) / 9;
		System.out.println("Fareh " + fareh + " is equal to " + cel);
	}

}
