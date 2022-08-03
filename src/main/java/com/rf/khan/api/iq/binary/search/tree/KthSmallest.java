package com.rf.khan.api.iq.binary.search.tree;

import java.util.ArrayList;

public class KthSmallest {
	static ArrayList<Integer> ans;

	public static int kthSmallest(Node root, int k) {
		ans = new ArrayList<Integer>();
		solve(root, ans);
		return ans.get(k - 1);
	}

	public static void solve(Node root, ArrayList<Integer> ans) {
		if (root == null) {
			return;
		}
		solve(root.left, ans);
		ans.add(root.data);
		solve(root.right, ans);
	}
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}
}
