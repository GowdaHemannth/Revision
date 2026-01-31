package Pattern1BFSandDFS;
import java.util.*;
public class BFSRepresentation {

    public static ArrayList<Integer> BFS(int n,ArrayList<ArrayList<Integer>>Adj){
        ArrayList<Integer>bfs=new ArrayList<>();

        Queue<Integer>Q=new LinkedList<>();

        boolean visited[]=new boolean[n];

        // Here the Starting Node Will Be Given 
        // As far now we will Consider 0 as Satrting nODE
        Q.add(0);
        visited[0]=true;
        bfs.add(0);

        while(!Q.isEmpty()){
            Integer Node=Q.remove();
            bfs.add(Node);
            for(int i=0;i<Adj.get(Node).size();i++){
                Integer Element=Adj.get(Node).get(i);
                if(visited[Element]!=true){
                    
                    visited[Element]=true;
                    Q.add(Element);
                }
            }

        }
        return bfs;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> Adj=new ArrayList<>();

        int n=8; // number of Nodes
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

           Adj.get(7).add(9);

         
           System.out.println(BFS(n, Adj));
    }    
}
