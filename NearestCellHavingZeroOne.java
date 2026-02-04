package Pattern1BFSandDFS;

import java.util.*;

class Pair {
    int Row;
    int Col;
    int Steps;

    public Pair(int Row, int Col, int Steps) {
        this.Row = Row;
        this.Col = Col;
        this.Steps = Steps;
    }
}

public class NearestCellHavingZeroOne {
    public static void Function(int grid[][], int n, int m, int dummy[][], boolean Visited[][]) {
        Queue<Pair> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    Q.add(new Pair(i, j, 0));
                    Visited[i][j] = true;
                }
            }
        }

        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };

        while (!Q.isEmpty()) {
            int StartRow = Q.peek().Row;
            int StartCol = Q.peek().Col;
            int steps = Q.peek().Steps;
            Q.remove();
            dummy[StartRow][StartCol] = steps;
            for (int i = 0; i < 4; i++) {
                int Drow = StartRow + drow[i];
                int Dcol = StartCol + dcol[i];
                if (Drow >= 0 && Drow < n && Dcol >= 0 && Dcol < m && grid[Drow][Dcol] == 0
                        && Visited[Drow][Dcol] != true) {
                    Q.add(new Pair(Drow, Dcol, steps + 1));
                    Visited[Drow][Dcol] = true;
                }
            }

        }

    }

    public static void main(String[] args) {
        int grid[][] = { { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 0, 1 } };
        int n = grid.length;
        int m = grid[0].length;
        boolean Visited[][] = new boolean[n][m];

        // Important Rule Never Tamper the Given Data
        int dummy[][] = new int[n][m];
        Function(grid, n, m, dummy, Visited);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(dummy[i][j]);
            }
        }
    }

}