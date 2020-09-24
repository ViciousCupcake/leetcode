package src;

import java.util.*;

public class prob217 {
    public static void main(String[] args) {
        System.out.println(Arrays.asList(new int[]{1,2,3}));
    }

    static public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int a:nums){
            if(!set.add(a)){
                return true;
            }
        }
        //set.addAll(Arrays.asList(nums));
        //return nums.length != set.size();
        return false;
    }
}
