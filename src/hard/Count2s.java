package hard;

public class Count2s {
	public static int amountOf2(int startNumber, int number, int count) {
		
		if (startNumber == number + 1) {
			return count;
		}

		int toAddCount = getCount(startNumber);
		count = count + toAddCount + amountOf2(++startNumber, number, count);

		return count;

	}

	public static int getCount(int number) {
		int count = 0;
		char[] charsInNumber = Integer.toString(number).toCharArray();
		for (int i = 0; i < charsInNumber.length; i++) {
			if (charsInNumber[i] == '2') {
				System.out.println(number);
				count++;
			}
		}

		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(amountOf2(0, 25, 0));
	}
}
