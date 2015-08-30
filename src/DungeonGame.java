/**
 * Created by noMoon on 2015-01-25.
 */
public class DungeonGame {

    public static void main(String[] args){
        System.out.println(calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int height=dungeon.length;
        if(height==0) return 0;
        int width=dungeon[0].length;
        int[][] health=new int[height][width];
        health[height-1][width-1]=1-dungeon[height-1][width-1]>1?1-dungeon[height-1][width-1]:1;
        for(int i=height-2;i>=0;i--){
            health[i][width-1]=health[i+1][width-1]-dungeon[i][width-1]>1?health[i+1][width-1]-dungeon[i][width-1]:1;
        }
        for(int i=width-2;i>=0;i--){
            health[height-1][i]=health[height-1][i+1]-dungeon[height-1][i]>1?health[height-1][i+1]-dungeon[height-1][i]:1;
        }
        for(int i=height-2;i>=0;i--){
            for(int j=width-2;j>=0;j--){
                health[i][j]=health[i+1][j]>health[i][j+1]?health[i][j+1]:health[i+1][j];
                health[i][j]-=dungeon[i][j];
                health[i][j]=health[i][j]>1?health[i][j]:1;
            }
        }
        return health[0][0];
    }
}
