package TopologicalSort;

import java.util.*;


// You Know Sometimes Its Fee;s Heavy Here 
// So Here the  Thing Is WE USUALLY Take all the IN degree 
public class Khans {
    public static void Function(ArrayList<ArrayList<Integer>> Adj, int Topo[], int Indegree[], Queue<Integer> Q) {

        int i = 0;
        while (!Q.isEmpty()) {
            int Elemsnt = Q.peek();
            Topo[i++] = Elemsnt;
            Q.remove();
            for (int j = 0; j < Adj.get(Elemsnt).size(); j++) {
                int Child = Adj.get(Elemsnt).get(j);
                Indegree[Child]--;
                if (Indegree[Child] == 0) {
                    Q.add(Child);
                }

            }
        }

    }

    public static void main(String[] args) {
        // Here the Node Are Satrting From Zero
        ArrayList<ArrayList<Integer>> Adj = new ArrayList<>();
        int Nodes = 5;
        int Topo[] = new int[Nodes + 1];

        for (int i = 0; i <= Nodes; i++) {
            Adj.add(new ArrayList<>());
        }

        // Now lets Keep the Things For Real Thats it

        Adj.get(5).add(0);
        Adj.get(5).add(2);

        Adj.get(4).add(0);
        Adj.get(4).add(1);

        Adj.get(2).add(3);

        Adj.get(3).add(1);

        // So Zero Doesnt Have Any OutGoing Edges

        // Now lets Take Note of Aall the Indegree Things Herer
        int Indegree[] = new int[Nodes + 1];
        for (int i = 0; i <= Nodes; i++) {
            for (int j = 0; j < Adj.get(i).size(); j++) {
                int Child = Adj.get(i).get(j);
                Indegree[Child]++;
                // Here you will get all the Indegree Elements here
            }

        }

        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i <= Nodes; i++) {
            if (Indegree[i] == 0) {
                Q.add(i);
            }
        }

        Function(Adj, Topo, Indegree, Q);
        for (int i = 0; i < Nodes + 1; i++) {
            System.out.println(Topo[i]);
        }
    }

}
