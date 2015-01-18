import java.util.ArrayList;
import java.util.List;

/**
 * Created by noMoon on 2015-01-18.
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        for (List<Integer> list : result) {
            for (int a : list) {
                System.out.print(a);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(0==numRows) return result;
        List<Integer> old = new ArrayList<Integer>();
        old.add(1);
        result.add(old);
        if (numRows == 1) return result;
        List<Integer> newList = new ArrayList<Integer>();
        newList.add(1);
        newList.add(1);
        result.add(newList);
        if (numRows == 2) return result;
        int s = 1;
        int a[] = new int[numRows];
        a[0] = a[1] = 1;
        while (s < numRows-1) {
            for (int i = s; i > 0; i--) {
                a[i] = a[i] + a[i - 1];
            }
            a[s + 1] = a[0] = 1;
            List<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < s + 2; i++) {
                temp.add(a[i]);
            }
            result.add(temp);
            s++;
        }
        return result;
    }
}
