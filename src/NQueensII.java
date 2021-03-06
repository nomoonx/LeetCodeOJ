import java.util.ArrayList;
import java.util.List;

/**
 * Created by noMoon on 2015-01-19.
 */
public class NQueensII {
    public static void main(String[] args){
        System.out.println(totalNQueens(1));
    }

    public static int totalNQueens(int n) {
        int result=0;
        if(n<=0) return 0;
        int[] map=new int[n];
        int s=0;
        int row=0;
        while(true){
            while (row<n){
                if(check(map,n,s,row)){
                    map[s++]=row;
                    row=0;
                    break;
                }
                row++;
            }
            if(s==n){
                result++;
                s--;
                row=map[s]+1;
            }
            if(row==n){
                s--;
                if(s<0) break;
                row=map[s]+1;
            }

        }
        return result;
    }

    private static boolean check(int[] map, int n, int s, int target) {
        for (int i=0;i<s;i++){
            if(map[i]==target) return false;
            if(Math.abs(map[i]-target)==Math.abs(i-s)) return false;
        }
        return true;
    }
}
