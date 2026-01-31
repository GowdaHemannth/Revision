package Pattern1BFSandDFS;

import java.util.ArrayList;

public class DFSRepresentation {
    public static ArrayList<Integer> DFS(int v,ArrayList<ArrayList<Integer>>Adj,ArrayList<Integer>Result,boolean visited[]){
        visited[v]=true;
        Result.add(v);
        for(int i=0;i<Adj.get(v).size();i++){
            Integer Node=Adj.get(v).get(i);
            // Here we may think that these recurion doesnthave base case but realioty ita having base tahst these only
            if(visited[Node]!=true){
                visited[Node]=true;
                DFS(Node, Adj, Result, visited);
            }
            
        }
        return Result;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> Adj=new ArrayList<>();

        int n=7; // number of Nodes
        for (int i=0;i<=n;i++){
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
           ArrayList<Integer>Result=new ArrayList<>();
           boolean visited[]=new boolean[n];
           int v=0;
           System.out.println(DFS(v, Adj, Result, visited));
    }
    
}
