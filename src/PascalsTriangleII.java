import java.util.ArrayList;
import java.util.List;

/**
 * Created by noMoon on 2015-01-13.
 */
public class PascalsTriangleII {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            List<Integer> result = getRow(i);
            for (int a : result) {
                System.out.print(a);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> old = new ArrayList<Integer>();
        old.add(1);
        if (rowIndex == 0) return old;
        old.add(1);
        if (rowIndex == 1) return old;
        int s = 1;
        int a[] = new int[rowIndex + 1];
        a[0] = a[1] = 1;
        while (s < rowIndex) {
            for (int i = s; i > 0; i--) {
                a[i] = a[i] + a[i - 1];
            }
            a[s + 1] = a[0] = 1;
            s++;
        }
        old.clear();
        for (int i = 0; i < rowIndex + 1; i++) {
            old.add(a[i]);
        }
        return old;
    }
}
