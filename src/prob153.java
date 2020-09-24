package src;

import java.util.Arrays;

public class prob153 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[] { 1,2,3,4,0 }));
        System.out.println(Arrays.asList(1,2,1000).equals(Arrays.asList(1,2,1001)));
    }

    static public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] < nums[1] && nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;

        int mid = 0;
        while (low >= 0 && high > low) {
            mid = (low + high) / 2;
            if (nums[mid] > nums[low]) {
                low = mid;
            } else {
                high = mid;
            }
            System.out.println(low + " " + high);
        }
        return nums[mid + 1];
    }
}
