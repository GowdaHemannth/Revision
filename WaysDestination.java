package Shortestpath;

import java.util.*;

class Pair {
    int Node;
    int Distance;

    public Pair(int Node, int Distance) {
        this.Node = Node;
        this.Distance = Distance;
    }
}

class NewPair{
    int Distance;
    int Node;
    public NewPair(int Distance,int Node){
        this.Distance=Distance;
        this.Node=Node;
    }
}

public class WaysDestination {
    public static void Ways( ArrayList<ArrayList<Pair>> Adj,int Distance[], int Ways[], PriorityQueue<NewPair>Pq){
        while(!Pq.isEmpty()){
            int Node=Pq.peek().Node;
            int D=Pq.peek().Distance;
            Pq.remove();
            for(int i=0;i<Adj.get(Node).size();i++){
                int ChildNode=Adj.get(Node).get(i).Node;
                int Path=Adj.get(Node).get(i).Distance;
                if(Path+D<Distance[ChildNode]){
                    Pq.add(new NewPair(Path+D, ChildNode));
                    Ways[ChildNode]=Ways[Node];
                }else if(Path+D==Distance[ChildNode]){
                    Ways[ChildNode]=Ways[ChildNode]+Ways[Node];
                    // Here there is No thing like You Should Add thgese But If distyacne Same menas the same thing will be Added Agin again 
                }
            }
        }
    }
    public static void main(String[] args) {
        int Destination = 6;
        int Nodes = 7;
        ArrayList<ArrayList<Pair>> Adj = new ArrayList<>();
        Adj.get(0).add(new Pair(1, 2));
        Adj.get(0).add(new Pair(4, 5));
        Adj.get(0).add(new Pair(6, 7));

        Adj.get(1).add(new Pair(3, 3));
        Adj.get(1).add(new Pair(2, 3));
        Adj.get(1).add(new Pair(0, 2));

        Adj.get(2).add(new Pair(5, 1));
        Adj.get(2).add(new Pair(1, 3));

        Adj.get(3).add(new Pair(1, 3));
        Adj.get(3).add(new Pair(5, 1));
        Adj.get(3).add(new Pair(6, 3));

        Adj.get(4).add(new Pair(0, 5));
        Adj.get(4).add(new Pair(2, 2));

        Adj.get(5).add(new Pair(3, 1));
        Adj.get(5).add(new Pair(2, 1));
        Adj.get(5).add(new Pair(6, 1));

        Adj.get(6).add(new Pair(4, 2));
        Adj.get(6).add(new Pair(5, 1));
        Adj.get(6).add(new Pair(3, 3));
        Adj.get(6).add(new Pair(0, 7));

        int Distance[] = new int[Nodes];
        int Ways[] = new int[Nodes];
        int Source = 0;
        Ways[Source] = 1;
        Distance[Source] = 0;

        for (int i = 0; i < Nodes; i++) {
            Distance[i] = (int) (1e9);
        }
      PriorityQueue<NewPair>Pq=new PriorityQueue<>((a,b)->a.Distance-b.Distance);
      Pq.add(new NewPair(Distance[Source], Source));
    }

}
