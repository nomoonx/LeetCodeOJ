/**
 * Created by noMoon on 2014-12-30.
 */
public class ReverseInteger {
    public static void main(String[] args){
        System.out.println(reverse(1534236469));
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        int number=x<0?0-x:x;
        int result=0;
        while(number>0){
            if((double)result*10+number%10>Math.pow(2,32))
                return 0;
            result=result*10+number%10;
            number=number/10;
        }
        if(x<0) return 0-result;
        else return result;
    }
}
