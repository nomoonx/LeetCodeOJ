/**
 * Created by noMoon on 2015-01-18.
 */
public class BestTimetoBuyandSellStockII {
    public static void main(String args[]){

    }
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int length=prices.length;
        int sum=0;
        for(int i=0;i<length-1;i++){
            if(prices[i]<prices[i+1])
                sum+=prices[i+1]-prices[i];
        }
        return sum;
    }
}
