package src;

import java.util.Arrays;

/**
 * prob1
 */
public class prob1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] { 3,2,4 }, 7)));
    }

    static public int[] twoSum(int[] nums, int target) {
        for (int a = 0; a < nums.length - 1; a++) {
            int solution = target - nums[a];
            for (int b = a + 1; b < nums.length; b++) {
                if (nums[b] == solution) {
                    return new int[] { a, b };
                }
            }
        }
        return new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE };
    }
}