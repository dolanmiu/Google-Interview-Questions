package hard;

import java.util.ArrayList;

public class MedianRetainer {

	ArrayList<Integer> integers = new ArrayList<Integer>();

	public void addToMedian(int number) {
		for (int i = 0; i < integers.size(); i++) {
			int currentInt = integers.get(i);
			if (currentInt > number) {
				integers.add(number);
			}
		}
	}

	public int getMedian() {
		if (integers.size() % 2 == 0) {
			int middle = (integers.size() / 2) - 1;
			int median = integers.get(middle) + integers.get(middle + 1);
			return median;
		} else {
			int middle = (integers.size() / 2) + 1;
			return integers.get(middle);
		}

	}

}
