package com.rf.khan.api.coding.decoded;

public class GasStationLC134 {

	public static void main(String[] args) {
		int[] gas = { 1, 2, 3, 4, 5 }, cost = { 3, 4, 5, 1, 2 };
		GasStationLC134 g = new GasStationLC134();
		System.out.println(g.canCompleteCircuit(gas, cost));
	}

	private class GasStation {
		private int gas;
		private int distance;

		public GasStation(int gas, int distance) {
			this.gas = gas;
			this.distance = distance;
		}
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		GasStation[] gasStation = new GasStation[n];

		for (int index = 0; index < n; index++) {
			gasStation[index] = new GasStation(gas[index], cost[index]);
		}

		return getStartIndex(gasStation, n);
	}

	private int getStartIndex(GasStation[] gasStation, int n) {
		int deficit = 0;
		int balance = 0;
		int start = 0;

		for (int index = 0; index < n; index++) {
			GasStation g = gasStation[index];
			balance += g.gas - g.distance;

			if (balance < 0) {
				deficit += balance;
				start = index + 1;
				balance = 0;
			}
		}

		if (deficit + balance >= 0) {
			return start;
		}
		return -1;
	}
}
