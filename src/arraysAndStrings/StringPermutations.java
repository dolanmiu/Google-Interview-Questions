package arraysAndStrings;

import java.util.Arrays;

public class StringPermutations {
	
	public static boolean isPermutation(String string1, String string2) {
		if (string1.length() != string2.length()) return false;

		char[] sortedString1Array = sortCharArray(string1.toCharArray());
		char[] sortedString2Array = sortCharArray(string2.toCharArray());
		System.out.println(sortedString1Array);
		System.out.println(sortedString2Array);

		if (sortedString1Array.toString().equals(sortedString2Array.toString())) {
			return true;
		} else {
			return false;
		}

	}

	public static char[] sortCharArray(char[] charArray) {
		return mergeSort(charArray);
	}

	public static char[] mergeSort(char[] charArray) {
		int halfArrayLength = (int)Math.floor(charArray.length / 2); //try without all mumbo
		
		char[] leftSide = null;
		char[] rightSide = null;
		
		if (charArray.length > 2) {
			leftSide = mergeSort(Arrays.copyOfRange(charArray, 0, halfArrayLength));
			rightSide = mergeSort(Arrays.copyOfRange(charArray, halfArrayLength, charArray.length - 1));
		} else {
			leftSide = Arrays.copyOfRange(charArray, 0, 1);
			rightSide = Arrays.copyOfRange(charArray, 1, 2);
		}

		char[] sortedCharArray = new char[charArray.length];
		int leftSidePointer = 0;
		int rightSidePointer = 0;

		for (int i = 0; i < charArray.length; i++) {
			
			if (rightSidePointer > rightSide.length - 1) {
				sortedCharArray[i] = leftSide[leftSidePointer];
				leftSidePointer++;
				continue;
			}
			
			if (leftSidePointer > leftSide.length - 1) {
				sortedCharArray[i] = rightSide[rightSidePointer];
				rightSidePointer++;
				continue;
			}
			
			if (leftSide[leftSidePointer] < rightSide[rightSidePointer]) {
				sortedCharArray[i] = leftSide[leftSidePointer];
				leftSidePointer++;
			} else {
				sortedCharArray[i] = rightSide[rightSidePointer];
				rightSidePointer++;
			}
			
		}
		return sortedCharArray;
	}
	
	public static void main(String[] args) {
		System.out.println(isPermutation("hello", "helol"));
	}
}
