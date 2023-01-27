package com.rf.khan.api.coding.decoded;

import java.util.ArrayList;
import java.util.List;

/**
 * Solving using tries
 * 
 * @author mkhan339
 *
 */
public class ConcatenatedWordsLC472 {

	public static void main(String[] args) {
		ConcatenatedWordsLC472 con = new ConcatenatedWordsLC472();
		String[] words = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
		System.out.println(con.findAllConcatenatedWordsInADict(words));
		System.out.println(con.findAllConcatenatedWordsInADict(new String[] { "cat", "dog", "catdog" }));
	}

	static class TrieNode {
		boolean isWord = false;
		TrieNode[] children;

		public TrieNode() {
			children = new TrieNode[26];
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode node = root;
			for (char ch : word.toCharArray()) {
				if (node.children[ch - 'a'] == null) {
					node.children[ch - 'a'] = new TrieNode();
				}
				node = node.children[ch - 'a'];
			}
			node.isWord = true;
		}

		public boolean search(String word) {
			TrieNode node = root;
			for (char ch : word.toCharArray()) {
				if (node.children[ch - 'a'] == null) {
					return false;
				}
				node = node.children[ch - 'a'];
			}
			// if the last node of the character is word, then return true
			return node.isWord;
		}
	}

	/**
	 * 
	 * @param words
	 * @return
	 */
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		Trie trie = new Trie();

		// first we will insert all the words in a Trie
		for (String s : words) {
			trie.insert(s);
		}

		List<String> result = new ArrayList<>();
		for (String word : words) {
			if (helper(trie, word, false)) {
				result.add(word);
			}
		}
		return result;
	}

	// cutWordPossible : we will use to check whether this word can be cut into
	// multiple words which tell us it is mad by concatenated words
	private boolean helper(Trie trie, String word, boolean cutWordPossible) {
		// base case:
		if (word.equals("") && cutWordPossible)
			return true;

		if (word.equals(""))
			return false;

		for (int index = 0; index < word.length(); index++) {
			String prefix = word.substring(0, index + 1);

			if (index == word.length() - 1 && cutWordPossible == false)
				return false;

			if (trie.search(prefix)) {
				// cut == true
				if (helper(trie, word.substring(index + 1), true))
					return true;
			}
		}
		return false;
	}
}
