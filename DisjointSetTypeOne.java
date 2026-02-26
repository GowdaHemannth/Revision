import java.util.*;

//  These is The Union By Rank 
//  These is The Method One 
public class DisjointSetTypeOne {

    public static int FindUrParent(int Node, List<Integer> Parent) {
        if (Node == Parent.get(Node)) {
            return Node;
        }
          // Here As You Can See Path Compression Will Happen So 
          // Then There will be No Usage OF Rank Here // Instead i can Use Size which is Quite Good You Knwo 
        int MainParent = FindUrParent(Parent.get(Node), Parent);
        Parent.set(Node, MainParent);
        return Parent.get(Node);
    }

    public static void FindUnion(int U, int V, List<Integer> Rank, List<Integer> Parent) {
        int ParentOfU = FindUrParent(U, Parent);
        int ParentOfV = FindUrParent(V, Parent);
        if (ParentOfU == ParentOfV) {
            return;
        }

        if (Rank.get(ParentOfU) > Rank.get(ParentOfV)) {
            Parent.set(ParentOfV, ParentOfU);
        } else if (Rank.get(ParentOfU) > Rank.get(ParentOfV)) {
            Parent.set(ParentOfU, ParentOfV);
        } else {
            Parent.set(ParentOfV, ParentOfU);
            int R = Rank.get(ParentOfU);
            Rank.set(ParentOfU, R + 1);
        }
    }

    public static void main(String[] args) {
        // Here the Main Goal at Each Dynamic Phase I Should Be Able To Answer You That
        // Whether The Given Two Nodes Are in The Same Comaponent
        // You Might Say Whats in thier I Will do DFS
        // BUT HERE COMES THE MOST IMPORTANT HERE I NEED TO TELL IT IN CONSTANT TIME

        // Here These Is Some What The Toughest Numerical In Tersm in Garph
        int Nodes = 7;
        List<Integer> Parent = new ArrayList<>();
        List<Integer> Rank = new ArrayList<>();

        // Initally rank Should be Zero and There are istself Parent
        for (int i = 0; i <= Nodes; i++) {
            Parent.add(i);
            Rank.add(0);
        }

        // Here You Writting the Things
        FindUnion(1, 2, Rank, Parent);
        FindUnion(2, 3, Rank, Parent);
        FindUnion(4, 5, Rank, Parent);
        FindUnion(6, 7, Rank, Parent);
        FindUnion(5, 6, Rank, Parent);
        FindUnion(3, 7, Rank, Parent);
       

    }

}
