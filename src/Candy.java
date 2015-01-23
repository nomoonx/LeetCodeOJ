/**
 * Created by noMoon on 2015-01-22.
 */
public class Candy {
    public static void main(String[] args){
        System.out.println(candy(new int[]{1,2,4,4,3}));
    }

    public static int candy(int[] ratings) {
        int length=ratings.length;
        int[] candy=new int[length];
        for(int i=0;i<length;i++){
            candy[i]=1;
        }
        for(int i=0;i<length;i++){
            int j=i+1;
            for(;j<length;j++){
                if(ratings[j]>=ratings[j-1]){
                    break;
                }
            }
            if(0==i){
                for(int k=j-1;k>=i;k--){
                    candy[k]+=j-1-k;
                }
            }else{
                if(ratings[i]>ratings[i-1]){
                    candy[i]=candy[i-1]+1>candy[j-1]+j-1-i?candy[i-1]+1:candy[j-1]+j-1-i;
                    for(int k=j-1;k>i;k--){
                        candy[k]+=j-1-k;
                    }
                }else{
                    for(int k=j-1;k>=i;k--){
                        candy[k]+=j-1-k;
                    }
                }
            }
            i=j-1;
        }
        int sum=0;
        for(int i=0;i<length;i++){
            sum+=candy[i];
        }
        return sum;
    }
}
