package Moderate;

public class TicTacToe {
	public static Character checkforWinner(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				boolean result = recursiveCheck(board, board[i][j], i, j);
				if (result) {
					return board[i][j];
				}
			}
		}
		return null;
	}

	public static boolean recursiveCheck(char[][] board, char icon, int i, int j) {
		if (i < 0 || i > board.length) {
			return true;
		}

		if (j < 0 || j > board[0].length) {
			return true;
		}

		if (board[i][j] != icon) return false;

		boolean hitLeftWall = recursiveCheck(board, icon, i - 1, j);
		boolean hitRightWall = recursiveCheck(board, icon, i + 1, j);

		boolean hitTopWall = recursiveCheck(board, icon, i, j - 1);
		boolean hitBottomWall = recursiveCheck(board, icon, i, j + 1);

		boolean hitTopLeftCorner = recursiveCheck(board, icon, i - 1, j - 1);
		boolean hitTopRightCorner = recursiveCheck(board, icon, i + 1, j - 1);

		boolean hitBottomLeftCorner = recursiveCheck(board, icon, i - 1, j + 1);
		boolean hitBottomRightCorner = recursiveCheck(board, icon, i + 1, j + 1);

		if ((hitLeftWall && hitRightWall) || (hitTopWall && hitBottomWall) || (hitTopLeftCorner && hitBottomRightCorner) || (hitTopRightCorner && hitBottomLeftCorner)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		char[][] a = new char[][] { {'o', 'o', 'o'}, {' ', 'x', 'x'}, { 'o', 'x', ' '}};  
		checkforWinner(a);
	}
}
