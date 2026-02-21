package Shortestpath;
import java.util.*;
class Pair{
    int Steps;
    int Start;
    int End;
    public Pair(int Steps,int Start,int End){
        this.Steps=Steps;
        this.Start=Start;
        this.End=End;
    }
}
public class BinaryMaze {
    public static int Function(PriorityQueue<Pair>Pq,int Dist[][],Queue<Pair>Q, int Grid[][]){
        int Drow[]={-1,0,1,0};
        int Dcol[]={0,1,0,-1};
        while (!Q.isEmpty()) {
            int Steps=Q.peek().Steps;
            int Row=Q.peek().Start;
            int Col=Q.peek().End;
            for(int i=0;i<4;i++){
                int NewRow=Row+Drow[i];
                int NewCol=Col+Dcol[i];
                if(NewRow>=0&&NewRow<Grid.length&&NewCol>=0&&NewCol<Grid[0].length&&Steps+1<Dist[NewRow][NewCol]&&Grid[NewRow][NewCol]==1){
                    Dist[NewRow][NewCol]=Steps+1;
                    if(NewRow==2&&NewCol==3){
                        return Steps+1;
                    }
                    Pq.add(new Pair(Steps+1, NewRow, NewCol));

                }
            }

            
        }
        return -1;
    }
    public static void main(String[] args) {
        // Here the Numerical May Feeel its not the Graphs But It is Graph Thing
        int Grid[][] = { { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
                { 1, 0, 0, 1 } };

    // Here We Need TO cALCULATE The Minimum Steps Taken to To Reach the Destination
 PriorityQueue<Pair>Pq=new PriorityQueue<>((a,b)->a.Steps-b.Steps); // Here As you can See its A Minimum Heap

 int Dist[][]=new int[Grid.length][Grid[0].length];

 for(int i=0;i<Dist.length;i++){
    for(int j=0;j<Dist[0].length;j++){
        Dist[i][j]=(int)(1e9); // Here We Will be 
    }
 }

 int Row=0;
 int Column=1;
 Queue<Pair>Q=new LinkedList<>();
 Q.add(new Pair(0, Row, Column));
 // Here Since Satrting Value Should be Zero
 Dist[Row][Column]=0;

    }

}
