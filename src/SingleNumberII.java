/**
 * Created by noMoon on 2014-12-29.
 */
public class SingleNumberII {
    public static void main(String[] args) {
        int[] num = {-2147483648};
        System.out.println(singleNumber(num));
        System.out.println((int) (Math.log((double) 15) / Math.log(2)));
    }

    public static int singleNumber(int[] A) {
        if (A.length == 0) return 0;
        int[] posBits = new int[32];
        int[] negBits = new int[32];
        int zerotimes = 0;
        for (int a : A) {
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
        if (zerotimes % 3 != 0) return 0;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if (posBits[i] % 3 != 0) {
                sum += 1 << i;
            }
        }
        for (int i = 0; i < 32; i++) {
            if (negBits[i] % 3 != 0) {
                sum -= 1 << i;
            }
        }
        return sum;
    }
}
