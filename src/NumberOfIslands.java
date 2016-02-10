import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by noMoon on 2016-02-10.
 */
public class NumberOfIslands {
    public static void main(String[] args){
        System.out.println(numIslands(new char[][]{"1111111".toCharArray(),"0000001".toCharArray(),"1111101".toCharArray(),"1000101".toCharArray(),"1010101".toCharArray(),"1011101".toCharArray(),"1111111".toCharArray()}));
        System.out.println(numIslands(new char[][]{"11111011111111101011".toCharArray(),"01111111111110111110".toCharArray(),"10111001101111111111".toCharArray(),"11110111111111111111".toCharArray(),"10011111111111111111".toCharArray(),"10111111011101110111".toCharArray(),"01111111111101101111".toCharArray(),"11111111111101111011".toCharArray(),"11111111110111111111".toCharArray(),"11111111111111111111".toCharArray(),"01111111011111111111".toCharArray(),"11111111111111111111".toCharArray(),"11111111111111111111".toCharArray(),"11111011111110111111".toCharArray(),"10111110111011110111".toCharArray(),"11111111111101111110".toCharArray(),"11111111111110111100".toCharArray(),"11111111111111111111".toCharArray(),"11111111111111111111".toCharArray(),"11111111111111111111".toCharArray()}));
        System.out.println(numIslands(new char[][]{"11110111111101011111".toCharArray(),"11111111111011111111".toCharArray(),"01111101101111111101".toCharArray(),"11111111111111111101".toCharArray(),"11110111111110111101".toCharArray(),"11111011101111111101".toCharArray(),"11110111111111101111".toCharArray(),"01011111100101011111".toCharArray(),"11111111111111111111".toCharArray(),"11110001011110101111".toCharArray(),"11111111111111111111".toCharArray(),"11111111111011110011".toCharArray(),"01111111111011111111".toCharArray(),"11111111110111111111".toCharArray(),"11111011111111111111".toCharArray(),"11111111111101111011".toCharArray(),"11111111111111111111".toCharArray(),"10111011110111111111".toCharArray(),"11111111111111111111".toCharArray(),"11011111111111111111".toCharArray()}));
    }

    public static int numIslands(char[][] grid) {
        if(grid.length<1){
            return 0;
        }
        int count=0;
        int colorCount=0;
        int n=grid.length;
        int m=grid[0].length;
        int[][] map=new int[n][m];
        Map<Integer,Set<Integer>> conflict=new HashMap<Integer, Set<Integer>>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    if(i==0){
                        if(j==0){
                            colorCount++;
                            count++;
                            map[i][j]=colorCount;
                        }else{
                            if(map[i][j-1]>0){
                                map[i][j]=map[i][j-1];
                            }else{
                                colorCount++;
                                count++;
                                map[i][j]=colorCount;
                            }
                        }
                    }else{
                        if(j==0){
                            if(map[i-1][j]>0){
                                map[i][j]=map[i-1][j];
                            }else{
                                colorCount++;
                                count++;
                                map[i][j]=colorCount;
                            }
                        }else{
                            int color1=map[i][j-1];
                            int color2=map[i-1][j];
                            if(color1>0&&color2>0){
                                map[i][j]=color1;
                                if(color1!=color2){
                                    if(conflict.containsKey(color1)||conflict.containsKey(color2)) {
                                        if(!conflict.containsKey(color1)){
                                            int temp=color1;
                                            color1=color2;
                                            color2=temp;
                                        }
                                        Set<Integer> conflictSet=conflict.get(color1);

                                        if(!conflictSet.contains(color2)){
                                            count--;
                                            Set<Integer> tempConfilctSet=new HashSet<Integer>();
                                            tempConfilctSet.addAll(conflictSet);
                                            if(conflict.containsKey(color2)){
                                                tempConfilctSet.addAll(conflict.get(color2));
                                            }
                                            tempConfilctSet.add(color1);
                                            tempConfilctSet.add(color2);
                                            for(Integer color:tempConfilctSet){
                                                conflict.put(color,tempConfilctSet);
                                            }
                                        }
                                    }else{
                                        count--;
                                        Set<Integer> conflistSet=new HashSet<Integer>();
                                        conflistSet.add(color1);
                                        conflistSet.add(color2);
                                        conflict.put(color1,conflistSet);
                                        conflict.put(color2,conflistSet);
                                    }
                                }
                            }else{
                                if(color1>0){
                                    map[i][j]=color1;
                                }else if(color2>0){
                                    map[i][j]=color2;
                                }else{
                                    colorCount++;
                                    count++;
                                    map[i][j]=colorCount;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
