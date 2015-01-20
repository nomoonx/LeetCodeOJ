import java.util.ArrayList;
import java.util.List;

/**
 * Created by noMoon on 2015-01-18.
 */
public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 1}));
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

    public static int jump(int[] A) {
        int length = A.length;
        if (length == 0 || length == 1) return 0;
        int max = A[0];
        int s = 1;
        int last = 0;
        while (s < length) {
            if(max>=length-1) return s;
            int temp = max;
            for (int i = last; i <= max; i++) {
                if (i < length) {
                    if (i + A[i] > temp) {
                        temp = i + A[i];
                    }
                }
            }
            last=max+1;
            s++;
            max=temp;
        }
        return 0;
    }
}
