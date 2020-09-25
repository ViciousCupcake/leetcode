package src;

import java.util.*;

public class prob12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
    }

    static public String intToRoman(int num) {
        LinkedHashMap<Integer, String> mapping = new LinkedHashMap<Integer, String>();

        mapping.put(1000, "M");
        mapping.put(900, "CM");
        mapping.put(500, "D");
        mapping.put(400, "CD");
        mapping.put(100, "C");
        mapping.put(90, "XC");
        mapping.put(50, "L");
        mapping.put(40, "XL");
        mapping.put(10, "X");
        mapping.put(9, "IX");
        mapping.put(5, "V");
        mapping.put(4, "IV");
        mapping.put(1, "I");
        StringBuilder output = new StringBuilder();
        Iterator<Integer> iterator = mapping.keySet().iterator();
        while(iterator.hasNext()&&num!=0){
            int currKey = (Integer) iterator.next();
            while(num >= currKey){
                output.append(mapping.get(currKey));
                num -= currKey;
            }
        }
        return output.toString();
    }
}
