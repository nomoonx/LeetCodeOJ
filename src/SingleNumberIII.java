import java.util.ArrayList;

/**
 * Created by noMoon on 2015-08-29.
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int sum=0;
        for (int num:nums){
            sum^=num;
        }
        String bitNumbers=Integer.toBinaryString(sum);
        int length=bitNumbers.length();
        int index=-1;
        for (int i=length-1;i>=0;i--){
            if(bitNumbers.charAt(i)=='1'){
                index=length-1-i;
                break;
            }
        }
        ArrayList<Integer> listOne=new ArrayList<Integer>();
        ArrayList<Integer> listTwo=new ArrayList<Integer>();
        for(int num:nums){
            String tempBitNumbers=Integer.toBinaryString(num);
            int tempLength=tempBitNumbers.length();
            if(tempLength>=index+1){
                if(tempBitNumbers.charAt(tempLength-1-index)=='1'){
                    listOne.add(num);
                }else{
                    listTwo.add(num);
                }
            }
            else{
                listTwo.add(num);
            }
        }
        int numberOne=0;
        for(Integer num:listOne){
            numberOne^=num;
        }
        int numberTwo=0;
        for(Integer num:listTwo){
            numberTwo^=num;
        }
        return new int[]{numberOne,numberTwo};
    }
}
