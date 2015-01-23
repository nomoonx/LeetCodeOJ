/**
 * Created by noMoon on 2015-01-22.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1000110001));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        while (x > 0) {
            if (x % 10 != (int) (x / (Math.pow(10, (int) Math.log10(x))))) {
                return false;
            }
            if ((int) Math.log10(x) - (int) Math.log10((x - (x % 10 * (int) Math.pow(10, (int) Math.log10(x))) - x % 10) / 10) > 2) {
                if ((x - x % 10) % (int) Math.pow(10, (int) Math.log10(x) - (int) Math.log10((x - (x % 10 * (int) Math.pow(10, (int) Math.log10(x))) - x % 10) / 10) - 1) != 0) {
                    return false;
                } else {
                    x = (x - (x % 10 * (int) Math.pow(10, (int) Math.log10(x))) - x % 10) / (int) Math.pow(10, (int) Math.log10(x) - (int) Math.log10((x - (x % 10 * (int) Math.pow(10, (int) Math.log10(x))) - x % 10) / 10) - 1);
                }
            } else {
                x = (x - (x % 10 * (int) Math.pow(10, (int) Math.log10(x))) - x % 10) / 10;
            }
        }
        return true;
    }
}
