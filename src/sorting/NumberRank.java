package sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NumberRank {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("numbers.txt"));

		AutoSortingList<Integer> sl = new AutoSortingList<Integer>();

		String line;
		while((line = br.readLine()) != null) {
			int currentInt = Integer.parseInt(line);
			sl.track(currentInt);
		}
		
		br.close();
	}
}

class AutoSortingList<T> {
	ArrayList<Comparable<T>> sortedList;

	public AutoSortingList() {
		sortedList = new ArrayList<Comparable<T>>();
	}

	public void track(Comparable<T> toAdd) {
		for (int i = 0; i < sortedList.size(); i++) {
			if (sortedList.get(i).compareTo((T) toAdd) > 0) {
				sortedList.add(i, toAdd);
				return;
			}
		}
	}

	public Comparable<T> getRankOfNumber(Comparable<T> comparable) {
		for (int i = sortedList.size() - 1; i > 0; i--) {
			if (comparable.compareTo((T) sortedList.get(i)) == 0) {
				return sortedList.get(i);
			}
		}
		return null;
	}
}
