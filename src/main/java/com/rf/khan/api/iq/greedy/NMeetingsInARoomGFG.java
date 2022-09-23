package com.rf.khan.api.iq.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Find the number of meetings can be held in a meeting room, given start and
 * end time of the meeting
 * 
 * 
 * Activity selection
 * 
 * @author mkhan339
 *
 */
public class NMeetingsInARoomGFG {

	static class Pair {
		int first;
		int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

	}

	/**
	 * Solving using greedy, to get the possible maximum meetings
	 * 
	 * @param start tells start time of the meetings
	 * @param end   tells end time of the meetings
	 * @param n     total number of meetings
	 * @return max meetings
	 */
	public static int maxMeetings(int start[], int end[], int n) {
		List<Pair> meetings = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			meetings.add(new Pair(start[i], end[i]));
		}

		// sort behalf of the ending time of the meeting
		Collections.sort(meetings, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return Integer.compare(o1.second, o2.second);
			}
		});

		int count = 1;
		int endTime = meetings.get(0).second;

		for (int i = 1; i < n; i++) {
			if (meetings.get(i).first > endTime) {
				count++;
				endTime = meetings.get(i).second;
			}
		}
		return count;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int end[] = { 2, 4, 6, 7, 9, 9 };
		int n = 6;
		System.out.println(maxMeetings(start, end, n));
	}
}
