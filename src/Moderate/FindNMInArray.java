package Moderate;

public class FindNMInArray {

	public static int[] findTwoEnds(int[] array) {
		int[] nm = new int[2];
		nm[0] = find(array, false);
		nm[1] = find(array, true);
		return nm;
	}

	public static int find(int[] array, boolean goLeft) {
		if (goLeft) {
			for (int i = array.length - 1; i > 1; i--) {
				int delta = array[i] - array[i - 1];
				if (delta < 0) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < array.length - 1; i++) {
				int delta = array[i] - array[i + 1];
				if (delta > 0) {
					return i;
				}
			}
		}
		return -1;
	}
}
