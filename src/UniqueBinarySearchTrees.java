import java.util.HashMap;
import java.util.Map;

/**
 * Created by noMoon on 2014-12-25.
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }

    public static int numTrees(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        numMap.put(0, 1);
        numMap.put(1, 1);
        numMap.put(2, 2);
        for (int i = 3; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j <= i; j++) {
                temp += numMap.get(i - j)*numMap.get(j - 1);
            }
            numMap.put(i, temp);
        }
        return numMap.get(n);
    }
}
