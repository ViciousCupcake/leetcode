package src;

import java.util.Arrays;

public class sudoku2 {
    public static void main(String[] args) {
        char[][] grid = 
        {{'.','4','.','.','.','.','.','.','.'}, 
 {'.','.','4','.','.','.','.','.','.'}, 
 {'.','.','.','1','.','.','7','.','.'}, 
 {'.','.','.','.','.','.','.','.','.'}, 
 {'.','.','.','3','.','.','.','6','.'}, 
 {'.','.','.','.','.','6','.','9','.'}, 
 {'.','.','.','.','1','.','.','.','.'}, 
 {'.','.','.','.','.','.','2','.','.'}, 
 {'.','.','.','8','.','.','.','.','.'}};
        System.out.println(sudoku2(grid));
    }

    static boolean sudoku2(char[][] grid) {
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
