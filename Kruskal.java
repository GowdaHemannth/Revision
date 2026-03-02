import java.util.*;
class Pair{
    int Start;
    int End;
    int Weight;
    public Pair(int Start,int End,int Weight){
        this.Start=Start;
        this.End=End;
        this.Weight=Weight;
    }
}
public class Kruskal {
    public static int FindUrParent(int Node, List<Integer> Parent) {
        if (Node == Parent.get(Node)) {
            return Node;
        }
        int MainParent = FindUrParent(Parent.get(Node), Parent);
        Parent.set(Node, MainParent);
        return Parent.get(Node);
    }

    public static void DisjointByUnion(int U, int V, List<Integer> Parent, List<Integer> Rank) {
        int ParentofU = FindUrParent(U, Parent);
        int ParentofV = FindUrParent(V, Parent);

        if (Rank.get(ParentofV) > Rank.get(ParentofU)) {
            Parent.set(ParentofU, ParentofV);
        } else if (Rank.get(ParentofU) > Rank.get(ParentofV)) {
            Parent.set(ParentofV, ParentofU);
        } else {
            Parent.set(ParentofV, ParentofU);
            int rank = Rank.get(ParentofU);
            Rank.set(ParentofU, rank + 1);
        }
    }

    public static void main(String[] args) {
        // Here These Algorithm is Used to Find the Minimum Sapnning Tree of A gIVEN
        // tree

        // Here the Step is to Create Normal Rank and Parent Thing
        // Do EVrything According to the Finding Disjoint Set Thing Now than
        // Call for Find parent thing
        int Nodes = 6;
        List<Integer> Parent = new ArrayList<>();
        List<Integer> Rank = new ArrayList<>();

        for (int i = 0; i <= Nodes; i++) {
            Parent.add(i);
            Rank.add(0);

        }
        ArrayList<ArrayList<Pair>>Adj=new ArrayList<>();
        for(int i=0;i<=Nodes;i++){
            ArrayList<Pair>Temp=new ArrayList<>();
            Adj.add(Temp);

        }
        

        //  Now Call For All Nodes

    }

}
