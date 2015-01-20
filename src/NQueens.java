import java.util.ArrayList;
import java.util.List;

/**
 * Created by noMoon on 2015-01-19.
 */
public class NQueens {
    public static void main(String[] args){
        List<String[]> result=solveNQueens(1);
        for(String[] array:result){
            for (String str:array){
                System.out.println(str);
            }
            System.out.println();
        }
    }

    public static List<String[]> solveNQueens(int n) {
        List<String[]> result=new ArrayList<String[]>();
        if(n<=0) return result;
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
                result.add(convert(map,n));
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

    private static String[] convert(int[] map,int n){
        String[] result=new String[n];
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            for (int j=0;j<n;j++){
                if(map[j]!=i){
                    sb.append('.');
                }else{
                    sb.append('Q');
                }
            }
            result[i]=sb.toString();
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
