package day21;

public class KnightsTour {
	private static final int N = 8;

    // Possible moves for a knight
    private static final int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
    private static boolean isValidMove(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }
    private static boolean solveKnightsTour(int[][] board, int moveX, int moveY, int moveCount) {
        if (moveCount == N * N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            int nextX = moveX + xMove[i];
            int nextY = moveY + yMove[i];
            if (isValidMove(nextX, nextY, board)) {
                board[nextX][nextY] = moveCount;
                if (solveKnightsTour(board, nextX, nextY, moveCount + 1)) {
                    return true;
                } else {
                    board[nextX][nextY] = -1; // backtracking
                }
            }
        }

        return false;
    }
    public static boolean startKnightsTour() {
        int[][] board = new int[N][N];

        // Initialize the board with -1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }
        int startX = 0;
        int startY = 0;
        board[startX][startY] = 0; // Start from the first cell

        // Start solving the problem
        if (!solveKnightsTour(board, startX, startY, 1)) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            printSolution(board);
            return true;
        }
    }
    private static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
    }
	public static void main(String[] args) {
		  startKnightsTour();
		// TODO Auto-generated method stub

	}

}
