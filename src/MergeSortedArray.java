/**
 * Created by noMoon on 2015-01-22.
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 0, 0};
        merge(A, 3, new int[]{2, 4}, 2);
        for (int a : A) {
            System.out.println(a);
        }
    }

    public static void merge(int A[], int m, int B[], int n) {
        int pointerA = m - 1;
        int pointerB = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (pointerB < 0) {
                break;
            }
            if (pointerA < 0) {
                A[i] = B[pointerB--];
            } else {
                if (A[pointerA] > B[pointerB] && pointerA >= 0) {
                    A[i] = A[pointerA--];
                } else if (pointerB >= 0) {
                    A[i] = B[pointerB--];
                }
            }
        }
    }
}
