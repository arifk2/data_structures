package com.rf.khan.api.iq.recursion;

import java.util.ArrayList;

public class SubsequencesInStringCS29 {

	public static void main(String[] args) {
		System.out.println(subsequences("abc"));
	}

	public static ArrayList<String> subsequences(String str) {
		ArrayList<String> ans = new ArrayList<>();
		String output = "";

		int index = 0;
		solve(str, index, output, ans);

		return ans;
	}

	private static void solve(String str, int index, String output, ArrayList<String> ans) {

		// base case
		if (index >= str.length()) {
			if (output.length() > 0)
				ans.add(new String(output));
			return;

		}

		// exclude
		solve(str, index + 1, output, ans);

		char element = str.charAt(index);
		output = output + element;

		// include
		solve(str, index + 1, output, ans);
	}
}
