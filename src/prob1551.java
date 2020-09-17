package src;

public class prob1551 {
    public static void main(String[] args) {
        System.out.println(minOperations(6));
    }

    static public int minOperations(int n) {
        if (n < 2)
            return 0;
        if (n % 2 == 0) {
            return (int) Math.pow((double) (n / 2), 2.0);
        } else {
            return (n / 2) * (n / 2 + 1);
        }
    }
}
