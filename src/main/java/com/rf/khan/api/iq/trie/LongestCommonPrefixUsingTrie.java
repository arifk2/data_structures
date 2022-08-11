package com.rf.khan.api.iq.trie;

class TrieNodeN {
	char data;
	TrieNodeN[] children;
	boolean isTerminal;
	int childrenCount;

	public TrieNodeN(char data) {
		this.data = data;
		this.children = new TrieNodeN[26];
		for (int i = 0; i < 26; i++) {
			children[i] = null;
		}
		this.isTerminal = false;
		this.childrenCount = 0;
	}

}

public class LongestCommonPrefixUsingTrie {
	TrieNodeN root;
	TrieNodeN child;

	public LongestCommonPrefixUsingTrie() {
		root = new TrieNodeN('\0');
	}

	public void insert(String word) {
		insertUtil(root, word);
	}

	/**
	 * InsertUtil method is to insert the character data
	 * 
	 * @param root holds the information of the root
	 * @param word holds the information of teh word
	 */
	private void insertUtil(TrieNodeN root, String word) {
		if (word.length() == 0) {
			root.isTerminal = true;
			return;
		}
		int index = word.charAt(0) - 'a';

		if (root.children[index] != null) {
			child = root.children[index];
		} else {
			child = new TrieNodeN(word.charAt(0));
			root.children[index] = child;
			root.childrenCount++;
		}
		insertUtil(child, word.substring(1));
	}

	public static void main(String[] args) {

		LongestCommonPrefixUsingTrie l = new LongestCommonPrefixUsingTrie();
		String[] arr = { "coding", "codehelp", "codingninja", "coders" };
		int n = 4;

		System.out.println(l.longestCommonPrefix(arr, n));

	}

	private String lcp(String str, String ans) {
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (root.childrenCount == 1) {
				ans = ans + ch;

				// aage badh jao
				int index = str.charAt(i) - 'a';
				root = root.children[index];
			} else {
				break;
			}
			if (root.isTerminal)
				break;
		}
		return ans;
	}

	private String longestCommonPrefix(String[] arr, int n) {
		for (int i = 0; i < n; i++) {
			insert(arr[i]);
		}
		String firstString = arr[0];
		String ans = "";
		return lcp(firstString, ans);
	}
}
