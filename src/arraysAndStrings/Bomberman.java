package arraysAndStrings;

public class Bomberman {

	public static int[][] bomberman(int[][] inputArray) {
		boolean[][] flippedArray = new boolean[inputArray.length][inputArray[0].length];
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < inputArray[i].length; j++) {
				if (flippedArray[i][j])
					continue;

				if (inputArray[i][j] == 0)
					nullifyRowsAndColumns(flippedArray, inputArray, i, j);

			}
		}
		return inputArray;

	}

	public static void nullifyRowsAndColumns(boolean[][] flippedArray,
			int[][] inputArray, int row, int column) {
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i][column] = 0;
			flippedArray[i][column] = true;
		}

		for (int j = 0; j < inputArray.length; j++) {
			inputArray[row][j] = 0;
			flippedArray[row][j] = true;
		}
	}
	
	public static void main(String[] args) {
		int[][] inputArray = { {1, 0, 2, 2}, {4, 2, 0, 1}, {5, 7, 3, 5} };
		int[][] output = bomberman(inputArray);
		
		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j]);
			}
			System.out.println("");
		}
	}
}
