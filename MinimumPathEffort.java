package Shortestpath;

import java.util.PriorityQueue;

class Pair {
    int Effort;
    int Row;
    int Col;

    public Pair(int Effort, int Row, int Col) {
        this.Effort = Effort;
        this.Row = Row;
        this.Col = Col;
    }
}

public class MinimumPathEffort {
    public static int MinimumFunction(PriorityQueue<Pair> Pq, int Distance[][], int EndRow, int EndCol,int Heights[][]) {
        int Drow[] = { -1, 0, 1, 0 };
        int Dcol[] = { 0, 1, 0, -1 };
        while (!Pq.isEmpty()) {
           int Effort=Pq.peek().Effort;
           int Row=Pq.peek().Row;
           int Col=Pq.peek().Col;

           // Here the theory Becuase Once the Thing is Plucked THA MEANS THERE IS NO MORE Minimum Tahn these 
           if(EndRow==Row&& EndCol==Col){
            return Effort;
           }
            for(int i=0;i<4;i++){
                int NRow=Row+Drow[i];
                int NCol=Col+Dcol[i];
                int NewEffort=Math.abs(Heights[Row][Col]-Heights[NRow][NCol]);
                NewEffort=Math.max(NewEffort,Effort);
                if(NRow>=0&&NRow<Heights.length&&NCol>=0&&NCol<Heights[0].length && NewEffort<Distance[NRow][NCol]){
                    Distance[NRow][NCol]=NewEffort;
                    Pq.add(new Pair(NewEffort, NRow, NCol));

                }
            }

        }
     return -1;
    }

    public static void main(String[] args) {
        // Here jut klike Evry STEPS bUT dIIFERNCE IS
        // tHINK lIKE THESE bEFORE aDDING THE Distance that Distance Should be Greater
        // than Previous one
        // Above One DOESNT Make Any Sense Only thing AMTTERS HERE IS JUST oBSERVE ONCE
        // yOU wILL GTE IT

        int Heights[][] = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
        int N = Heights.length;
        int M = Heights[0].length;
        PriorityQueue<Pair> Pq = new PriorityQueue<>((a, b) -> a.Effort - b.Effort);
        int Distance[][] = new int[Heights.length][Heights[0].length];
        for (int i = 0; i < Distance.length; i++) {
            for (int j = 0; j < Distance[0].length; j++) {
                Distance[i][j] = (int) (1e9);
            }

        }
        Distance[0][0] = 0;
        int EndRow = 3;
        int EndCol = 3;
        Pq.add(new Pair(0, 0, 0));

    }

}
