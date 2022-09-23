package com.rf.khan.api.iq.greedy;

public class ReverseWordds {
	/**
	 * This method is created to reverse the string
	 * 
	 * @param S holds the information od the given string
	 * @return string
	 */
	String reverseWords(String S) {
		String[] str = S.split("[.]");

		StringBuffer s = new StringBuffer();
		for (int i = str.length - 1; i > 0; i--) {
			s.append(str[i] + ".");
		}

		s.append(str[0]);

		return s.toString();
	}

	/**
	 * This is a also another approach to reverse the string
	 * 
	 * @param S holds the information of the given string
	 * @return string
	 */
	String reverseWordsBF(String S) {

		StringBuilder temp = new StringBuilder();
		StringBuilder ans = new StringBuilder();

		for (int i = S.length() - 1; i >= 0; i--) {
			if (S.charAt(i) == '.') {

				// reverse kardo
				temp.reverse();
				ans.append(temp + ".");

				temp.delete(0, temp.length());
			} else {
				temp.append(S.charAt(i));
			}
		}

		temp.reverse();
		ans.append(temp);

		return ans.toString();
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseWordds r = new ReverseWordds();
		String str = "i.like.this.program.very.much";
		System.out.println(r.reverseWords(str));
		System.out.println(r.reverseWordsBF(str));

	}
}
