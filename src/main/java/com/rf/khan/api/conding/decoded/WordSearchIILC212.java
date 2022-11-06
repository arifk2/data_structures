package com.rf.khan.api.conding.decoded;

import java.util.ArrayList;
import java.util.List;

public class WordSearchIILC212 {

	public static void main(String[] args) {
		char[][] board = { { 'o', 'a', 'a', 'n' }, 
				           { 'e', 't', 'a', 'e' }, 
				           { 'i', 'h', 'k', 'r' },
				           { 'i', 'f', 'l', 'v' } };
		
		String[] words = { "oath", "pea", "eat", "rain" };
		WordSearchIILC212 w = new WordSearchIILC212();
		System.out.println(w.findWords(board, words));
	}

	private class TriesNode {
		private TriesNode[] children;
		private String word;

		public TriesNode() {
			children = new TriesNode[26];
		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		// Step1: Build tries
		TriesNode root = buildTrie(words);

		int rowN = board.length;
		int colN = board[0].length;

		// iterate for the row and col
		for (int row = 0; row < rowN; row++) {
			for (int col = 0; col < colN; col++) {
				dfs(board, row, col, root, result);
			}
		}

		return result;
	}

	private void dfs(char[][] board, int row, int col, TriesNode p, List<String> result) {
		// base case
		char c = board[row][col];
		if (c == ';' || p.children[c - 'a'] == null)
			return;

		// element is present in the tries
		p = p.children[c - 'a'];
		if (p.word != null) {
			result.add(p.word);
			p.word = null; // to avoid adding it multiple times -- avoid duplicates in ans
		}

		// visited mark
		board[row][col] = ';';
		if (row > 0)
			dfs(board, row - 1, col, p, result);
		if (col > 0)
			dfs(board, row, col - 1, p, result);

		if (row < board.length - 1)
			dfs(board, row + 1, col, p, result);

		if (col < board[0].length - 1)
			dfs(board, row, col + 1, p, result);

		// back tracking
		board[row][col] = c;
	}

	private TriesNode buildTrie(String[] words) {
		TriesNode root = new TriesNode();
		for (String w : words) {
			TriesNode p = root;
			for (char c : w.toCharArray()) {
				int i = c - 'a';
				if (p.children[i] == null)
					p.children[i] = new TriesNode();
				p = p.children[i];
			}
			p.word = w;
		}
		return root;
	}
}
