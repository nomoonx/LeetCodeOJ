/**
 * Created by noMoon on 2015-01-26.
 */
public class ValidPalindrome {

    public static void main(String[] args){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        String text=s.replaceAll("[^a-z^A-Z^0-9]","").toLowerCase();
        StringBuilder sb=new StringBuilder(text);
        sb.reverse();
        return text.equals(sb.toString());
    }
}
