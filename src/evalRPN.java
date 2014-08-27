/**
 * Created by noMoon on 2014-08-27.
 */

import java.util.ArrayList;
import java.util.List;

public class evalRPN {

    public static void main(String[] args){
        String[] input={"4", "13", "5", "/", "+"};
        System.out.println(aaa(input));

    }

    public static int aaa(String[] tokens){
        List<Integer> numberStack=new ArrayList<Integer>();
        for(String token:tokens){
            try {
                int number = Integer.parseInt(token);
                numberStack.add(number);
            }catch(NumberFormatException e){
                if(token.length()>1){
                    return 0;
                }
                int temp=0;
                int length=numberStack.size();
                if(length<2){
                    return 0;
                }
                int numberTwo=numberStack.get(length-1);
                int numberOne=numberStack.get(length-2);
                switch(token.charAt(0)){
                    case '+':
                        temp=numberOne+numberTwo;
                        break;
                    case '-':
                        temp=numberOne-numberTwo;
                        break;
                    case '*':
                        temp=numberOne*numberTwo;
                        break;
                    case '/':
                        temp=numberOne/numberTwo;
                        break;
                }
                numberStack.remove(length-1);
                numberStack.remove(length-2);
                numberStack.add(temp);
            }
        }
        return numberStack.get(0);
    }
}
