public class prob67 {
    public static void main(String[] args) {
        System.out.println(addBinary("1010","1011"));
    }
    static public String addBinary(String a, String b) {
        char[] i = a.toCharArray();
        char[] j = b.toCharArray();
        StringBuilder str = new StringBuilder(a.length());
        int carry = 0;
        for(int idx = 0; idx < Math.min(i.length, j.length); idx++) {
            int iidx = i.length - 1 - idx;
            int jidx = j.length - 1 - idx;
            char dig = (char)(((i[iidx] - '0') ^ (j[jidx] - '0') ^ carry) + '0');
            carry = ((i[iidx] - '0') + (j[jidx] - '0') + carry) >> 1;
            str.insert(0, dig);
        }
        char[] remainingStr;
        if(i.length < j.length) {
            remainingStr = j;
        } else {
            remainingStr = i;
        }
        for(int idx = Math.min(i.length, j.length); idx < Math.max(i.length, j.length); idx++) {
            int charidx = Math.max(i.length, j.length) - 1 - idx;
            char dig = (char)(((remainingStr[charidx] - '0') ^ carry) + '0');
            carry = ((remainingStr[charidx] - '0') + carry) >> 1;
            str.insert(0, dig);
        }
        if(carry == 1) {
            str.insert(0, '1');
        }
        return str.toString();
    }
}
