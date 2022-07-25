package com.rf.khan.api.iq.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingUsingQueue {

	public static void main(String[] args) {
		System.out.println(getFirstOccurance("aabbcc"));
	}

	static char getFirstOccurance(String str) {
		char ch = '0';
		Queue<Character> q = new LinkedList<Character>();
		Map<Character, Integer> count = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {

			if (count.containsKey(str.charAt(i))) {
				count.put(str.charAt(i), count.get(str.charAt(i)) + 1);
				q.add(str.charAt(i));
			} else {
				count.put(str.charAt(i), 1);
				q.add(str.charAt(i));
			}
		}

		while (!q.isEmpty()) {
			if (count.get(q.peek()) > 1) {
				q.poll();
			} else {
				ch = q.peek();
				break;
			}
		}

		if (q.isEmpty() && ch == '0') {
			ch = str.charAt(0);
		}
		return ch;
	}
}
