import java.util.HashMap;

/**
 * Created by noMoon on 2015-01-19.
 */
public class ContainerWithMostWater {
    public static void main(String[] args){
        System.out.println(maxArea(new int[]{1,2,3,4,1,2,1}));
    }

    public static int maxArea(int[] height) {
        int head=0;int tail=height.length-1;
        if(tail<0) return 0;
        int max=(tail-head)*(height[head]>height[tail]?height[tail]:height[head]);
        while(head<tail){
            if(height[head]<height[tail]){
                head++;
                if(height[head]>height[head-1]){
                    int temp=(tail-head)*(height[head]>height[tail]?height[tail]:height[head]);
                    if(temp>max){
                        max=temp;
                    }
                }
            }else{
                tail--;
                if(height[tail]>height[tail+1]){
                    int temp=(tail-head)*(height[head]>height[tail]?height[tail]:height[head]);
                    if(temp>max){
                        max=temp;
                    }
                }
            }
        }
        return max;
    }
}
