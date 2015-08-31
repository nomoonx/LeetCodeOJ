import java.util.ArrayList;
import java.util.List;

/**
 * Created by noMoon on 2015-08-30.
 */
public class Combinations {
    public static void main(String[] args){
        List<List<Integer>> result=combine(5,2);
        for(List<Integer> list:result){

            for(int num:list){
                System.out.print(num);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> combination=new ArrayList<Integer>();
        combination.add(1);
        while(true){
            int lastNumber=combination.get(combination.size()-1);
            if(lastNumber>n){
                if(combination.size()==1){
                    break;
                }
                combination.remove(combination.size()-1);
                int temp=combination.get(combination.size()-1);
                combination.remove(combination.size()-1);
                combination.add(temp+1);
            }else if(combination.size()==k){
                List<Integer> tempList=new ArrayList<Integer>();
                tempList.addAll(combination);
                result.add(tempList);
                int temp=combination.get(k-1);
                combination.remove(k-1);
                combination.add(temp+1);
            }else{
                combination.add(lastNumber+1);
            }
        }
        return result;
    }
}
