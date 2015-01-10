import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by noMoon on 2015-01-08.
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args){
        int[] array=new int[]{};
        System.out.println(removeDuplicates(array));
        array=new int[]{1,1,2,3};
        System.out.println(removeDuplicates(array));
        for(int a:array){
            System.out.println(a);
        }
    }

    public static int removeDuplicates(int[] A) {

        if(null==A||0==A.length) return 0;
        int tail=0;


        for(int i=1;i<A.length;i++){
            if(A[i]!=A[tail]){
                A[++tail]=A[i];
            }
        }
        return tail+1;
    }
}
