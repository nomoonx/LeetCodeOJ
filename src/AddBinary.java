/**
 * Created by noMoon on 2015-01-08.
 */
public class AddBinary {
    public static void main(String[] args){
        System.out.println(addBinary("11111","11111"));
    }

    public static String addBinary(String a, String b) {
        if((null==a||0==a.length())&&(null==b||0==b.length())) return null;
        if(null==a||0==a.length()) return b;
        if(null==b||0==b.length()) return a;
        int taila=a.length()-1;
        int tailb=b.length()-1;
        String result="";
        int flag=0;
        while(taila>=0&&tailb>=0){
            char ch= (char) ('0'+(a.charAt(taila) - '0' + b.charAt(tailb) - '0' + flag)%2);
            flag=(a.charAt(taila--) - '0' + b.charAt(tailb--) - '0' + flag)/2;
            result=ch+result;
        }
        while(taila>=0){
            char ch=(char) ('0'+(a.charAt(taila) - '0' + flag)%2);
            flag=(a.charAt(taila--) - '0' + flag)/2;
            result=ch+result;
        }
        while(tailb>=0){
            char ch= (char) ('0'+(b.charAt(tailb) - '0' + flag)%2);
            flag=(b.charAt(tailb--) - '0' + flag)/2;
            result=ch+result;
        }
        if(flag==1) result="1"+result;
        return result;
    }
}
