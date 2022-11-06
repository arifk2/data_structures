package com.rf.khan.api.conding.decoded;

public class WordSearchLC79 {
	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		WordSearchLC79 w = new WordSearchLC79();
		System.out.println(w.exist(board, word));
	}

	/**
	 * This method is created to tell whether the word is present of not
	 * 
	 * @param board holds the information of the board
	 * @param word  holds the information of the word
	 * @return true/false
	 */
	public boolean exist(char[][] board, String word) {
		char[] cWord = word.toCharArray();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (cWord[0] == board[row][col]) {
					boolean[][] visited = new boolean[board.length][board[0].length];
					if (dfs(board, row, col, visited, cWord, 0)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * This method is created for the depth first search
	 * 
	 * @param board      holds the information of the board
	 * @param row        holds the information of the row
	 * @param col        holds the information of the column
	 * @param visited    holds the information of the visited array
	 * @param cWord      holds the information of the give word in char array
	 * @param wordInndex holds the information of the index of the cWord array
	 * @return true/false
	 */
	private boolean dfs(char[][] board, int row, int col, boolean[][] visited, char[] cWord, int wordInndex) {
		// base case
		if (wordInndex == cWord.length)
			return true;

		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] == true) {
			return false;
		}

		if (board[row][col] != cWord[wordInndex]) {
			return false;
		}

		// make visited true
		visited[row][col] = true;

		// R, L, U, D
		if (dfs(board, row, col + 1, visited, cWord, wordInndex + 1)
				|| dfs(board, row, col - 1, visited, cWord, wordInndex + 1)
				|| dfs(board, row + 1, col, visited, cWord, wordInndex + 1)
				|| dfs(board, row - 1, col, visited, cWord, wordInndex + 1)) {
			return true;
		}

		// backtrack, mark visited as false again
		visited[row][col] = false;

		return false;
	}
}
