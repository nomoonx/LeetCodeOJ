import java.util.Arrays;

/**
 * Created by noMoon on 2015-01-24.
 */
public class Searcha2DMatrix {
    public static void main(String[] args){
        System.out.println(searchMatrix(new int[][]{
                {1,   3,  5,7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}
        },30));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int length=matrix.length;
        if(0==length) return false;
        int u=length-1,l=0;
        while(l<u){
            int m=(u+l)/2;
            if(matrix[m][0]==target) return true;
            else if(matrix[m][0]<target){
                l=m+1;
            }else{
                u=m-1;
            }
        }
        int indexOne= Arrays.binarySearch(matrix[l],target);
        int indexTwo=-1;
        if(l>0){
            indexTwo=Arrays.binarySearch(matrix[l-1],target);
        }
        return indexOne>=0||indexTwo>=0;
    }
}
