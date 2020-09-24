package src;

import java.util.Arrays;

public class prob14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] { "tomatoaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "tomatoaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "tomato", "tomato", "tomato", "tomato",
                "tomato", "tomato", "tomato", "tomato", "tomato", "tomato", "tomato" }));
        String[] temp = new String[] { "test", "testa", "asd" };
        Arrays.sort(temp);
        System.out.println(Arrays.toString(temp));
    }

    static public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        Arrays.sort(strs);
        /**
         * Sort because first and last string after sorting will be the most different.
         * Sorting will organize strings in similarity from string.charAt(0) to last index
         */
        StringBuilder output = new StringBuilder();

        int lastIndex = strs.length - 1;
        for (int index = 0; index < strs[0].length(); index++) {
            if (strs[lastIndex].length() <= index || strs[0].charAt(index) != strs[lastIndex].charAt(index)) {
                return output.toString();
            }
            output.append(strs[0].charAt(index));
        }
        return output.toString();

    }

    static public String new_old(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder output = new StringBuilder();
        for (int index = 0; index < strs[0].length(); index++) {
            for (int arrayIndex = 1; arrayIndex < strs.length; arrayIndex++) {
                if (strs[arrayIndex].length() <= index || strs[0].charAt(index) != strs[arrayIndex].charAt(index)) {
                    return output.toString();
                }

            }
            output.append(strs[0].charAt(index));
        }
        return output.toString();

    }

    public static String old(String[] strs) {

        StringBuilder output = new StringBuilder();
        int index = -1;
        char currentChar = '\u0000';
        try {
            while (++index > -1) {
                currentChar = '\u0000';
                for (String s : strs) {
                    if (currentChar == '\u0000') {
                        currentChar = s.charAt(index);
                    } else {
                        if (s.charAt(index) != currentChar)
                            return output.toString();
                    }
                }
                output.append(currentChar);
            }
        } catch (Exception e) {
            return output.toString();
        }
        return "";

    }
}
