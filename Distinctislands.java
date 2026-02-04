package Pattern1BFSandDFS;

import java.util.*;

class Pair {
    int StartRow;
    int SatrtCol;

    public Pair(int StartRow, int SatrtCol) {
        this.StartRow = StartRow;
        this.SatrtCol = SatrtCol;
    }
}

public class Distinctislands {
    public static void BFS(int Islands[][], boolean Visited[][], int Sr, int Sc,int n,int m) {

        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(Sr, Sc));
        Visited[Sr][Sc] = true;
        int drow[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
        int dcol[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
        while (!Q.isEmpty()) {
            // Here i Got the StartRow And StartCol
            int Row = Q.peek().StartRow;
            int Col = Q.peek().SatrtCol;
            Q.remove();
            for (int i = 0; i < 8; i++) {
                int NewDrow = Row + drow[i];
                int NewDcol = Col + dcol[i];
                if(NewDrow>=0&&NewDrow<n&&NewDcol>=0&&NewDcol<m&&Islands[NewDrow][NewDcol]==1&&Visited[NewDrow][NewDcol]!=true){
                    Q.add(new Pair(NewDrow,NewDcol));
                    Visited[NewDrow][NewDcol]=true;
                }
            }

        }
    }

    public static void main(String[] args) {
        int Islands[][] = { { 1, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 1, 1 } };
        int n = Islands.length;
        int m = Islands[0].length;
        boolean Visited[][] = new boolean[n][m];
        int cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Visited[i][j] != true && Islands[i][j] == 1) {
                    cnt=cnt+1;
                    BFS(Islands, Visited, i, j,n,m);
                    
                }
            }
        }
        System.out.println(cnt);
    }

}
