package com.rf.khan.api.iq.string;

public class LowerCase {

	public static void main(String[] args) {
		char ch = 'D';

		if (ch >= 'a' && ch <= 'z') {
			ch = ch;
			System.out.println(ch);
		} else {
			char temp = (char) (ch - 'A' + 'a');
			System.out.println(temp);
		}
	}

}
