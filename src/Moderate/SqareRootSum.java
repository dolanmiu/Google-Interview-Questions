package Moderate;

public class SqareRootSum {
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
		double root = Math.root(naturalNumber, 2);

		if ((root == Math.floor(root)) && !Double.isInfinite(root)) {
	    		return 0;
		}

		char[] decimalChars = Integer.toString(root).split('.')[1].toCharArray();

		for (int i = 0; i < 100; i++) {
			if (i > decminalChars.length - 1) break;

			int decminal = Character.toNumericValue(decimalChars[i]);
			sum += decminal;
		}

		return sum;
	}
}
