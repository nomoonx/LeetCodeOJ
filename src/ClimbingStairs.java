/**
 * Created by noMoon on 2015-01-03.
 */
public class ClimbingStairs {
    public static void main(String[] args){
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int a=1;int b=2;
        int i=3;int c=0;
        while(i<=n){
            c=a+b;
            a=b;
            b=c;
            i++;
        }
        return c;
    }
}
