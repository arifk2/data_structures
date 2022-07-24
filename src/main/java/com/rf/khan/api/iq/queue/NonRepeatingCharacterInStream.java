package com.rf.khan.api.iq.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NonRepeatingCharacterInStream {

	public static void main(String[] args) {
		System.out.println(firstNonRepeating("aabc"));
		System.out.println(firstNonRepeating("zz"));
	}

	public static String firstNonRepeating(String A) {
		String ans = "";

		// Step:1 Create map to store the count of character
		Map<Character, Integer> count = new HashMap<>();
		Queue<Character> q = new LinkedList<>();

		for (int i = 0; i < A.length(); i++) {

			if (count.containsKey(A.charAt(i))) {
				count.put(A.charAt(i), count.get(A.charAt(i)) + 1);
				q.add(A.charAt(i));
			} else {
				count.put(A.charAt(i), 1);
				q.add(A.charAt(i));
			}

			while (!q.isEmpty()) {
				if (count.get(q.peek()) > 1) {
					q.poll();
				} else {
					// non - repeating
					ans = ans + q.peek();
					break;
				}
			}
			if (q.isEmpty()) {
				ans = ans + "#";
			}
		}
		return ans;
	}
}
