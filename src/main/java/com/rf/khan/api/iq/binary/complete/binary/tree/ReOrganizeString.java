package com.rf.khan.api.iq.binary.complete.binary.tree;

import java.util.Comparator;
import java.util.PriorityQueue;

class CharKey {
	char character;
	int frequency;

	public CharKey(char character, int frequency) {
		this.character = character;
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "CharKey [character=" + character + ", frequency=" + frequency + "]";
	}
	
}

public class ReOrganizeString {
	static int MAX_CHAR = 26;

	public static void reArrangeString(String str) {
		int stringLength = str.length();

		// store all the string character
		int[] count = new int[MAX_CHAR];

		for (int i = 0; i < stringLength; i++) {
			count[str.charAt(i) - 'a']++;
		}

		// insert all the characters and its value in priority queue : max heap
		PriorityQueue<CharKey> pq = new PriorityQueue<>(new Comparator<CharKey>() {
			@Override
			public int compare(CharKey o1, CharKey o2) {
				return o2.frequency - o1.frequency;
			}
		});

		// storing its count in heap
		for (char c = 'a'; c <= 'z'; c++) {
			int val = c - 'a';
			if (count[val] > 0)
				pq.add(new CharKey(c, count[val]));
		}

		str = "";
		CharKey prev = new CharKey('#', -1);

		// traverse queue
		while (!pq.isEmpty()) {
			CharKey k = pq.peek();
			pq.poll();
			str = str + k.character;

			// if the previous frequency is less than 0 means no use
			if (prev.frequency > 0)
				pq.add(prev);

			// make current character as previous character;
			(k.frequency)--;
			prev = k;
		}

		if (stringLength != str.length()) {
			System.out.println("Not valid string");
		} else {
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		String str = "aaabbb";
		reArrangeString(str);
	}
}
