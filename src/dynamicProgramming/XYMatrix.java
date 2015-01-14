package dynamicProgramming;

public class XYMatrix {
	
	public static int findXYAmount(int x, int y) {
		int[][] matrix = new int[x][y];
		recursiveDP(matrix, 0, 0);
		for(int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println("");
		}
		return matrix[matrix.length - 1][matrix[0].length - 1];
	}

	public static void recursiveDP(int[][] matrix, int currentX, int currentY) {

		if (currentX < 0 || currentY < 0) {
			return;
		}

		if (currentX > matrix.length - 1 || currentY > matrix[0].length - 1) {
			return;
		}
		
		int stepsAbove = 0;
		int stepsLeft = 0;
		
		if (currentX == 0 && currentY == 0) {
			stepsAbove = 1;
			stepsLeft = 0;
		}
		
		if (currentY > 0) {
			stepsAbove = matrix[currentX][currentY - 1];
		}
		
		if (currentX > 0) {
			stepsLeft = matrix[currentX - 1][currentY];
		}

		int newSize = stepsAbove + stepsLeft;
		
		if (newSize > matrix[currentX][currentY]) {
			matrix[currentX][currentY] = newSize;
		}

		recursiveDP(matrix, currentX + 1, currentY); // go right
		recursiveDP(matrix, currentX, currentY + 1); // go down
	}

	public static void main(String[] args) {
		System.out.println(findXYAmount(6, 5));
	}
}
