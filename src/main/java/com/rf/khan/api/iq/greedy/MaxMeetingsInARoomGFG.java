package com.rf.khan.api.iq.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxMeetingsInARoomGFG {

	static class Meeting {
		int first;
		int second;
		int position;

		public Meeting(int first, int second, int position) {
			this.first = first;
			this.second = second;
			this.position = position;
		}
	}

	/**
	 * This method will tell which meeting can a suer can attend
	 * 
	 * @param N
	 * @param S
	 * @param F
	 * @return
	 */
	public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
		List<Meeting> meetings = new ArrayList<Meeting>();
		ArrayList<Integer> ans = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			meetings.add(new Meeting(S[i], F[i], i + 1));
		}

		Collections.sort(meetings, new Comparator<Meeting>() {

			@Override
			public int compare(Meeting o1, Meeting o2) {
				return Integer.compare(o1.second, o2.second);
			}
		});

		int endTime = 0;
		ans.add(meetings.get(0).position);

		for (int i = 0; i < N; i++) {
			if (meetings.get(i).first > endTime) {
				if (!ans.contains(meetings.get(i).position)) {
					ans.add(meetings.get(i).position);
				}
				endTime = meetings.get(i).second;
			}
		}

		Collections.sort(ans);
		return ans;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] S = { 12, 6, 16, 12, 6, 9, 16, 6, 17, 5 };
//		int[] F = { 17, 13, 16, 18, 17, 10, 18, 12, 18, 11 };
//		int N = 10;

		int N = 7;
		int[] S = { 11, 12, 12, 12, 8, 6, 18 };
		int[] F = { 15, 12, 12, 13, 12, 8, 19 };
		System.out.println(maxMeetings(N, S, F));
	}
}
