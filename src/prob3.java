package src;

import java.util.*;

public class prob3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ab"));
    }

    public int lengthOfLongestSubstring_uncompleted(String s) {
        HashMap<Character, HashSet<Integer>> map = new HashMap<Character, HashSet<Integer>>();
        char[] input = s.toCharArray();
        //int max = 0;
        //int start = 0;
        for (int index = 0; index < input.length; index++) {
            if (!map.containsKey(input[index])) {
                map.put(input[index], new HashSet<Integer>(Arrays.asList(index)));
            } else {

            }
        }
        return -1;
    }

    static public int lengthOfLongestSubstring_doesntworkbcdoesntremoveallfromset(String s) {
        int start = 0;
        HashSet<Character> set = new HashSet<Character>();
        char[] input = s.toCharArray();
        int max = 0;
        for (int index = 0; index < input.length; index++) {
            if (set.contains(input[index])) {
                start++;
            } else {
                set.add(input[index]);
            }
            max = Math.max(max, index - start + 1);
        }
        return max;
    }

    static public int lengthOfLongestSubstring(String s) {
        if(s.length()<2){
            return s.length();
        }
        char[] input = s.toCharArray();
        int max = 0;
        for (int index = 0; index < input.length - 1; index++) {
            HashSet<Character> set = new HashSet<Character>();
            int currMax = 0;
            innerLoop:
            for (int startIndex = index; startIndex < input.length; startIndex++) {
                if(set.contains(input[startIndex])){
                    break innerLoop;
                }
                currMax++;
                max = Math.max(currMax, max);
                set.add(input[startIndex]);
            }
        }
        return max;
    }
}
