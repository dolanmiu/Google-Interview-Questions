package hard;

public class BitAddition {
	public static int add(int a, int b) {
		int result = 0;
		int carry = 0;
		
		for (int i = 0; i < 32; i++) {
			int bitA = getBitAtIndex(a, i);
			int bitB = getBitAtIndex(b, i);

			int carryBit = bitA & bitB;
			int resultBit = bitA ^ bitB;

			int previousCarryIndex = getBitAtIndex(carry, i);
			
			int newResultBit = previousCarryIndex ^ resultBit;
			carryBit = (previousCarryIndex & resultBit) | carryBit;
			resultBit = newResultBit;

			if (carryBit == 1) {
				carry = setOneBitAtIndex(carry, i + 1);
			}

			if (resultBit == 1) {
				result = setOneBitAtIndex(result, i);
			}
		}

		return result;

	}

	public static int getBitAtIndex(int number, int index) {
		int bitmask = 1;
		number = number >> index;
		return number & bitmask;
	}

	public static int setOneBitAtIndex(int number, int index) {
		int bitmask = 1 << index;
		return number | bitmask;
	}

	public static void main(String[] args) {
		System.out.println(add(14, 3));
	}
}
