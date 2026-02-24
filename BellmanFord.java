import java.util.*;

class Pair {
    int Start;
    int End;
    int Distance;

    public Pair(int Start, int End, int Distance) {
        this.Start = Start;
        this.End = End;
        this.Distance = Distance;
    }
}

class BellmanFord {
    public static void main(String[] args) {
        // These BellmanFord Algo Nothing But its An Algo Used for Dtecting the Negative
        // Cycle in the Garph

        // Here you Might get Negative Edges but that Doesnt mean That you are Having
        // Negative Cyle
        // Djikistra Doesnt Work For Negative Indexes
        int Nodes = 6;
        int Source = 0;
        ArrayList<ArrayList<Pair>> Adj = new ArrayList<>();
        for (int i = 0; i < Nodes; i++) {
            ArrayList<Pair> Temp = new ArrayList<>();
            Adj.add(Temp);
        }
        // Edges Can be IN anY oRDER
        int Distance[] = new int[Nodes];
        for (int i = 0; i < Nodes; i++) {
            Distance[i] = (int) (1e9);
        }
        Distance[Source] = 0;
        
        // Now we will be Doing Relaxation of The Node for Nodes-1 Times
        // If Relaxtion Happens Even On the Nodes then There will be a nEGATIVE Cycle

        for (int i = 0; i < Nodes; i++) {
            for (int j = 0; j < Adj.size(); j++) {
                int u = Adj.get(i).get(j).Start;
                int v = Adj.get(i).get(j).End;
                int Path = Adj.get(i).get(j).Distance;

                if(Distance[u]!=(int)(1e9) && Distance[u]+Path<Distance[v]){
                    Distance[v]=Distance[u]+Path;
                }

            }
        }

    }
}