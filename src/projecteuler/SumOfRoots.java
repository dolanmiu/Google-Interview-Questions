package projecteuler;

import java.math.BigDecimal;

public class SumOfRoots {
	public static void main(String[] args) {
		int sum = findSumOfSquareRoots(100);
		System.out.println(sum);
	}

	public static int findSumOfSquareRoots(int lastDigit) {
		int sum = 0;
		for (int i = 0; i < lastDigit; i++) {
			sum += findSquareRootSum(i);
		}

		return sum;
	}

	public static double findSquareRootSum(int naturalNumber) {
		
		int sum = 0;
		BigDecimal root = Math.sqrt(naturalNumber);
		//root.
//root.pow(0.5);
		if ((root == Math.floor(root)) && !Double.isInfinite(root)) {
	    		return 0;
		}
		String fullString = Double.toString(root);
		String decimalString = fullString.split("\\.")[1];
		char[] decimalChars = decimalString.toCharArray();
		
		for (int i = 0; i < 100; i++) {
			if (i > decimalChars.length - 1) break;

			int decminal = Character.getNumericValue(decimalChars[i]);
			sum += decminal;
		}

		return sum;
	}
	
	public static BigDecimal findAccurateSquareRoot(int number, int significant figures) {
		BigDecimal output = new BigDecimal(number);
		while (output.precision() < 100) {
			
		}
	}
}
