// Leetcode 283
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length <=1){
            return;
        }
        int numZeros = 0;
        int insertionIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=0){
                nums[insertionIndex++] = nums[i];
            }
            else{
                numZeros++;
            }
        }
        for(int j = 0; j<numZeros;j++){
            nums[nums.length-1-j] = 0;
        }
        //return nums;
    }
}