/**
 * Created by noMoon on 2015-01-26.
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args){
        System.out.println(trailingZeroes(1808548329));
    }

    public static int trailingZeroes(int n) {
        if(n<=1) return 0;
        int fives=0;
        int m=(int)(Math.log(n)/Math.log(5));
        int temp=1;
        for(int i=1;i<=m;i++){
            temp*=5;
            fives+=n/temp;
        }
        return fives;
    }
}
