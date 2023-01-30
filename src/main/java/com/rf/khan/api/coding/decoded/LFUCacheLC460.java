package com.rf.khan.api.coding.decoded;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LFUCacheLC460 {

	private int cap;
	private int min = 1;
	private Map<Integer, Integer> keyValueMap = new HashMap<>();
	private Map<Integer, Integer> keyFrequencyMap = new HashMap<>();
	private Map<Integer, Set<Integer>> freqKeysMap = new HashMap<>();

	public LFUCacheLC460(int capacity) {
		cap = capacity;
		freqKeysMap.put(1, new LinkedHashSet<>());
	}

	public int get(int key) {
		// key not exist
		if (!keyValueMap.containsKey(key)) {
			return -1;
		}
		// update the key frequency if we perform get operation
		int frequency = keyFrequencyMap.get(key);
		freqKeysMap.get(frequency).remove(key);
		if (frequency == min && freqKeysMap.get(frequency).size() == 0) {
			min++;
		}

		if (!freqKeysMap.containsKey(frequency + 1)) {
			freqKeysMap.put(frequency + 1, new LinkedHashSet<>());
		}
		// add frequency in freqKeysMap
		freqKeysMap.get(frequency + 1).add(key);

		// update existing frequency
		keyFrequencyMap.put(key, frequency + 1);

		return keyValueMap.get(key);
	}

	public void put(int key, int value) {
		if (cap <= 0)
			return;

		// if key exist
		if (keyValueMap.containsKey(key)) {
			keyValueMap.put(key, value);
			this.get(key);
			return;
		}

		// if key is not exist and capacity is full, then evict least frequency used
		if (keyValueMap.size() >= cap) {
			int keyToBeEvicted = freqKeysMap.get(min).iterator().next();
			freqKeysMap.get(min).remove(keyToBeEvicted);
			keyFrequencyMap.remove(keyToBeEvicted);
			keyValueMap.remove(keyToBeEvicted);
		}

		// key is not present in the map and size is also present
		keyValueMap.put(key, value);
		keyFrequencyMap.put(key, 1);
		min = 1;
		freqKeysMap.get(min).add(key);
	}
}
