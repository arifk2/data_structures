package com.rf.khan.api.iq.queue;

public class PetrolCircularTour {
	public static void main(String[] args) {
		int petrol[] = { 4, 6, 7, 4 };
		int distance[] = { 6, 5, 3, 5 };

		System.out.println(tour(petrol, distance));

	}

	/**
	 * This method is created to get the index of the which petrol pump truck has to
	 * start
	 * 
	 * @param petrol   holds the information of the petrol
	 * @param distance
	 * @return index
	 */
	static int tour(int petrol[], int distance[]) {
		int deficit = 0;
		int balance = 0;
		int size = petrol.length;
		int start = 0;

		for (int i = 0; i < size; i++) {
			// getting the remaining petrol
			balance += petrol[i] - distance[i];
			// if the petrol is less than 0 means now we need to start from the next to
			// current index;
			if (balance < 0) {
				deficit += balance;
				start = i + 1;
				balance = 0;
			}
		}

		if (deficit + balance >= 0) {
			return start;
		}

		return -1;
	}

}
