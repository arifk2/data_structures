package com.rf.khan.api.iq.trie;

import java.util.ArrayList;
import java.util.Collections;

public class PhoneDirectory {
	TrieNode root;
	TrieNode child;

	public void insert(String word) {
		insertUtil(root, word);
	}

	public void insertUtil(TrieNode root, String word) {
		if (word.length() == 0) {
			root.isTerminal = true;
			return;
		}
		int index = word.charAt(0) - 'a';

		if (root.children[index] != null) {
			child = root.children[index];
		} else {
			child = new TrieNode(word.charAt(0));
			root.children[index] = child;
		}
		insertUtil(child, word.substring(1));
	}

	/**
	 * Get suggestions
	 * 
	 * @param queryStr
	 * @return
	 */
	private ArrayList<ArrayList<String>> getSuggestions(String queryStr) {
		// set previous on root
		TrieNode prev = root;
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		String prefix = "";

		for (int i = 0; i < queryStr.length(); i++) {
			char lastChar = queryStr.charAt(i);
			prefix = prefix + lastChar;

			// check for the last character
			TrieNode curr = prev.children[lastChar - 'a'];

			// if not found
			if (curr == null) {
				break;
			}

			ArrayList<String> temp = new ArrayList<>();
			// if found
			printSuggestions(curr, temp, prefix);
			output.add(temp);

			// temp.removeAll(temp);
			prev = curr;
		}

		return output;
	}

	/**
	 * This method is created to print suggestions
	 * 
	 * @param curr   holds the information of current
	 * @param temp
	 * @param prefix
	 */
	private void printSuggestions(TrieNode curr, ArrayList<String> temp, String prefix) {
		if (curr.isTerminal) {
			temp.add(prefix);
		}

		for (char ch = 'a'; ch <= 'z'; ch++) {
			TrieNode next = curr.children[ch - 'a'];

			if (next != null) {
				prefix = prefix + ch;
				printSuggestions(next, temp, prefix);
				//backtracking
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}

	}

	/**
	 * Phone directory method
	 * 
	 * @param contactList holds the information of the contact list
	 * @param queryStr
	 * @return
	 */
	public ArrayList<ArrayList<String>> phoneDirectory(ArrayList<String> contactList, String queryStr) {
		// Step1: creation of trie;
		root = new TrieNode('\0');

		// Step2: insert all contact into the trie
		for (int i = 0; i < contactList.size(); i++) {
			String str = contactList.get(i);
			insert(str);
		}

		// return ans
		return getSuggestions(queryStr);
	}

	/**
	 * Driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PhoneDirectory p = new PhoneDirectory();
		ArrayList<String> contactList = new ArrayList<>();
		Collections.addAll(contactList, "cod", "coding", "codding", "code", "coly");
		String queryStr = "coding";
		ArrayList<ArrayList<String>> ans = (p.phoneDirectory(contactList, queryStr));
		for (ArrayList<String> a : ans) {
			System.out.println(a);
		}
	}
}
