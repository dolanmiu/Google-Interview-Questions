package bits;

public class GreaterSmallerBit {

	public static int getNext(String number, int direction) {
		int inputInt = Integer.parseInt(number, 2);

		int temp = inputInt;
		int timesShifted = 0;

		while (temp % 2 != 0) {
			temp = temp >> 1;
			timesShifted++;
		}

		int bitmaskLeft = 1 << timesShifted + direction;
		int bitmaskRight = 1 >> timesShifted;
		int bitmask = bitmaskLeft | bitmaskRight;

		int maskedInt = inputInt & bitmask;

		int toInsert = (1 < timesShifted + direction);

		return maskedInt | toInsert;
	}

	public static int getNextLargest(String number) {
		return getNext(number, 1);
	}

	public static int getNextSmallest(String number) {
		return getNext(number, -1);
	}
}
