package com.rf.khan.api.iq.recursion;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/find-the-winner-of-the-circular-game/
 * 
 * @author mkhan339
 *
 */
public class WinnerCircularGameLC {

	/**
	 * This method is created to find the winner
	 * 
	 * @param n total number of friends
	 * @param k count including current friend
	 * @return
	 */
	public int findTheWinner(int n, int k) {
		int ans = solve(n, k) + 1; // +1 because modulus give 0 based indexing
		return ans;
	}

	/**
	 * Solving using recursion
	 * 
	 * @param n total number of friends
	 * @param k count including current friend
	 * @return
	 */
	private int solve(int n, int k) {
		// base case;
		if (n == 1)
			return 0;

		return (solve(n - 1, k) + k) % n;
	}

	/**
	 * Solving using linked list
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public int findTheWinnerUsingLInkedList(int n, int k) {
		LinkedList<Integer> friends = new LinkedList<>();
		for (int i = 1; i <= n; i++)
			friends.add(i);

		int lastFriend = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k - 1; j++) {
				friends.add(friends.poll());
			}
			lastFriend = friends.poll();
		}

		return lastFriend;
	}
	
	public int findTheWinnerO(int n, int k) {
        int result = 0;
        for(int i=1; i<=n; i++) {
            result = (result + k) % i;
        }
        return result + 1;
    }

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 5;
		int k = 2;

		WinnerCircularGameLC w = new WinnerCircularGameLC();
		System.out.println(w.findTheWinner(n, k));

		System.out.println(w.findTheWinnerUsingLInkedList(n, k));
		System.out.println(w.findTheWinner(n, k));

	}
}
