package sorting;

public class SearchMatrix {
	public static int binarySearch(int[][] matrix, int searchElement, int startIndex, int endIndex) {
		
		//int middleIndex = getLength(matrix) / 2;

		int middle = (endIndex - startIndex) / 2 + 1;
		int element = getElementWithIndex(middle, matrix);
		
		if (element == searchElement) {
			return element;
		}

		if (endIndex - startIndex <= 1) {
			return -1;
		}

		int result = 0;
		if (element > searchElement) {
			result = binarySearch(matrix, searchElement, startIndex, middle - 1);
		} else if (element < searchElement) {
			result = binarySearch(matrix, searchElement, middle + 1, endIndex);
		}

		return result;
	}


	public static int getElementWithIndex(int index, int[][] matrix) {
		int width = matrix.length;
		int row = index / width;
		int column = index % width;

		return matrix[row][column];
	}

	public static int getLength(int[][] matrix) {
		return matrix.length * matrix[0].length;
	}
}
