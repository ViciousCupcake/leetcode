package src;

import java.util.*;

public class prob16 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
    }

    /**
     * @param nums the input array, where nums.length >= 3
     */
    static public int threeSumClosest(int[] nums, int target) {
        // Two Pointer Approach
        Arrays.sort(nums);
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            // j is left pointer; k is right pointer, if sum > target, move right pointer 1
            // index to the left. This will decrease the sum since nums is sorted. If sum <
            // target, vice versa.
            int j = i + 1;
            int k = nums.length - 1;
            while (j != k && j < nums.length && k > i) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                minDist = Math.abs(minDist) < Math.abs(sum - target) ? minDist : sum - target;
                if (sum > target)
                    k--;
                else
                    j++;
            }
        }
        return minDist + target;
    }
}
