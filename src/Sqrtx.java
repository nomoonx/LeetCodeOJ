/**
 * Created by noMoon on 2015-01-03.
 */
public class Sqrtx {
    public static void main(String[] args){
        System.out.println(sqrt(2));
        System.out.println(sqrt(3));
        System.out.println(sqrt(4));
        System.out.println(sqrt(5));
        System.out.println(sqrt(6));
        System.out.println(sqrt(7));
        System.out.println(sqrt(16));
        System.out.println(sqrt(15));
    }


    public static int sqrt(int x) {
        int a=2;
        int b=x/a;
        while(Math.abs(a-b)>1){
            a=(a+b)/2;
            b=x/a;
        }
        return a>b?b:a;
    }
}
