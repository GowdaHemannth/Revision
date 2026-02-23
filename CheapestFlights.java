package Shortestpath;

import java.util.*;

class Pair {
    int Steps;
    int Nodes;
    int Distance;

    public Pair(int Steps, int Nodes, int Disatnce) {
        this.Steps = Steps;
        this.Nodes = Nodes;
        this.Distance = Disatnce;

    }
}

class Adjnode {
    int Node;
    int Distance;

    public Adjnode(int Node, int Distance) {
        this.Node = Node;
        this.Distance = Distance;
    }
}
  
public class CheapestFlights {
    public static void Flights( ArrayList<ArrayList<Adjnode>> Adj,int Distance[], Queue<Pair>Q,int k){
        while(!Q.isEmpty()){
            int Steps=Q.peek().Steps;
            int Node=Q.peek().Nodes;
            int ParentDistance=Q.peek().Distance;
            if(Steps>k){
                continue;
            }
            Q.remove();
            for(int i=0;i<Adj.get(Node).size();i++){
                int AdjNode=Adj.get(Node).get(i).Node;
                int ChildDistance=Adj.get(Node).get(i).Distance;
                if(Steps<=k&& ParentDistance+ChildDistance<Distance[AdjNode]){
                    Distance[AdjNode]=ChildDistance+ParentDistance;
                    Q.add(new Pair(Steps+1, AdjNode, ChildDistance+ParentDistance));
                }
            }
        }
    }
    public static void main(String[] args) {
        // Here The Question is Little More Diffrent As Compared to Previous one
        // FIRST HERE WE WONT BE USING THE Priority Queue
        // bEcuase here the Flight Dependent Upon Both K Stops and the Disatnce Botha re
        // Considered
        // if i Just Take up the Disatnce in Priority Queue Which Might End up Givng the
        // Wrong Output Hence We wont be USing it
        int Nodes = 4;
        ArrayList<ArrayList<Adjnode>> Adj = new ArrayList<>();

        // Here number of nodes Should Be Equal
        for (int i = 0; i < Nodes; i++) {
            ArrayList<Adjnode> Temp = new ArrayList<>();
            Adj.add(Temp);
        }
        int[][] Flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 },
                { 2, 3, 200 } };

       for(int i=0;i<Flights.length;i++){
        Adj.get(Flights[i][0]).add(new Adjnode(Flights[i][1], Flights[i][2]));
       }
       Queue<Pair>Q=new LinkedList<>();
       Q.add(new Pair(0, 0, 0));
       int Distance[]=new int[Nodes];
       Distance[0]=0;
       for(int i=0;i<4;i++){
        Distance[i]=(int)(1e9);
       }
    }

}
