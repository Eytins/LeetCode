import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    boolean isShip(String[][] grid, int r, int c) {
        String cell = grid[r][c];
        return !(cell.equals(".") || cell.equals("Already attacked"));
    }

    boolean isLastCell(String[][] grid, int r, int c) {
        String s = grid[r][c];
        int numRows = grid.length;
        int numCols = grid[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((i == j || i == -j)) {
                    continue;
                }
                int newRow = r + i;
                int newCol = c + j;
                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols && grid[newRow][newCol].equals(s)) {
                    return false;
                }
            }
        }

        return true;
    }

    String[] solution(String[][] grid, int[][] shots) {
        String[] result = new String[shots.length];
        for (int i = 0; i < shots.length; i++) {
            int r = shots[i][0];
            int c = shots[i][1];
            String cell = grid[r][c];
            if (cell.equals(".")) {
                result[i] = "Missed";
            } else if (cell.equals("Already attacked")) {
                result[i] = "Already attacked";
            } else if (isShip(grid, r, c) && isLastCell(grid, r, c)) {
                result[i] = "Ship " + cell + " sunk";
                grid[r][c] = "Already attacked";
            } else if (isShip(grid, r, c) && !isLastCell(grid, r, c)) {
                result[i] = "Attacked ship " + cell;
                grid[r][c] = "Already attacked";
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(1 % 3);
    }
}
