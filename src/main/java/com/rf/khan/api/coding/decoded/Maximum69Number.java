package com.rf.khan.api.coding.decoded;

public class Maximum69Number {

	public static void main(String[] args) {
		Maximum69Number m = new Maximum69Number();
		System.out.println(m.maximum69Number(9669));
	}

	public int maximum69Number(int num) {
		char[] str = new String(new Integer(num).toString()).toCharArray();
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '6') {
				str[i] = '9';
				break;
			}
		}

		int number = Integer.parseInt(new String(str));
		return number;
	}
}
