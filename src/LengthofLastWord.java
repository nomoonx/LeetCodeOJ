/**
 * Created by noMoon on 2015-01-19.
 */
public class LengthofLastWord {
    public static void main(String[] args){
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord(" World"));
        System.out.println(lengthOfLastWord(" "));
    }
    public static int lengthOfLastWord(String s) {
        if(null==s||s.isEmpty()) return 0;
        String[] arrays=s.trim().split(" +");
        if(arrays.length>0){
            String last=arrays[arrays.length-1];
            if(last.isEmpty()){
                return 0;
            }else{
                return last.length();
            }
        }else{
            return s.trim().length();
        }
    }
}
