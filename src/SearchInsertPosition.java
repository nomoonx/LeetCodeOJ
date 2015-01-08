/**
 * Created by noMoon on 2015-01-03.
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] array=new int[]{1,3,5,6};
        System.out.println(searchInsert(array,5));
        System.out.println(searchInsert(array,2));
        System.out.println(searchInsert(array,4));
        System.out.println(searchInsert(array,7));
        System.out.println(searchInsert(array,0));
    }

    public static int searchInsert(int[] A, int target) {
        int l = 0;
        int u = A.length - 1;
        if(target<A[0]) return 0;
        if(target>A[u]) return u+1;
        while(l<=u){
            int m=(l+u)/2;
            if(A[m]==target) return m;
            else if(A[m]<target){
                l=m+1;
            }else if(A[m]>target){
                u=m-1;
            }
        }
        return l;
    }
}
