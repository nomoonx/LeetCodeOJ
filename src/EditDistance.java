/**
 * Created by noMoon on 2015-08-30.
 */
public class EditDistance {
    public static void main(String[] args){
        System.out.println(minDistance("a","a"));
    }

    public static int minDistance(String word1, String word2) {
        int length1=word1.length();
        int length2=word2.length();
        int[][] distance=new int[length1+1][length2+1];

        for(int i=0;i<=length1;i++){
            distance[i][0]=i;
        }
        for(int j=0;j<=length2;j++){
            distance[0][j]=j;
        }
        for(int i=1;i<=length1;i++){
            for(int j=1;j<=length2;j++){
                int temp=0;
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    temp=1;
                }
                temp+=distance[i-1][j-1];
                if(distance[i-1][j]+1<distance[i][j-1]+1){
                    if(temp<distance[i-1][j]+1){
                        distance[i][j]=temp;
                    }else{
                        distance[i][j]=distance[i-1][j]+1;
                    }
                }else{
                    if(temp<distance[i][j-1]+1){
                        distance[i][j]=temp;
                    }else{
                        distance[i][j]=distance[i][j-1]+1;
                    }
                }
            }
        }
        return distance[length1][length2];
    }
}
