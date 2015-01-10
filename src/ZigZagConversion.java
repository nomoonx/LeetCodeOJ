/**
 * Created by noMoon on 2015-01-09.
 */
public class ZigZagConversion {
    public static void main(String[] args){
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("AB", 4));
        System.out.println(convert("ABCDE", 4));

    }

    public static String convert(String s, int nRows) {
        if(s.isEmpty()||nRows==1) return s;
        int m=nRows*2-2;
        int times=s.length()/m;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=times;i++){
            if(i*m<s.length())
            sb.append(s.charAt(i*m));
        }
        for(int i=1;i<nRows-1;i++){
            for(int j=0;j<=times;j++){
                if(j*m+i<s.length())
                sb.append(s.charAt(j*m+i));
                if(j*m+m-i<s.length())
                sb.append(s.charAt(j*m+m-i));
            }
        }
        for(int i=0;i<=times;i++){
            if(i*m+nRows-1<s.length())
            sb.append(s.charAt(i*m+nRows-1));
        }
        return sb.toString();

    }
}
