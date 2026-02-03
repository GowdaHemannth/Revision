package Pattern1BFSandDFS;

import java.util.*;

class Pair {
    int Row;
    int Column;
    int Time;

    public Pair(int Row, int Column, int Time) {
        this.Row = Row;
        this.Column = Column;
        this.Time = Time;
    }
}

public class RottenFruit {

    public static void main(String[] args) {
        int grid[][] = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        Queue<Pair> Q = new LinkedList<>();
        // Here in the First Step Lets Lets Find out Fresh Oranges
        int n = grid[0].length;
        int m = grid.length;
        int CountFresh = 0;
        int Visited[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    Visited[i][j] = 2;
                    Q.add(new Pair(i, j, 0));
                } else {
                    Visited[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    CountFresh = CountFresh + 1;

                }
            }

        }

        int tm = 0;
        int AvailbleRow[] = { -1, 0, +1, 0 };
        int AvailbleCol[] = { 0, 1, 0, -1 };
        int cnt=0;

        while (!Q.isEmpty()) {
            int CurrentRow=Q.peek().Row;
            int CurrentColumn=Q.peek().Column;
            int Time=Q.peek().Time;
            tm=Math.max(tm, Time);

            Q.poll();
            for(int i=0;i<4;i++){
                int rrow=CurrentRow+AvailbleRow[i];
                int ccol=CurrentColumn+AvailbleCol[i];
                if(rrow>=0&&rrow<n&&ccol>=0&&ccol<n&&Visited[rrow][ccol]==0&&grid[rrow][ccol]==1){
                    Q.add(new Pair(rrow, ccol, Time+1));
                    Visited[rrow][ccol]=2;
                    cnt=cnt+1;
                }
            }
            
        }

        if(cnt==CountFresh){
        System.out.println("The Time Taken will be "+tm);
        }else{
            System.out.println("Still Fresh Oranges Are present");
        }
              

    }
}