/**
 * Created by noMoon on 2014-12-30.
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args){
        int[] prices=new int[]{2,2,3,4,1,9};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int result=0;
        int max=prices[0];
        int min=prices[0];
        int length=prices.length;
        for (int i=1;i<length;i++){
            if(prices[i]>max){
                max=prices[i];
            }if(prices[i]<min){
                if(max-min>result){
                    result=max-min;
                }
                max=prices[i];
                min=prices[i];
            }
        }
        if(max-min>result){
            result=max-min;
        }
        return result;
    }
}
