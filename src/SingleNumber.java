/**
 * Created by noMoon on 2014-11-13.
 */
public class SingleNumber {

    public static void main(String[] args){
        int[] num={0,1,1,2,2};
        System.out.println(singleNumber(num));
    }

    public static int singleNumber(int[] A){
        int result=0;
        for (int temp:A){
            result^=temp;
        }
        return result;
    }
}
