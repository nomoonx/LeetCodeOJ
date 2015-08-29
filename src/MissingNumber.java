/**
 * Created by noMoon on 2015-08-29.
 */
public class MissingNumber {
    public static void main(String[] args){
        int[] nums=new int[]{0};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        int n=nums.length+1;
        int misNum=0;
        for(int i=0;i<n;i++){
            misNum^=i;
        }
        for(int num:nums){
            misNum^=num;
        }
        return misNum;
    }
}
