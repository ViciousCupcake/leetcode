package src;

import java.util.Set;
import java.util.LinkedHashMap;

public class prob13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MMMXLV"));
    }

    static public int romanToInt(String s) {
        int output = 0;
        LinkedHashMap<String, Integer> mapping = new LinkedHashMap<String, Integer>();
        mapping.put("CM", 900);
        mapping.put("CD", 400);
        mapping.put("XC", 90);
        mapping.put("XL", 40);
        mapping.put("IX", 9);
        mapping.put("IV", 4);
        mapping.put("M", 1000);
        mapping.put("D", 500);
        mapping.put("C", 100);
        mapping.put("L", 50);
        mapping.put("X", 10);
        mapping.put("V", 5);
        mapping.put("I", 1);
        Set<String> keys = mapping.keySet();
        for (String key : keys) {
            //System.out.println(key);
            while (s.contains(key)) {
                s = s.replaceFirst(key, "");
                output += (mapping.get(key));
            }
        }
        return output;
    }
}
