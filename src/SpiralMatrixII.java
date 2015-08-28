/**
 * Created by noMoon on 2015-08-28.
 */
public class SpiralMatrixII {
    public static void main(String[] args){
        int n=4;
        int[][] map=generateMatrix(n);
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(map[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] result=new int[n][n];
        int[][] directions=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int direct=0;
        int x=0;
        int y=0;
        for(int i=1;i<=n*n;i++){
            result[x][y]=i;
            int tempx=x+directions[direct][0];
            int tempy=y+directions[direct][1];
            if(tempx>=n||tempx<0||tempy>=n||tempy<0||result[tempx][tempy]>0){
                direct=(direct+1)%4;
            }
            x+=directions[direct][0];
            y+=directions[direct][1];
        }
        return result;
    }
}
