package com.rf.khan.api.iq.greedy;

/**
 * This is class, to tell whether it is possible to survive on the island
 * 
 * @author mkhan339
 *
 */
public class IsPossibleToSurviveOnIsland {

	/**
	 * This method is created to solve the problem
	 * 
	 * @param surviveN
	 * @param maxFoodEachDayS
	 * @param foodRequiredToSurviveM
	 * @return
	 */
	static int minimumDays(int surviveN, int maxFoodEachDayS, int foodRequiredToSurviveM) {
		int ans = 0;

		int sunday = surviveN / 7;
		int buyingDays = surviveN - sunday;

		int totalFoodRequired = surviveN * foodRequiredToSurviveM;

		if (totalFoodRequired % maxFoodEachDayS == 0) {
			ans = totalFoodRequired / maxFoodEachDayS;
		} else {
			ans = totalFoodRequired / maxFoodEachDayS + 1;
		}

		// catch
		if (buyingDays >= ans)
			return ans;
		else
			return -1;

	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//	    N – The maximum unit of food you can buy each day.
//	    S – Number of days you are required to survive.
//	    M – Unit of food required each day to survive.

		int surviveN = 10, maxFoodEachDayS = 16, foodRequiredToSurviveM = 2;
		System.out.println(minimumDays(surviveN, maxFoodEachDayS, foodRequiredToSurviveM));

		int S = 10, N = 20, M = 30;
		System.out.println(minimumDays(S, N, M));
	}
}
