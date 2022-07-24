package com.rf.khan.api.iq.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class PermuatationsStringCS17 {

	public static void main(String[] args) {
		System.out.println(generatePermutations("abc"));
	}

	public static ArrayList<String> generatePermutations(String str) {
		ArrayList<String> ans = new ArrayList<String>();
		String output = "";
		int index = 0;
		solve(str, ans, output, index);
		Collections.sort(ans);
		return ans;
	}

	private static void solve(String str, ArrayList<String> ans, String output, int index) {

		// base case
		if (index >= str.length()) {
			ans.add(new String(output));
			return;
		}

		for (int j = index; j < str.length(); j++) {
			// swap the alphabets ans store in output
			char[] abc = str.toCharArray();

			char temp = abc[index];
			abc[index] = abc[j];
			abc[j] = temp;

			str = new String(abc);

			output = output + abc[index];
			// recursive call
			solve(str, ans, output, index + 1);

			// back tracking
			temp = abc[index];
			abc[index] = abc[j];
			abc[j] = temp;

			output = output.substring(0, output.length() - 1);

		}
	}

}
