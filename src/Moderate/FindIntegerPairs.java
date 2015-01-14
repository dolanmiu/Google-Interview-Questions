package Moderate;

import java.util.ArrayList;
import java.util.HashMap;

public class FindIntegerPairs {
	public static ArrayList<Integer[]> findPairs(int[] array, int sum) {
		HashMap<Integer, Boolean> map = generateHashFromArray(array);
		ArrayList<Integer[]> pairs = new ArrayList<Integer[]>();

		for (int i = 0; i < array.length; i++) {
			int difference = sum - array[i];
			Boolean pairExists = map.get(difference);
			if (pairExists) {
				pairs.add(new Integer[] { i, difference });
			}
		}
		return pairs;
	}

	public static HashMap<Integer, Boolean> generateHashFromArray(int[] array) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for(int i = 0; i < array.length; i++) {
			map.put(array[i], true);
		}

		return map;
	}
}
