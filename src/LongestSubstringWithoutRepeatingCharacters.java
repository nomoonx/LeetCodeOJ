/**
 * Created by noMoon on 2015-01-09.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){

        System.out.println(3^4);
        int result=lengthOfLongestSubstring("bbbabbb");
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        if(null==s||s.isEmpty()) return 0;
        int[] lengths=new int[s.length()];
        int max=1;
        int last=0;
        lengths[0]=1;
        for(int i=1;i<s.length();i++){
            for(int j=last;j<=i-1;j++){
                if(s.charAt(i)==s.charAt(j)){
                    lengths[i]=i-j;
                    last=j+1;
                    break;
                }
                if(j==i-1){
                    lengths[i]=lengths[i-1]+1;
                }
            }
            if(lengths[i]>max){
                max=lengths[i];
            }
        }
        return max;
    }
}
