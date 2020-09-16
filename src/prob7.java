package src;

public class prob7 {
    public static void main(String[] args) {
        System.out.println(reverse(-120));
    }

    static public int reverse(int x) {
        try {
            boolean negative = x < 0;
            if (negative) {
                x *= -1;
            }
            x = Integer.parseInt((new StringBuilder(Integer.toString(x)).reverse()).toString());
            if (negative) {
                x *= -1;
            }
            return x;
        } catch (Exception e) {
        }
        return 0;

    }
}
