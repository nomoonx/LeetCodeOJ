/**
 * Created by noMoon on 2015-01-20.
 */
public class CountandSay {
    public static void main(String[] args) {
        for (int i = 1; i < 7; i++) {
            System.out.println(countAndSay(i));
        }
    }

    public static String countAndSay(int n) {
        if (n <= 0) return "";
        String result = "1";
        if (n == 1) return result;
        int s = 1;
        while (s < n) {
            String temp = result;
            StringBuilder sb = new StringBuilder();
            while (!temp.isEmpty()) {
                char ch = temp.charAt(0);
                int count = 1;
                char[] array = temp.toCharArray();
                for (int i = 1; i < array.length; i++) {
                    if (ch == array[i]) {
                        count++;
                    } else {
                        break;
                    }
                }
                sb.append(String.valueOf(count));
                sb.append(ch);
                temp = temp.substring(count);
            }
            result = sb.toString();
            s++;
        }
        return result;
    }
}
