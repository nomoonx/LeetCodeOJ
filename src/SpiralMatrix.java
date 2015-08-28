import java.util.ArrayList;
import java.util.List;

/**
 * Created by noMoon on 2015-01-25.
 */
public class SpiralMatrix {
    public static void main(String[] args){
//        List<Integer> result=spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        List<Integer> result=spiralOrder(new int[][]{{2,3}});
        for(int a:result){
            System.out.println(a);
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<Integer>();
        int m=matrix.length;
        if(0==m) return result;
        int n=matrix[0].length;
        int[][] tag=new int[m][n];
        int[][] directions=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int direct=0;
        int x=0;
        int y=0;
        for(int i=1;i<=m*n;i++){
            tag[x][y]=i;
            result.add(matrix[x][y]);
            int tempx=x+directions[direct][0];
            int tempy=y+directions[direct][1];
            if(tempx>=m||tempx<0||tempy>=n||tempy<0||tag[tempx][tempy]>0){
                direct=(direct+1)%4;
            }
            x+=directions[direct][0];
            y+=directions[direct][1];
        }
        return result;

    }
}
