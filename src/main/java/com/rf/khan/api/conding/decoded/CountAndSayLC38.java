package com.rf.khan.api.conding.decoded;

public class CountAndSayLC38 {

	/**
	 * This method s a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CountAndSayLC38 c = new CountAndSayLC38();
		System.out.println(c.countAndSay(1));
		System.out.println(c.countAndSay(4));
	}

	/**
	 * This method with return the output
	 * 
	 * @param n
	 * @return
	 */
	public String countAndSay(int n) {
		String s = "4";

		for (int i = 1; i < n; i++) {
			s = countAndSayHelper(s);
		}
		return s;
	}

	/**
	 * This method is created to get the string after manipulation
	 * 
	 * @param s
	 * @return
	 */
	private String countAndSayHelper(String s) {
		StringBuilder sb = new StringBuilder();
		char previous = s.charAt(0);
		int count = 1;

		// check the frequency
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == previous) {
				count++;
			}
			// new character found
			else {
				sb.append(count);
				sb.append(previous);
				previous = s.charAt(i);
				count = 1;
			}
		}
		sb.append(count);
		sb.append(previous);

		return sb.toString();
	}
}
