package src;

import java.text.*;
import java.util.*;

public class prob1556 {
    public static void main(String[] args) {
        System.out.println(thousandSeparator(1000000));
    }

    static public String thousandSeparator(int n) {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMANY);
        DecimalFormat df = (DecimalFormat) nf;
        df.applyPattern("###,###,###,###,###,###,###,###,###,###,###");
        return df.format(n);

    }
}
