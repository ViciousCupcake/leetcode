package src;

public class prob6 {
    public static void main(String[] args) {
        System.out.println(convert("a", 2));
    }

    static public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] list = new StringBuilder[numRows];
        for (int i = 0; i < list.length; i++)
            list[i] = new StringBuilder();
        boolean goingDown = true;
        int rowIndex = -1;
        for (int index = 0; index < s.length(); index++) {
            if (goingDown) {
                rowIndex++;
            } else {
                rowIndex--;
            }
            list[rowIndex].append(s.charAt(index));
            if (goingDown && rowIndex == numRows - 1) {
                goingDown = false;
            } else if ((!goingDown) && rowIndex == 0) {
                goingDown = true;
            }
        }
        for (int tknzrIndex = 1; tknzrIndex < numRows; tknzrIndex++) {
            list[0].append(list[tknzrIndex]);
        }
        return list[0].toString();
    }
}
