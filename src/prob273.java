package src;

public class prob273 {
    public static void main(String[] args) {
        System.out.println(numberToWords(50868));
    }

    static public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        final String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                "Nineteen" };
        final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
                "Ninety" };
        final String[] THOUSANDS = { "Billion", "Million", "Thousand", "" };
        final int[] radix = { 1000000000, 1000000, 1000, 1 };
        StringBuilder output = new StringBuilder();
        for (int index = 0; index < radix.length; index++) {
            int currRadix = radix[index];
            if (num >= currRadix) {
                int amountOfRadix = num / currRadix;
                num %= currRadix;
                if (amountOfRadix >= 100) {
                    output.append(' ');
                    output.append(LESS_THAN_20[amountOfRadix / 100]);
                    output.append(" Hundred");
                    amountOfRadix %= 100;
                }
                if (amountOfRadix >= 20) {
                    output.append(' ');
                    output.append(TENS[amountOfRadix / 10]);
                    amountOfRadix %= 10;
                }
                if (amountOfRadix != 0) {
                    output.append(' ');
                    output.append(LESS_THAN_20[amountOfRadix]);
                }
                output.append(' ');
                output.append(THOUSANDS[index]);

            }
        }
        return output.toString().trim();

    }
}
