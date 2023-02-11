package com.rf.khan.api.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderLC127 {

	public static void main(String[] args) {
		String[] wordList = { "des", "der", "dfr", "dgt", "dfs" };
		String startWord = "der", targetWord = "dfs";

		WordLadderLC127 w = new WordLadderLC127();
		System.out.println(w.wordLadderLength(startWord, targetWord, wordList));
	}

	private class Pair {
		String first;
		int second;

		public Pair(String first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
		// Step1: put startWord in queue
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(startWord, 1));

		// Step2: create set to track the wordlist
		Set<String> st = new HashSet<>();
		for (String str : wordList)
			st.add(str);

		st.remove(startWord);

		// Step 3: Simple BFS traversal
		while (!q.isEmpty()) {
			String word = q.peek().first;
			int steps = q.peek().second;
			q.poll();

			if (word.equals(targetWord))
				return steps;

			for (int i = 0; i < word.length(); i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char[] replaceWordArray = word.toCharArray();
					replaceWordArray[i] = ch;

					String replaceWord = new String(replaceWordArray);

					// if the word exist in the set, then remove it and add it into the queue
					if (st.contains(replaceWord)) {
						st.remove(replaceWord);
						q.add(new Pair(replaceWord, steps + 1));
					}
				}
			}
		}
		return 0;
	}
}
