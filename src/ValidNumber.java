/**
 * Created by noMoon on 2014-12-23.
 */
public class ValidNumber {

    public static void main(String[] args) {
        System.out.println(isNumber("1 "));
        System.out.println(isNumber(".1"));
        System.out.println(isNumber("3."));
        System.out.println(isNumber("0"));
        System.out.println(isNumber(" 0.1 "));
        System.out.println(isNumber("abc"));
        System.out.println(isNumber("1 a"));
        System.out.println(isNumber("2e10"));
        System.out.println(isNumber("2e10.1"));
        System.out.println(isNumber("1.11.1"));
        System.out.println(isNumber("2e3e1"));
        System.out.println(isNumber("+.89"));
        System.out.println(isNumber("-123"));
        System.out.println(isNumber("2.1e10"));
        System.out.println(isNumber(".+8"));
        System.out.println(isNumber("1e+9"));
        System.out.println(isNumber("5897972791"));
        System.out.println(isNumber("5897972791e"));

    }

    public static boolean isSingleNumber(String s) {
        if (s.isEmpty()) return false;
        if ((s.contains("-") && s.indexOf('-') != 0) || (s.contains("+") && s.indexOf('+') != 0)) {
            return false;
        }
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1);
        }
        if (!s.contains(".")) {
            return isInteger(s);
        } else {
            if (s.indexOf('.') != s.lastIndexOf('.')) {
                return false;
            }
            if (s.indexOf('.') == 0) {
                return isInteger(s.substring(1));
            } else if (s.indexOf('.') == s.length() - 1) {
                return isInteger(s.substring(0, s.length() - 1));
            } else {
                return isInteger(s.substring(0, s.indexOf('.'))) && isInteger(s.substring(s.indexOf('.') + 1));
            }
        }

    }

    public static boolean isInteger(String s) {
        if (s.isEmpty()) return false;
        if ((s.contains("-") && s.indexOf('-') != 0) || (s.contains("+") && s.indexOf('+') != 0)) {
            return false;
        }
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1);
        }
        if(s.isEmpty()) return false;
        for (char ch : s.toCharArray()) {
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumber(String s) {
        String test = s.trim();
        if (!test.contains("e")) {
            return isSingleNumber(test);
        } else {
            if (test.indexOf('e') != test.lastIndexOf('e') || test.indexOf('e') == test.length() - 1) {
                return false;
            }
            return isSingleNumber(test.substring(0, test.indexOf('e'))) && isInteger(test.substring(test.indexOf('e') + 1));
        }

    }
}
