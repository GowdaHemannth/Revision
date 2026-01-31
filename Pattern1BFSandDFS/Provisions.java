package Pattern1BFSandDFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Provisions {
    public static void Function(int Start,ArrayList<ArrayList<Integer>>Adj,boolean Visited[]){
        Queue<Integer>Q=new LinkedList<>();
        Q.add(Start);
        while(!Q.isEmpty()){
           
        while(!Q.isEmpty()){
            Integer Node=Q.remove();
           
            for(int i=0;i<Adj.get(Node).size();i++){
                Integer Element=Adj.get(Node).get(i);
                if(Visited[Element]!=true){
                    
                    Visited[Element]=true;
                    Q.add(Element);
                }
            }

        }

        }
    }
    public static void main(String[] args) {
        // Here We will Find the Number of Componenst the Grpah has
        // You Can use Anything BFS OR DFS
        ArrayList<ArrayList<Integer>> Adj = new ArrayList<>();

        int n = 7; // number of Nodes
        for (int i = 0; i <= n; i++) {
            Adj.add(new ArrayList<>());
        }

        Adj.get(0).add(1);
        Adj.get(0).add(2);
        Adj.get(1).add(0);
        Adj.get(2).add(0);

        Adj.get(1).add(3);
        Adj.get(1).add(4);
        Adj.get(3).add(1);
        Adj.get(4).add(1);

        Adj.get(2).add(5);
        Adj.get(2).add(6);
        Adj.get(5).add(2);
        Adj.get(6).add(2);
        boolean Visited[]=new boolean[7];
        int count=0;
        for(int i=0;i<n;i++){
            if(Visited[i]!=true){
                // Here these For the Starting points of the Each Graph if its Single Component 
                // Graph Count Would be 1 
                count=count+1;
                 Function(i, Adj, Visited);
                
            }
        }
    }

}
