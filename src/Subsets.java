import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by noMoon on 2014-11-13.
 */
public class Subsets {
    public static void main(String[] args){
        int[] num={4,1,0};
        List<List<Integer>> result=subsetsWithDup(num);
        for (List<Integer> list:result){
            for (int temp :list){
                System.out.print(temp);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] S) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        int length=S.length;
        int number=1<<length;
        for (int i=0;i<number;i++){
            List<Integer> temp=new ArrayList<Integer>();
            for (int j=0;j<length;j++){
                if((i&(1<<j))>0){
                    temp.add(S[j]);
                }
            }
            Collections.sort(temp);
            result.add(temp);
        }
        return result;
    }
}
