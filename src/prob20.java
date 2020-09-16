package src;

import java.util.LinkedList;

/**
 * prob20
 */
public class prob20 {

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

    static public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for (char currentCharacter : s.toCharArray()) {
            switch (currentCharacter) {
                case '(':
                case '{':
                case '[':
                    stack.push(currentCharacter);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

    static public boolean old(String s) {
        if (s.length() % 2 == 1)
            return false;
        if (countOccurrences(s, '{') != countOccurrences(s, '}') || countOccurrences(s, '[') != countOccurrences(s, ']')
                || countOccurrences(s, '(') != countOccurrences(s, ')'))
            return false;
        LinkedList<Character> stack = new LinkedList<Character>();
        for (char currentCharacter : s.toCharArray()) {
            if (currentCharacter == '(' || currentCharacter == '[' || currentCharacter == '{')
                stack.push(currentCharacter);
            else {
                if (stack.peek() == null)
                    return false;
                if (currentCharacter == ')' && stack.peek() != '(')
                    return false;
                if (currentCharacter == ']' && stack.peek() != '[')
                    return false;
                if (currentCharacter == '}' && stack.peek() != '{')
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    static public int countOccurrences(String input, char wantToFind) {
        return input.length() - input.replace(Character.toString(wantToFind), "").length();
    }
}