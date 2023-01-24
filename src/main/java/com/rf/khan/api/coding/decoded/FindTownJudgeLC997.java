package com.rf.khan.api.coding.decoded;

public class FindTownJudgeLC997 {
	public static void main(String[] args) {
		int n = 2;
		int[][] trust = { { 1, 2 } };
		FindTownJudgeLC997 f = new FindTownJudgeLC997();
		System.out.println(f.findJudge(n, trust));
		System.out.println(f.findJudge(4, new int[][] { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } }));
		System.out.println(f.findJudge(3, new int[][] { { 1, 3 }, { 2, 3 }, { 3, 1 } }));
	}

	/**
	 * Approach: Find the indegree and outdegree, if any member has (n-1 ) indegree
	 * and (0) outdegree
	 * 
	 * @param n     total members
	 * @param trust
	 * @return
	 */
	public int findJudge(int n, int[][] trust) {
		int[] inwardDegree = new int[n + 1];
		int[] outwardDegree = new int[n + 1];

		for (int index = 0; index < trust.length; index++) {
			int countOut = outwardDegree[trust[index][0]];
			outwardDegree[trust[index][0]] = countOut + 1;

			int coutIn = inwardDegree[trust[index][1]];
			inwardDegree[trust[index][1]] = coutIn + 1;
		}

		for (int index = 1; index <= n; index++) {
			if (outwardDegree[index] == 0 && inwardDegree[index] == n - 1) {
				return index;
			}
		}

		return -1;
	}

}
