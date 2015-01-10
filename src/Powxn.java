/**
 * Created by noMoon on 2015-01-08.
 */
public class Powxn {
    public static void main(String[] args){
        System.out.println(pow(2,5));
        System.out.println(pow(3,0));
        System.out.println(pow(2,-1));
        System.out.println(pow(34.00515, -3));
    }

    public static double pow(double x, int n) {
        if(n>=0) {
            int m = (int) (Math.log((double) n) / Math.log(2));
            double result = 1;
            double loop = x;
            for (int i = 0; i <= m; i++) {
                if (((1 << i) & n) > 0) {
                    result *= loop;
                }
                loop *= loop;
            }
            return result;
        }else{
            int a=0-n;
            int m = (int) (Math.log((double) a) / Math.log(2));
            double result = 1;
            double loop = x;
            for (int i = 0; i <= m; i++) {
                if (((1 << i) & a) > 0) {
                    result *= loop;
                }
                loop *= loop;
            }
            return 1/result;
        }
    }
}
