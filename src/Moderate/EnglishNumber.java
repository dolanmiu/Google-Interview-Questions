package Moderate;

public class EnglishNumber {
	public static void main(String[] args) {
		//System.out.println(numberify(1234));
		//System.out.println(numberify(2011));
		//System.out.println(numberify(914));
		//System.out.println(numberify(120));
		System.out.println(numberify(3001));
	}
	public static String numberify(int input) {

		int[] numberArray = prepNumber(input);
		String output = "";

		for (int i = 0; i < numberArray.length; i++) {
			if (i == 0 && numberArray[1] == 1) {
				String teen = getTeens(numberArray[1] * 10 + numberArray[0]);
				output = teen;
				i = i + 1;
				continue;
			}

			if (i == 1) {
				String number = getEnglishMultipleOf10(numberArray[i]);
				output = number + " " + output;
			} else {
				String number = getEnglishNumber(numberArray[i]);
				if (number != "" ) {
					String tenMultiple = getEnglishPowersOf10(i);
					output = number + " " + tenMultiple + " " + output;
				}
			}
		}
		
		return output;
	}
	
	public static int[] prepNumber(int number) {
		char[] charArray = Integer.toString(number).toCharArray();
		int[] newArray = new int[charArray.length];

		for (int i = 0; i < charArray.length; i++) {
			int n = Character.getNumericValue(charArray[i]);
			newArray[charArray.length - 1 - i] = n;
		}

		return newArray;
	}

	public static String getTeens(int number) {
		switch(number) {
			case 10:
				return "Ten";
			case 11:	
				return "Eleven";
			case 12:
				return "Twelve";
			case 13:
				return "Thirteen";
			case 14:
				return "Fourteen";
			case 15:
				return "Fifteen";
			case 16:
				return "Sixteen";
			case 17:
				return "Seventeen";
			case 18:
				return "Eighteen";
			case 19:
				return "Nineteen";
		}
		return "Number invalid";
	}

	public static String getEnglishNumber(int number) {
		switch (number) {
			case 0:
				return "";
			case 1:
				return "One";
			case 2:
				return "Two";
			case 3:
				return "Three";
			case 4:
				return "Four";
			case 5:
				return "Five";
			case 6:
				return "Six";
			case 7:
				return "Seven";
			case 8:
				return "Eight";
			case 9:
				return "Nine";
		}
		return "Number invalid";
	}

	public static String getEnglishPowersOf10(int number) {
		switch(number) {
			case 0:
				return "";
			case 1:
				return "Ten";
			case 2:
				return "Hundred";
			case 3:
				return "Thousand";
			default:
				return "Undefined";
		}
	}

	public static String getEnglishMultipleOf10(int number) {
		switch (number) {
			case 0:
				return "";
			case 1:
				return "Ten";
			case 2:
				return "Twenty";
			case 3:
				return "Thirty";
			case 4:
				return "Fourty";
			case 5:
				return "Fifty";
			case 6:
				return "Sixty";
			case 7:
				return "Seventy";
			case 8:
				return "Eighty";
			case 9:
				return "Ninety";
		}
		return "Number invalid";
	}
}
