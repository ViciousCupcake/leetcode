package src;

import java.util.Arrays;

public class prob36 {
    public static void main(String[] args) {
        char[][] grid = { { '.', '4', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '4', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '1', '.', '.', '7', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '3', '.', '.', '.', '6', '.' },
                { '.', '.', '.', '.', '.', '6', '.', '9', '.' }, { '.', '.', '.', '.', '1', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '2', '.', '.' }, { '.', '.', '.', '8', '.', '.', '.', '.', '.' } };
        System.out.println(isValidSudoku(grid));
    }

    static public boolean isValidSudoku(char[][] grid) {
        boolean numbers1[] = new boolean[grid.length + 1];
        boolean numbers2[] = new boolean[grid.length + 1];
        boolean numbers3[] = new boolean[grid.length + 1];
        for (int a = 0; a < grid.length; a++) {
            Arrays.fill(numbers1, false);
            Arrays.fill(numbers2, false);
            Arrays.fill(numbers3, false);

            for (int c = 0; c < grid.length; c++) {
                if (grid[c][a] != '.') {
                    if (!numbers1[grid[c][a] - '0'])
                        numbers1[grid[c][a] - '0'] = true;
                    else {
                        return false;
                    }
                }

                if (grid[a][c] != '.') {
                    if (!numbers2[grid[a][c] - '0'])
                        numbers2[grid[a][c] - '0'] = true;
                    else {
                        return false;
                    }
                }
                if (grid[(a / 3) * 3 + (c / 3)][(a % 3) * 3 + (c % 3)] != '.') {
                    if (!numbers3[grid[(a / 3) * 3 + (c / 3)][(a % 3) * 3 + (c % 3)] - '0'])
                        numbers3[grid[(a / 3) * 3 + (c / 3)][(a % 3) * 3 + (c % 3)] - '0'] = true;
                    else {
                        return false;
                    }
                }
            }
        }

        return true;

    }

    public boolean isValidSudoku_old(char[][] grid) {
        boolean numbers[] = new boolean[grid.length + 1];
        for (int a = 0; a < grid.length; a++) {
            Arrays.fill(numbers, false);
            for (int c = 0; c < grid.length; c++) {
                if (grid[c][a] == '.')
                    continue;
                if (!numbers[grid[c][a] - '0'])
                    numbers[grid[c][a] - '0'] = true;
                else {
                    return false;
                }
            }
            Arrays.fill(numbers, false);

            for (int c = 0; c < grid.length; c++) {
                if (grid[a][c] == '.')
                    continue;
                if (!numbers[grid[a][c] - '0'])
                    numbers[grid[a][c] - '0'] = true;
                else {
                    return false;
                }
            }
            Arrays.fill(numbers, false);

        }
        for (int d = 0; d < 3; d++) {
            for (int e = 0; e < 3; e++) {
                for (int f = 0; f < 3; f++) {
                    for (int g = 0; g < 3; g++) {
                        System.out.println(d * 3 + f + " " + (e * 3 + g));
                        if (grid[d * 3 + f][e * 3 + g] == '.')
                            continue;
                        if (!numbers[grid[d * 3 + f][e * 3 + g] - '0'])
                            numbers[grid[d * 3 + f][e * 3 + g] - '0'] = true;
                        else {
                            return false;
                        }
                    }
                }
                Arrays.fill(numbers, false);

            }
        }
        return true;
    }
}
