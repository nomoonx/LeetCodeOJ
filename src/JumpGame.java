/**
 * Created by noMoon on 2015-01-18.
 */
public class JumpGame {
    public static void main(String[] args) {
//        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
//        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{1,2,3}));
    }

    public static boolean canJump(int[] A) {
        if (A.length == 0) return false;
        if (A.length == 1) return true;
        int length = A.length;
        int max=A[0];
        for (int i = 0; i < length; i++) {
            if(i<=max){
                if(i+A[i]>max){
                    max=i+A[i];
                }
            }
            if(max>=length-1) return true;
        }
        return false;
    }
}
