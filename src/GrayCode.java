import java.util.ArrayList;
import java.util.List;

/**
 * Created by noMoon on 2015-08-29.
 */
public class GrayCode {
    public static void  main(String[] args){
        List<Integer> list=grayCode(2);
        for(int num:list){
            System.out.println(num);
        }
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> gray=new ArrayList<Integer>();
        if(n==0) return gray;
        gray.add(0);
        gray.add(1);
        int num=1;
        for(int i=1;i<n;i++){
            num<<=1;
            int length=gray.size();
            for(int j=0;j<num;j++){
                gray.add(gray.get(length-1-j)+num);
            }
        }
        return gray;
    }
}
