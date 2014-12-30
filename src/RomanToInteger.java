import java.util.*;

/**
 * Created by noMoon on 2014-12-28.
 */
public class RomanToInteger {
    public static void  main(String[] args){
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("MCMXCVI"));
        System.out.println(romanToInt("MCDXXXVII"));
        System.out.println(romanToInt("MDCCCLXXX"));
        System.out.println(romanToInt("MMMCCCXXXIII"));

    }

    public static int romanToInt(String s) {
        List<String> romanList=new ArrayList<String>(Arrays.asList("I","V","X","L","C","D","M"));
        Map<String,Integer> romanMap=new HashMap<String,Integer>();
        romanMap.put("I",1);
        romanMap.put("V",5);
        romanMap.put("X",10);
        romanMap.put("L",50);
        romanMap.put("C",100);
        romanMap.put("D",500);
        romanMap.put("M",1000);
        List<String> leftMinusList=new ArrayList<String>(Arrays.asList("I","X","C"));
        int sum=0;
        int length=s.length();
        for(int i=0;i<length-1;i++){
            if(leftMinusList.contains(s.substring(i, i+1))){
                if(romanList.indexOf(s.substring(i+1,i+2))>romanList.indexOf(s.substring(i, i+1))){
                    sum-=romanMap.get(s.substring(i, i+1));
                }else{
                    sum+=romanMap.get(s.substring(i,i+1));
                }
            }else{
                sum+=romanMap.get(s.substring(i,i+1));
            }
        }
        sum+=romanMap.get(s.substring(length-1,length));

        return sum;
    }
}
