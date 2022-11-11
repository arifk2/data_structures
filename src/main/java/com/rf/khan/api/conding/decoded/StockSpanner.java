package com.rf.khan.api.conding.decoded;

import java.util.Stack;

class StockSpanner {
	private class Pair<T, U> {
		T key;
		U value;

		public Pair(T key, U value) {
			this.key = key;
			this.value = value;
		}

		public T getKey() {
			return key;
		}

		public U getValue() {
			return value;
		}

	}

	Stack<Pair<Integer, Integer>> st;

	public StockSpanner() {
		st = new Stack<>();
	}

	public int next(int price) {
		int span = 1;

		while (!st.isEmpty() && st.peek().getKey() <= price) {
			span += st.peek().getValue();
			st.pop();
		}
		st.add(new Pair(price, span));

		System.out.println(span);
		return span;

	}

	public static void main(String[] args) {
		StockSpanner ss = new StockSpanner();
		ss.next(0);
		ss.next(100);
		ss.next(80);
		ss.next(60);
		ss.next(70);
		ss.next(60);
		ss.next(75);
	}
}