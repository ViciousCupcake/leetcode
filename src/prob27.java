package src;

import java.util.Arrays;

public class prob27 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }
    static public int removeElement(int[] nums, int val) {
        int placementIndex = 0;
        for(int a = 0;a<nums.length;a++){
            if(nums[a]!=val){
                nums[placementIndex++]=nums[a];
            }
        }
        return placementIndex;
    }
}
