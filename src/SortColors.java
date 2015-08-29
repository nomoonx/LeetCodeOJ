/**
 * Created by noMoon on 2015-08-28.
 */
public class SortColors {
    public static void main(String[] args){
        int[] nums=new int[]{1,2,1,1,0};
        sortColors(nums);
        for(int num:nums){
            System.out.println(num);
        }
    }

    public static void sortColors(int[] nums) {
        int head=0;int tail=nums.length-1;
        for(int i=0;i<=tail;i++){
            if(nums[i]==0){
                nums[i]=nums[head];
                nums[head]=0;
                if(head!=i){
                    i--;
                }
                head++;
            }
            else if(nums[i]==2){
                nums[i]=nums[tail];
                nums[tail]=1;
                if(tail!=i){
                    i--;
                }
                tail--;
            }
        }
    }
}
