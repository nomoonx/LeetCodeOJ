import java.util.Arrays;

/**
 * Created by noMoon on 2015-01-09.
 */
public class SudokuSolver {
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
        solveSudoku(board);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
        char[][] map= new char[9][9];
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
                map[i][j]=board[i][j];
                if (board[i][j] != '.') {
                    int number = board[i][j] - '0';
                    rows[i][number] = 1;
                    columns[j][number] = 1;
                    squares[(i / 3) * 3 + j / 3][number] = 1;
                }
            }
        }
        int s=0;
        int number=1;
        while(s<81){
            int i=s/9;
            int j=s%9;
            if (map[i][j]== '.') {
                while(number<10){
                    if(rows[i][number]==0&&columns[j][number]==0&&squares[(i / 3) * 3 + j / 3][number]==0){
                        board[i][j]=(char)('0'+number);
                        rows[i][number]=1;columns[j][number]=1;squares[(i / 3) * 3 + j / 3][number]=1;
                        number=1;
                        s++;
                        break;
                    }
                    number++;
                }
                if(10==number){
                    s--;
                    i=s/9;
                    j=s%9;
                    while(map[i][j]!='.'){
                        s--;
                        i=s/9;
                        j=s%9;
                    }
                    number=board[i][j]-'0';
                    rows[i][number]=0;columns[j][number]=0;squares[(i / 3) * 3 + j / 3][number]=0;
                    board[i][j]='.';
                    number++;
                }
            }else{
                s++;
            }
            
        }
    }
}
