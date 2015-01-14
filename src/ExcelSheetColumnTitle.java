/**
 * Created by noMoon on 2015-01-13.
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args){
        System.out.println(convertToTitle(2));
        System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(26));
    }

    public static String convertToTitle(int n) {
        if(n<=0) return null;
        String result="";
        while(n/26>0){
            if(n%26==0){
                result='Z'+result;
                n-=26;
            }
            else
                result=(char)('A'+n%26-1)+result;
            n/=26;
        }
        if(n>0)
            result=(char)('A'+n%26-1)+result;
        return result;
    }
}
