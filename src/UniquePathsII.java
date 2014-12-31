/**
 * Created by noMoon on 2014-12-31.
 */
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1}};
        System.out.println(uniquePathsWithObstacles(a));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] map = new int[m][n];
        if (obstacleGrid[0][0] != 1) {
            map[0][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    if (i - 1 >= 0)
                        map[i][j] += map[i - 1][j];
                    if (j - 1 >= 0)
                        map[i][j] += map[i][j - 1];
                }
            }
        }
        return map[m - 1][n - 1];

    }
}
