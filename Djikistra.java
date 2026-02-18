import java.util.*;
 class Pair{
    int Node;
    int Distance;
    public Pair(int Node,int Distance){
        this.Node=Node;
        this.Distance=Distance;
    }
}
public class Djikistra {
    public static void MainFunction( ArrayList<ArrayList<Pair>>Adj, int Dist[],  PriorityQueue<Pair>Pq){
        while(!Pq.isEmpty()){
            // Here It might Fell heavy but tahts Good
            int Node=Pq.peek().Node;
            int Distance=Pq.peek().Distance;
            for(int i=0;i<Adj.get(Node).size();i++){
                int Children=Adj.get(Node).get(i).Node;
                int Dis=Adj.get(Node).get(i).Distance;
                if(Distance+Dis<Dist[Children]){
                    Dist[Children]=Distance+Dis;
                    Pq.add(new Pair(Dist[Children],Children)); 

                }

            }

        }
    }
    public static void main(String[] args) {
        // Here the Aim is to Find the Shortest using Bfs
        // But HERE NOT THE TYPICAL BFS WHERE WE USED VISTED OR NOT HERE WE WILL NOT USE VISITED OR NOT
        // Here We Will be Using The Priority Queue 
        ArrayList<ArrayList<Pair>>Adj=new ArrayList<>();
        // Node Definfe Number of Nodes That i need to Define
        int N=6;
        int M=7;
        for(int i=0;i<N;i++){
            ArrayList<Pair>Temp=new ArrayList<>();
            Adj.add(Temp);
        }

        // Here M is the Edge 
           int[][] Edges = {
                { 0, 1, 2 }, { 0, 4, 1 }, { 4, 5, 4 },
                { 4, 2, 2 }, { 1, 2, 3 }, { 2, 3, 6 }, { 5, 3, 1 }
        };

        for(int i=0;i<M;i++){
            int U=Edges[i][0];
            int V=Edges[i][1];
            int D=Edges[i][2];
            Adj.get(U).add(new Pair(V, D));

        }
        // PriorityQueue<Integer>PQ=new PriorityQueue<>(); // Defualt it will BE MIN HEAP
        // BUT YOU CANT STORE DOUBLE VALUES HERE HENCE YOU WILL STORE PAIR
        int Dist[]=new int [N];
       Arrays.fill(Dist, Integer.MAX_VALUE);
       // Here We have Filled the Dist Arry With the Maximum Value 
     
       PriorityQueue<Pair>Pq=new PriorityQueue<>((a,b)->a.Distance-b.Distance);

       int Source =0;
       Dist[Source]=0;
     
    }
    
}
