package src;

public class prob35 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
    }
    static public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        if(nums[0]>target){
            return 0;
        }
        while(low>=0&&high>=low){
            int mid = (low+high)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(low == mid){
                return mid + 1;
            }
            if(target>nums[mid]){
                low = mid;
            }
            else{
                high = mid;
            }
            System.out.println("loop"+low+" "+high);
        }
        return Integer.MAX_VALUE;
    }
}
