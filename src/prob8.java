package src;

public class prob8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("-9223372036854775809"));
    }

    static public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        boolean negative = false;
        long answer = 0;
        for (int index = 0; index < str.length(); index++) {
            if (Math.abs(answer) > 2147483648l) { // This question has weird runtime scale, setting number to
                                                  // Integer.MAX_VALUE + 1 takes 15ms, but setting number to 10^14 takes
                                                  // 6ms??
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            switch (str.charAt(index)) {
                case '+':
                    if (index != 0) {
                        return getAnswer(answer, negative);
                    }
                    break;
                case '-':
                    if (index == 0) {
                        negative = true;
                    } else { // todo;
                        return getAnswer(answer, negative);
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    answer = answer * 10 + str.charAt(index) - '0';
                    break;
                default:
                    return getAnswer(answer, negative);
            }
        }
        return getAnswer(answer, negative);
    }

    static public int getAnswer(long result, boolean isNegative) {
        result *= isNegative ? -1 : 1;
        System.out.println(result);
        if (result < 0) {
            return (int) Math.max((long) Integer.MIN_VALUE, result);
        } else {
            return (int) Math.min((long) Integer.MAX_VALUE, result);
        }
    }
}
