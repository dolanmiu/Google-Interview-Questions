package Moderate;

import java.util.Arrays;

public class MaxSubArrayu {
	public static int findMaxSubList(int[] array) {
		return recursiveSum(array, 0, -10000, -10000);
	}

	public static int recursiveSum(int[] array, int index, int currentSum, int maxSum) {
		if (index > array.length - 1) {
			return maxSum;
		}


		if (array[index] > currentSum + array[index]) {
			currentSum = array[index];
		} else {
			currentSum = currentSum + array[index];
		}
		
		if (currentSum > maxSum) {
			maxSum = currentSum;
		}

		return recursiveSum(array, ++index, currentSum, maxSum);
	}

	public static void main(String[] args) {
		int[] array = new int[] { -8, 3, -2, 4, -500, 1};
		int output = findMaxSubList(array);
		System.out.println(Arrays.toString(array));
		System.out.println(output);
	}
}
