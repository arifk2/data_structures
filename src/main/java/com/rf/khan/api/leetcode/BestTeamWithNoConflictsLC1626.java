package com.rf.khan.api.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bouncycastle.util.Arrays;

public class BestTeamWithNoConflictsLC1626 {

	public static void main(String[] args) {
		// int[] scores = { 1, 3, 5, 10, 15 }, ages = { 1, 2, 3, 4, 5 };
		int[] scores = { 4, 5, 6, 5 }, ages = { 2, 1, 2, 1 };
		BestTeamWithNoConflictsLC1626 b = new BestTeamWithNoConflictsLC1626();
		System.out.println(b.bestTeamScore(new int[] { 1, 3, 5, 10, 15 }, new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(b.bestTeamScore(scores, ages));

	}

	private class Player {
		int age;
		int score;

		public Player(int age, int score) {
			this.age = age;
			this.score = score;
		}
	}

	public int bestTeamScore(int[] scores, int[] ages) {
		int n = scores.length;
		List<Player> players = new ArrayList<>();

		for (int index = 0; index < n; index++) {
			players.add(new Player(ages[index], scores[index]));
		}

		Collections.sort(players, (a, b) -> a.age - b.age == 0 ? a.score - b.score : a.age - b.age);

		int[][] dp = new int[n][n + 1];
		for (int[] i : dp)
			Arrays.fill(i, -1);

		// current player index, previous player, n , players list
		return solve(0, -1, n, players, dp);
	}

	private int solve(int currentPlayer, int previousPlayer, int n, List<Player> players, int[][] dp) {
		// base case
		if (currentPlayer == n)
			return 0;

		if (dp[currentPlayer][previousPlayer + 1] != -1) {
			return dp[currentPlayer][previousPlayer + 1];
		}

		int notTake = 0 + solve(currentPlayer + 1, previousPlayer, n, players, dp);
		if (previousPlayer == -1 || players.get(previousPlayer).score <= players.get(currentPlayer).score) {
			int take = players.get(currentPlayer).score + solve(currentPlayer + 1, currentPlayer, n, players, dp);
			return dp[currentPlayer][previousPlayer + 1] = Math.max(notTake, take);
		}
		return dp[currentPlayer][previousPlayer + 1] = notTake;
	}
}
