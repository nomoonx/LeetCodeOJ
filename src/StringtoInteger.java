/**
 * Created by noMoon on 2015-01-19.
 */
public class StringtoInteger {
    public static void main(String[] args) {
//        System.out.println(atoi("123"));
//        System.out.println(atoi("-123"));
//        System.out.println(atoi("123A"));
        System.out.println(atoi("-2147483648"));
    }

    public static int atoi(String str) {
        int INT_MAX = 2147483647;
        if (null == str || str.isEmpty()) return 0;
        String text = str.trim();
        if (text.isEmpty()) return 0;
        long result = 0;
        int flag = 1;
        if (text.charAt(0) == '-') {
            flag = -1;
            text = text.substring(1);
        } else if (text.charAt(0) == '+') {
            flag = 1;
            text = text.substring(1);
        }
        while (text.length() > 0) {
            char ch = text.charAt(0);
            if (ch < '0' || ch > '9') {
                return flag * (int) result;
            }
            result = result * 10 + ch - '0';
            if (result > INT_MAX) {
                if (flag < 0) {
                    return INT_MAX * -1 - 1;
                } else {
                    return INT_MAX;
                }
            }
            text = text.substring(1);
        }
        return flag * (int) result;
    }
}
