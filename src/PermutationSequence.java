import java.util.ArrayList;
import java.util.List;

/**
 * Created by noMoon on 2016-02-10.
 */
public class PermutationSequence {

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 4));
    }

    public static String getPermutation(int n, int k) {
        if (n < 1 || k < 1) {
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        return permutation(list, n, k);
    }

    public static String permutation(List<Integer> array, int n, int k) {
        if (array.size() == 1) {
            return String.valueOf(array.get(0));
        }
        int product = 1;
        int i = 2;
        while (product < k) {
            product *= i++;
        }
        if (--i >= n) {
            product /= i;
        }
        int index = (k - 1) / product;
        k -= index * product;
        String prefix = String.valueOf(array.get(index));
        array.remove(index);
        return prefix + permutation(array, n-1, k);

    }
}
