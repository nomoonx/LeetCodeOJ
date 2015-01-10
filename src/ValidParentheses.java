import java.util.ArrayList;
import java.util.List;

/**
 * Created by noMoon on 2015-01-09.
 */
public class ValidParentheses {
    public  static void main(String[] args){
        System.out.println(isValid("[({})]"));
        System.out.println(isValid("["));
        System.out.println(isValid("[]"));

        System.out.println(isValid("[((((("));
        System.out.println(isValid("]"));
        System.out.println(isValid("["));
        System.out.println(isValid("["));

    }
    public static boolean isValid(String s) {
        String left="[({";
        String pair="[] () {}";
        if(s.isEmpty()) return false;
        List<String> stack=new ArrayList<String>();
        for(int i=0;i<s.length();i++){
            if(left.contains(""+s.charAt(i))){
                stack.add(""+s.charAt(i));
            }else{
                if(stack.size()>0&&pair.contains(stack.get(stack.size() - 1)+s.charAt(i))){
                    stack.remove(stack.size()-1);
                }else{
                    return false;
                }
            }
        }
        return stack.size()==0;
    }
}
