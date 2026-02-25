import java.util.*;

class Pair {
    int Start;

    int Distance;

    public Pair(int Start, int Distance) {
        this.Start = Start;

        this.Distance = Distance;
    }
}

public class FlyodMarshall {
    public static void main(String[] args) {
        // Here main Goal of These Algorithm is To Find the Shorter Disatnce btween EACH
        // Node
        // Here these Also We need to Do Iteration for Nodes-1 Times

        // its work for a Directed Garph if a Undiected Garph given make it Has Directed
        // Graph
        // Here We Will be Using the AdjMatrix Thing Here
        int Nodes = 4;
        ArrayList<ArrayList<Pair>> Adj = new ArrayList<>();
        for (int i = 0; i < Nodes; i++) {
            ArrayList<Pair> Temp = new ArrayList<>();
            Adj.add(Temp);
        }
        Adj.get(0).add(new Pair(1, 3));

        Adj.get(1).add(new Pair(0, 3));
        Adj.get(1).add(new Pair(2, 1));
        Adj.get(1).add(new Pair(3, 4));

        Adj.get(2).add(new Pair(3, 1));
        Adj.get(2).add(new Pair(1, 1));

        Adj.get(3).add(new Pair(1, 4));
        Adj.get(3).add(new Pair(2, 1));

        int Matrix[][] = new int[Nodes][Nodes];
        for (int i = 0; i < Nodes; i++) {
            for (int j = 0; j < Nodes; j++) {
                Matrix[i][j] = (int) (1e9);
            }
        }

        for (int i = 0; i < Adj.size(); i++) {
            for (int j = 0; j < Adj.get(i).size(); j++) {
                int Node = Adj.get(i).get(j).Start;
                int Distance = Adj.get(i).get(j).Distance;
                Matrix[i][Node] = Distance;
                System.out.println(Matrix[i][Node]);
            }
        }

        // Here We Will be Finding the Shortest Distance
        // So Here First For Loop Defines Like From Via Thing
        // Second For loop like From 0 1 and all
        // Third For loop Defines to Which Node

        for (int Via = 0; Via < Nodes; Via++) {
            for (int i = 0; i < Nodes; i++) {
                for (int j = 0; j < Nodes; j++) {
                    // These Line Holds The More Significant Thing Thn Anything
                    Matrix[i][j] = Math.min(Matrix[i][j], Matrix[i][Via] + Matrix[Via][j]);
                }
            }
        }

    }


    // There IS ONE MORE NUMERICAL After these Similar to these But Just the Differnce is Clear 

}
