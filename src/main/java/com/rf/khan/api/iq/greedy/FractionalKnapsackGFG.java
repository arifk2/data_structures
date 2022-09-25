package com.rf.khan.api.iq.greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

/**
 * Fraction knapsack problem
 * 
 * @author mkhan339
 *
 */
public class FractionalKnapsackGFG {

	class Pair {
		double unitValue;
		Item item;

		public Pair(double unitValue, Item item) {
			this.unitValue = unitValue;
			this.item = item;
		}

	}

	/**
	 * This method is created to get maximum total value in the knapsack
	 * 
	 * @param W   holds the information of the weight of knapsack
	 * @param arr holds the information of the item : values and weights
	 * @param n   size of item array
	 * @return maximum total value in the knapsack
	 */
	double fractionalKnapsack(int W, Item arr[], int n) {
		Vector<Pair> v = new Vector<>();

		for (int i = 0; i < n; i++) {
			double perUnitValue = arr[i].value / arr[i].weight;
			v.add(new Pair(perUnitValue, arr[i]));
		}

		// sort the vector in descending order : based on the per unit value
		Collections.sort(v, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return (int) (o2.unitValue - o1.unitValue);
			}
		});

		double totalValue = 0.0;

		for (int i = 0; i < n; i++) {
			if (v.get(i).item.weight > W) {
				// as the weight is greater than the knapsack value, so we need to take the
				// fraction
				totalValue += W * v.get(i).unitValue;
				W = 0;

			} else {
				// then, take all the weight of the max value
				totalValue += v.get(i).item.value;
				// decreasing the weight,
				W = W - v.get(i).item.weight;
			}
		}

		return totalValue;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int N = 3, W = 50;
		int values[] = { 60, 100, 120 };
		int weight[] = { 10, 20, 30 };

		Item[] items = new Item[N];

		for (int i = 0; i < N; i++) {
			Item temp = new Item(values[i], weight[i]);
			items[i] = temp;
		}
		FractionalKnapsackGFG fKnap = new FractionalKnapsackGFG();
		System.out.println(fKnap.fractionalKnapsack(W, items, N));

	}
}

//Required classes
class Item {
	int value, weight;

	Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
}
