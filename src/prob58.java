package src;

import java.util.StringTokenizer;

public class prob58 {
    public static void main(String[] args) {
        
    }
    static public int lengthOfLastWord_old(String s) {
        String[] words = s.split(" ");
        if(words.length==0){
            return 0;
        }
        return (words[words.length-1].length());
    }
    public int lengthOfLastWord(String s) {
        String prev = "";
        StringTokenizer strTknzr = new StringTokenizer(s);
        while(strTknzr.hasMoreTokens()){
            prev = strTknzr.nextToken();
        }
        return prev.length();
    }
}
