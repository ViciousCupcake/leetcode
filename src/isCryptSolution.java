package src;

public class isCryptSolution {
    public static void main(String[] args) {
        System.out.println(isCryptSolution1(new String[] { "SEND", "MORE", "MONEY" }, new char[][] { { 'O', '0' },
                { 'M', '1' }, { 'Y', '2' }, { 'E', '5' }, { 'N', '6' }, { 'D', '7' }, { 'R', '8' }, { 'S', '9' } }));
                System.out.println(Long.MAX_VALUE);
    }

    static boolean isCryptSolution1(String[] crypt, char[][] solution) {
        for (int a = 0; a < crypt.length; a++) {
            crypt[a] = crypt[a].toUpperCase();
            for (char mapping[] : solution) {
                crypt[a] = crypt[a].replaceAll(Character.toString(mapping[0]), Character.toString(mapping[1]));
            }
            if (crypt[a].length()!=Long.toString(Long.parseLong(crypt[a])).length()) {
                return false;
            }
        }

        return Long.parseLong(crypt[0]) + Long.parseLong(crypt[1]) == Long.parseLong(crypt[2]);
    }
}
