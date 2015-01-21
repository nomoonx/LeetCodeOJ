/**
 * Created by noMoon on 2015-01-21.
 */
public class MaximumSubarray {
    public static void main(String[] args){
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] A) {
        if(A.length==0) return 0;
        int length=A.length;
        int[] maximum=new int[length];
        maximum[0]=A[0];
        int max=maximum[0];
        for(int i=1;i<length;i++){
            if(maximum[i-1]<0) {
                maximum[i]=A[i];
            }else{
                maximum[i]=A[i]+maximum[i-1];
            }
            if(maximum[i]>max){
                max=maximum[i];
            }
        }
        return max;
    }
}
