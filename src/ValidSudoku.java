/**
 * Created by noMoon on 2015-01-09.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'.', '.', '3', '.', '2', '.', '6', '.', '.'},
                {'9', '.', '.', '3', '.', '5', '.', '.', '1'},
                {'.', '.', '1', '8', '.', '6', '4', '.', '.'},
                {'.', '.', '8', '1', '.', '2', '9', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '8'},
                {'.', '.', '6', '7', '.', '8', '2', '.', '.'},
                {'.', '.', '2', '6', '.', '9', '5', '.', '.'},
                {'8', '.', '.', '2', '.', '3', '.', '.', '9'},
                {'.', '.', '5', '.', '1', '.', '3', '.', '.'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] columns = new int[9][10];
        int[][] squares = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                rows[i][j] = 0;
                columns[i][j] = 0;
                squares[i][j] = 0;
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int number = board[i][j] - '0';

                    if (rows[i][number] == 0) {
                        rows[i][number] = 1;
                    } else {
                        return false;
                    }
                    if (columns[j][number] == 0) {
                        columns[j][number] = 1;
                    } else {
                        return false;
                    }
                    if (squares[(i / 3) * 3 + j / 3][number] == 0) {
                        squares[(i / 3) * 3 + j / 3][number] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
