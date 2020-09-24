package src;

import java.util.*;

public class prob22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesisRecursive(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), 0, 0, n);
        return res;
   }
    /**
     * This method is not efficient
     * 
     * @param n the number of sets of parenthesis.
     * @return all valid combinations
     */
    static public List<String> generateParenthesis_iterative(int n) {
        if (n == 0) {
            return new ArrayList<String>();
        }
        LinkedList<StringBuilder> list = new LinkedList<StringBuilder>();
        list.add(new StringBuilder("()"));
        while (list.peek().length() != 2 * n) {
            for (int index = 0; index <= list.peek().length(); index++) {
                StringBuilder temp = new StringBuilder(list.peek().toString());
                temp.insert(index, "()");
                list.add(temp);
            }
            list.poll();
        }
        Set<String> output = new HashSet<String>();
        list.forEach(current -> output.add(current.toString()));
        return new ArrayList<String>(output);
    }

    static public List<String> generateParenthesisRecursive(int n) {
        OutputWrapper initial = new OutputWrapper(n - 1, n, 1);
        initial.sb.append('(');
        List<OutputWrapper> outputs = generateParenthesisHelper(initial);
        List<String> output = new ArrayList<String>();
        outputs.forEach(current -> output.add(current.sb.toString()));
        /*
         * for (OutputWrapper current : outputs) {
         * 
         * }
         */
        return output;
    }

    static public List<OutputWrapper> generateParenthesisHelper(OutputWrapper input) {
        ArrayList<OutputWrapper> outputs = new ArrayList<OutputWrapper>();

        if (input.remainingCloseParenthesis + input.remainingParenthesis != 0) {
            if (input.remainingParenthesis != 0) {
                OutputWrapper addOpen = input.copy();
                addOpen.sb.append('(');
                addOpen.remainingParenthesis--;
                addOpen.unclosedParenthesis++;
                outputs.addAll(generateParenthesisHelper(addOpen));

            }
            if (input.remainingCloseParenthesis != 0 && input.unclosedParenthesis != 0) {
                OutputWrapper addClose = input.copy();
                addClose.sb.append(')');
                addClose.remainingCloseParenthesis--;
                addClose.unclosedParenthesis--;
                outputs.addAll(generateParenthesisHelper(addClose));
            }
        } else {
            return new ArrayList<OutputWrapper>(Arrays.asList(input));
        }

        return outputs;
    }



    private void helper(List<String> res, StringBuilder sb, int open, int close, int n) {
        if (open == n && close == n) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            helper(res, sb, open + 1, close, n);
            sb.setLength(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            helper(res, sb, open, close + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }
}
class OutputWrapper {
    int remainingParenthesis;
    int remainingCloseParenthesis;
    int unclosedParenthesis;
    StringBuilder sb;

    public OutputWrapper(int remainingParenthesis, int remainingCloseParenthesis, int unclosedParenthesis) {
        this.remainingParenthesis = remainingParenthesis;
        this.remainingCloseParenthesis = remainingCloseParenthesis;
        this.unclosedParenthesis = unclosedParenthesis;
        this.sb = new StringBuilder();
    }

    public OutputWrapper(int remainingParenthesis, int remainingCloseParenthesis, int unclosedParenthesis,
            StringBuilder sb) {
        this.remainingParenthesis = remainingParenthesis;
        this.remainingCloseParenthesis = remainingCloseParenthesis;
        this.unclosedParenthesis = unclosedParenthesis;
        this.sb = new StringBuilder(sb.toString());
    }

    OutputWrapper copy() {
        return new OutputWrapper(this.remainingParenthesis, this.remainingCloseParenthesis, this.unclosedParenthesis,
                this.sb);
    }
}
