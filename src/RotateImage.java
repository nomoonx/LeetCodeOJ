/**
 * Created by noMoon on 2015-08-31.
 */
public class RotateImage {
    public static void main(String[] args){
        int[][] matrix=new int[][]{
                {1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}
        };
        rotate(matrix);
        for(int[] row:matrix){
            for(int element:row){
                System.out.print(element);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int upperI=n/2;
        if(n%2==1) upperI++;
        for (int i=0;i<upperI;i++){
            for (int j=i;j<m-i-1;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][m-1-j];
                matrix[n-1-i][m-1-j]=matrix[j][m-1-i];
                matrix[j][m-1-i]=temp;
            }
        }
    }
}
