/**
 * Created by noMoon on 2015-01-12.
 */
public class TrappingRainWater {
    public static void main(String[] args){
        int[] array=new int []{0,1,0,2,1,0,1,3,2,1,3,1};
        System.out.println(trap(array));
    }

    public static int trap(int[] A) {
        int length=A.length;
        if(length==0) return 0;
        int max=A[0];
        int maxindex=0;

        int sum=A[0];
        for (int i=1;i<length;i++){
            if(A[i]>max) {
                max=A[i];
                maxindex=i;
            }
            sum+=A[i];
        }
        int water=0;
        int low=0;
        for (int i=0;i<maxindex;i++){
            if(low<A[i]){
                low=A[i];
            }
            water+=low;
        }
        low=0;
        for(int i=length-1;i>maxindex;i--){
            if(low<A[i]){
                low=A[i];
            }
            water+=low;
        }
        return water+max-sum;
    }
}
