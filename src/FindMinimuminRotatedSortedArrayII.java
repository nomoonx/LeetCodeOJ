/**
 * Created by noMoon on 2015-01-23.
 */
public class FindMinimuminRotatedSortedArrayII {
    public static void main(String[] args){
        System.out.println(findMin(new int[]{3,3}));
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
            }else if(num[m]>num[u]){
                l=m+1;
            }else{
                while(num[m]==num[u]&&m<u){
                    u--;
                }
            }
        }
        return num[l];

    }
}
