import java.lang.String;
import java.lang.StringBuffer;
import java.lang.System;

public class reverseWords{
    public static void main(String[] args){
        System.out.println(aaa(" the  sky is blue"));

    }
    public static String aaa(String s){
        String[] words=s.trim().split(" +");
        int length=words.length;
        StringBuffer sb=new StringBuffer();
        for (int i=length-1;i>=0;i--){
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}