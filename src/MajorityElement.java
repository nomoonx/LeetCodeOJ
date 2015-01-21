/**
 * Created by noMoon on 2015-01-20.
 */
public class MajorityElement {
    public static void main(String[] args){
        System.out.println(majorityElement(new int[]{1,1,2,-1,-1,-1,-1}));
    }

    public static int majorityElement(int[] num) {
        int length=num.length;
        if (length == 0) return 0;
        int[] posBits = new int[32];
        int[] negBits = new int[32];
        int zerotimes = 0;
        for (int a : num) {
            if (0 == a) {
                zerotimes++;
            } else if (0 < a) {
                int n = (int) (Math.log((double) a) / Math.log(2));
                for (int i = 0; i <= n; i++) {
                    if (((1 << i) & a) > 0) {
                        posBits[i]++;
                    }
                }
            } else if (0 > a) {
                if (a == -2147483648) {
                    negBits[31]++;
                } else {
                    int b = 0 - a;
                    int n = (int) (Math.log((double) b) / Math.log(2));
                    for (int i = 0; i <= n; i++) {
                        if (((1 << i) & b) > 0) {
                            negBits[i]++;
                        }
                    }
                }
            }
        }
        if (zerotimes >length/2) return 0;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if (posBits[i] > length/2) {
                sum += 1 << i;
            }
        }
        for (int i = 0; i < 32; i++) {
            if (negBits[i] >length/2) {
                sum -= 1 << i;
            }
        }
        return sum;
    }
}
