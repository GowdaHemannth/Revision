
// Here Lets Keep ONE DOUBT CLEARED WHY DO I NEED TO USE TOPO HERE BECASE IN typical case in bfs 
import java.util.*;

class Pair {
    int Node;
    int Distance;

    public Pair(int Node, int Distance) {
        this.Node = Node;
        this.Distance = Distance;
    }

}

public class ShortestDistanceDirested {
    public static void TopoSort(ArrayList<ArrayList<Pair>> Adj, boolean Visited[], int Distance[], int Start,
            Stack<Integer> S) {

        Visited[Start] = true;

        for (int i = 0; i < Adj.get(Start).size(); i++) {
            int Child = Adj.get(Start).get(i).Node;
            if (Visited[Child] != true) {
                TopoSort(Adj, Visited, Distance, Child, S);
            }
        }

    }

    // 2nd Function is To Add to the Simple Things 
    public static void MainFunction( Stack<Integer> S,int Distance[],ArrayList<ArrayList<Pair>> Adj){
        while(!S.isEmpty()){
            int Node=S.peek();
            S.pop();
            for(int i=0;i<Adj.get(Node).size();i++){
                int Child=Adj.get(Node).get(i).Node;
                int Path=Adj.get(Node).get(i).Distance;
                if(Distance[Child]>Distance[Node]+Path){
                    Distance[Child]=Distance[Node]+Path;

                }
            }


    }
}

    public static void main(String[] args) {
        // Here We Need to Find the sHORTEST dISTANCE IN THE ACYCLIC gRAPH
        // hERE IDEA wILL BE jUST HAVE ONE dISTANCE aRRAY iTS qUITE
        // Here We Encounter the New Problem that How Do You Store the Particular Weight
        // of The Node Here

        // Here the Question is Why didnt i use the Normal Dfs Ist Simple As that Here
        // they Have Given its has An
        // Directed Acyclic Graph

        // Here while taking the Nodes First Thing You need to Properly think like
        // Here N Represents the Nodes
        int N = 6;
        // Here M Reprsets the Edges that thier
        int M = 7;

        ArrayList<ArrayList<Pair>> Adj = new ArrayList<>();

        // Nodes With N
        for (int i = 0; i < N; i++) {
            ArrayList<Pair> Temp = new ArrayList<Pair>();
            Adj.add(Temp);
        }

        int[][] Edges = {
                { 0, 1, 2 }, { 0, 4, 1 }, { 4, 5, 4 },
                { 4, 2, 2 }, { 1, 2, 3 }, { 2, 3, 6 }, { 5, 3, 1 }
        };

        // Here m stands For Edges
        for (int i = 0; i < M; i++) {
            int U = Edges[i][0]; // Here This Shows From which Node
            int V = Edges[i][1]; // Here This Shows To Which Node
            int Weight = Edges[i][2]; // Here This Shows The Weight
            Adj.get(U).add(new Pair(V, Weight));
        }

        // I Need one Visited Array
        // I Nedd One Distance Array
        boolean Visited[] = new boolean[N];

        int Distance[] = new int[N];
        Stack<Integer> S = new Stack<>();
        int Start = 0;
        S.push(Start);
        TopoSort(Adj, Visited, Distance, Start, S);
        // After These You Will be ahving Evrything in Neat Way 
        // Now Apply Simple Things like taking each one From Satk

        // One Important thing Ditnce Array bsHOULD NBE fILLED WITH Maximum Value 

        // But the Distnace of the Source ;

    }

}
