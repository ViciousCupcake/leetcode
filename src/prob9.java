package src;

/**
 * prob9
 */
public class prob9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }

    static public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        return x == reverse(x);
    }

    static public int reverse(int copy) {
        int reverse = 0;

        while (copy != 0) {
            reverse = reverse * 10 + copy % 10;
            copy /= 10;
        }
        return reverse;
    }
}