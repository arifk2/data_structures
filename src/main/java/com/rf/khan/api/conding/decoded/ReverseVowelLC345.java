package com.rf.khan.api.conding.decoded;

public class ReverseVowelLC345 {
	public static void main(String[] args) {
		ReverseVowelLC345 r = new ReverseVowelLC345();
		System.out.println(r.reverseVowels("hello"));
		System.out.println(r.reverseVowels("leetcode"));
	}

	public String reverseVowels(String s) {
		if (s.equals("")) {
			return "";
		}

		char[] ch = s.toCharArray();

		int start = 0;
		int end = s.length() - 1;

		while (start <= end) {
			if (start <= end && vowelCheck(ch[start]) && vowelCheck(ch[end])) {
				// swap
				char temp = ch[start];
				ch[start] = ch[end];
				ch[end] = temp;

				start++;
				end--;
			} else if (start <= end && !vowelCheck(ch[start]) && vowelCheck(ch[end])) {
				start++;
			} else if (start <= end && vowelCheck(ch[start]) && !vowelCheck(ch[end])) {
				end--;
			} else if (!vowelCheck(ch[start]) && !vowelCheck(ch[end])) {
				start++;
				end--;
			}
		}

		String ans = new String(ch);
		return ans;
	}

	private boolean vowelCheck(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U') {
			return true;
		}
		return false;
	}
}
