/**
 * Created by noMoon on 2015-01-21.
 */
public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args){
        System.out.println(findMin(new int[]{2,1}));
    }

    public static int findMin(int[] num) {
        if(num.length==0) return 0;
        int l=0;
        int u=num.length-1;
        while(l<u){
            int m=(l+u)/2;
            if(m!=0&&num[m-1]>num[m]) return num[m];
            if(num[m]<num[u]){
                u=m-1;
            }else{
                l=m+1;
            }
        }
        return num[l];

    }


}
