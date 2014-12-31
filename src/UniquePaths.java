/**
 * Created by noMoon on 2014-12-31.
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(1,1));
        System.out.println(uniquePaths(2,1));
        System.out.println(uniquePaths(2,2));
        System.out.println(uniquePaths(3,3));
    }
    public static int uniquePaths(int m, int n) {
        int[][] map=new int[m][n];
        map[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i-1>=0)
                    map[i][j]+=map[i-1][j];
                if(j-1>=0)
                    map[i][j]+=map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
}
