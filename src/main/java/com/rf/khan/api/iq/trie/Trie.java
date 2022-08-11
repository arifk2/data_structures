package com.rf.khan.api.iq.trie;

/**
 * Node class for the trie
 * 
 * @author mkhan339
 *
 */
class TrieNode {
	char data;
	TrieNode[] children;
	boolean isTerminal;

	public TrieNode(char ch) {
		this.data = ch;
		children = new TrieNode[26];
		for (int i = 0; i < 26; i++) {
			children[i] = null;
		}
		isTerminal = false;
	}

}

/**
 * This is the trie implementation class
 * 
 * @author mkhan339
 *
 */
public class Trie {

	TrieNode root;
	TrieNode child;

	public Trie() {
		if (root == null)
			root = new TrieNode('\0');
	}

	/**
	 * call the insertUtil method to perform insert in trie
	 * 
	 * @param word
	 */
	void insertWord(String word) {
		insertUtil(root, word);
	}

	/**
	 * This method is created to
	 * 
	 * @param root
	 * @param word
	 */
	private void insertUtil(TrieNode root, String word) {
		// base case
		if (word.length() == 0) {
			root.isTerminal = true;
			return;
		}

		// assumption word will be in upper-case
		int index = word.charAt(0) - 'A';

		// present check
		if (root.children[index] != null) {
			child = root.children[index];
		} else {
			child = new TrieNode(word.charAt(0));
			root.children[index] = child;
		}

		// recursion
		insertUtil(child, word.substring(1));
	}

	public boolean search(String word) {
		return searchUtil(root, word);
	}

	/**
	 * This method is created for the search
	 * 
	 * @param root holds the information of the root element
	 * @param word holds the information of thr word
	 * @return return true/false
	 */
	private boolean searchUtil(TrieNode root, String word) {
		// base case
		if (word.length() == 0) {
			return root.isTerminal;
		}

		int index = word.charAt(0) - 'A';

		// present
		if (root.children[index] != null) {
			child = root.children[index];
		} else {
			// absent
			return false;
		}

		return searchUtil(child, word.substring(1));
	}

	/**
	 * This method is created to get the word with the prefix
	 * 
	 * @param prefix holds the information of the prefix
	 * @return true/false
	 */
	public boolean startsWith(String prefix) {
		return startsWithUtil(root, prefix);
	}

	/**
	 * This is utility method to get the word with the prefix
	 * 
	 * @param root
	 * @param word
	 * @return
	 */
	private boolean startsWithUtil(TrieNode root, String word) {
		if (word.length() == 0)
			return true;

		int index = word.charAt(0) - 'A';

		if (root.children[index] != null) {
			child = root.children[index];
		} else {
			return false;
		}
		return startsWithUtil(child, word.substring(1));
	}

	private void remove(String word) {
		removeUtil(root, word);
	}

	/**
	 * This method is for the remove functionality
	 * 
	 * @param root holds the information of the root element
	 * @param word holds the information of the input word
	 */
	private void removeUtil(TrieNode root, String word) {
		if (word.length() == 0) {
			return;
		}

		int index = word.charAt(0) - 'A';
		if (root.children[index] != null) {
			child = root.children[index];
			child.isTerminal = false;
		}
		removeUtil(child, word.substring(1));
	}

	/**
	 * Driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insertWord("ABCD");
		t.insertWord("TIME");
		t.insertWord("ARIF");
		System.out.println("Is start with ? " + t.startsWith("AR"));

		System.out.println("Present or not? " + t.search("ABCD"));
		t.remove("ABCD");
		System.out.println("Present or not? " + t.search("ABCD"));
		System.out.println("Present or not? " + t.search("TIME"));
		t.insertWord("ABCD");
		System.out.println("Present or not? " + t.search("ABCD"));
		t.insertWord("KHAN");
		t.insertWord("MD");
		t.insertWord("ROHIT");
		t.insertWord("BAB");
		System.out.println("Is present? " + t.search("ARIF"));
		t.remove("ARIF");
		System.out.println("Is present? " + t.search("ARIF"));
		System.out.println("Is present? " + t.search("ROHIT"));

		System.out.println("Is start with ? " + t.startsWith("RO"));
	}
}
