package Moderate;

import java.util.ArrayList;

public class MaxInt {
	
	public static void main(String[] args) {
		ArrayList<Integer> f = findMax(1320, 1310);
		System.out.println(f.toString());
		
	}
	
	public static Character[] padArray(char[] array, int padding) {
		if (padding < 0) {
			padding = Math.abs(padding);
		}
		char[] paddingArray = new char[padding];
		int totalLength = padding + array.length + 1;
		
		Character[] totalArray = new Character[totalLength];
		
		System.arraycopy(padding, 0, totalArray, 0, paddingArray.length);
		System.arraycopy(array, 0, totalArray, paddingArray.length, array.length);
		//ArrayUtils.addAll(paddingArray, array);
		
		return totalArray;
	}
	
	static char[] concat(char[] A, char[] B) {
		   int aLen = A.length;
		   int bLen = B.length;
		   char[] C= new char[aLen+bLen];
		   System.arraycopy(A, 0, C, 0, aLen);
		   System.arraycopy(B, 0, C, aLen, bLen);
		   return C;
		}
	
	public static ArrayList<Integer> findMax(int a, int b) {

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(a);
		numbers.add(b);
		
		Buckets buckets = new Buckets();

		//int lengthA = ((int)Math.log10(a)+1);
		//int lengthB = ((int)Math.log10(b)+1);

		char[] numberA = Integer.toString(a).toCharArray();
		char[] numberB = Integer.toString(b).toCharArray();
		
		int differenceInLength = numberA.length - numberB.length;
		char[] padArray = new char[Math.abs(differenceInLength)];
		for (int i = 0; i < padArray.length; i++) {
			padArray[i] = '0';
		}
		if (differenceInLength < 0) {
			//padArray(numberA, differenceInLength);
			numberA = concat(padArray, numberA);
		} else if (differenceInLength > 0) {
			//padArray(numberB, differenceInLength);
			numberB = concat(padArray, numberB);
		}

		int count = 0;

		while(count < numberA.length && count < numberB.length) {
			
			buckets.add(numbers.get(0), getDigit(numbers.get(0), count));
			buckets.add(numbers.get(1), getDigit(numbers.get(1), count));
			
			numbers = buckets.regurgetate();
			count++;
		}

		return numbers;
	}
	
	public static int getDigit(int number, int position) {
		String numberString = String.valueOf(number);
		char[] digits = numberString.toCharArray();
		int backwardIndex = digits.length - 1 - position;
		if (position > digits.length - 1) {
			return 0;
		}
		return Character.getNumericValue(digits[backwardIndex]);
	}
}

class Buckets {
	Bucket[] buckets;

	public Buckets() {
		buckets = new Bucket[10];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new Bucket();
		}
	}

	public boolean add(int number, int bucketNumber) {
		if (bucketNumber < 0 || bucketNumber > 9) return false;

		buckets[bucketNumber].add(number);
		return true;
	}

	public ArrayList<Integer> regurgetate() {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (Bucket bucket : buckets) {
			ArrayList<Integer> items = bucket.getBucket();
			for (int n : items) {
				ints.add(n);
			}
			bucket.empty();
		}
		return ints;
	}
}

class Bucket {
	ArrayList<Integer> bucket;

	public Bucket() {
		bucket = new ArrayList<Integer>();
	}

	public void add(int n) {
		bucket.add(n);
	}

	public ArrayList<Integer> getBucket() {
		return bucket;
	}
	
	public void empty() {
		bucket.clear();
	}
}

