package src;

import java.util.*;

public class prob15 {
    // https://fizzbuzzed.com/top-interview-questions-1/

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }

    static public List<List<Integer>> threeSum(int[] nums) {
        //Should be o(n^2ish) but apparently isn't
        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        HashSet<List<Integer>> output = new HashSet<List<Integer>>();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        for (int index = 0; index < nums.length; index++) {
            if (!map.containsKey(nums[index])) {
                HashSet<Integer> tempSet = new HashSet<Integer>();
                tempSet.add(index);
                map.put(nums[index], tempSet);
            } else {
                map.get(nums[index]).add(index);
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int index1 = 0; index1 < nums.length - 2; index1++) {
            if (index1 != 0 && nums[index1] == nums[index1 - 1])
                continue;
            for (int index2 = index1 + 1; index2 < nums.length - 1; index2++) {

                int solution = -1 * (nums[index1] + nums[index2]);
                if (map.containsKey(solution)) {
                    for (int indicies : map.get(solution)) {
                        if (indicies > index2) {
                            ArrayList<Integer> answer = new ArrayList<Integer>(
                                    Arrays.asList(nums[index1], nums[index2], nums[indicies]));
                            Collections.sort(answer);
                            output.add(answer);
                            // break innerLoop;
                        }
                    }
                }
            }
        }
        // System.out.println(output);
        return new ArrayList<List<Integer>>(output);
    }
}