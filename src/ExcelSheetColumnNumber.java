/**
 * Created by noMoon on 2014-12-30.
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args){
        System.out.println(titleToNumber("AZ"));
    }

    public static int titleToNumber(String s) {
        int sum=0;
        for (char ch:s.toCharArray()){
            sum=sum*26+Integer.valueOf(ch)-Integer.valueOf('A')+1;
        }
        return sum;
    }
}
