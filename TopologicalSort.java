package TopologicalSort;

import java.util.*;

public class TopologicalSort {
    public static void Function( ArrayList<ArrayList<Integer>>Adj, int Visited[],Stack<Integer>S,int Start){
        Visited[Start]=1;
        for(int i=0;i<Adj.get(Start).size();i++){
            int Child=Adj.get(Start).get(i);
            if(Visited[Child]==0){
                Function(Adj, Visited, S, Child);
            }
           
        }
         S.push(Start);
    }
    public static void main(String[] args) {
        // Here the Main Intuition is Just to Like
        int Nodes = 5;
        int Visited[]=new int[Nodes+1];
        // Here Nodes Satrt From 0 Thats why we need to Start it From the 0
        ArrayList<ArrayList<Integer>> Adj = new ArrayList<>();
        Stack<Integer>S=new Stack<>();
        for(int i=0;i<=5;i++){
            Adj.add(new ArrayList<>());
        }
        Adj.get(5).add(0);
        Adj.get(4).add(0);
        Adj.get(5).add(2);

        Adj.get(2).add(3);
        Adj.get(3).add(1);

        Adj.get(4).add(1);
       

        for (int i=0;i<Nodes+1;i++){
            Visited[i]=0;
        }
        for(int i=0;i<=Nodes;i++){
            if(Visited[i]==0){
  Function(Adj, Visited, S, i);
            }
          
        }

        while (!S.isEmpty()) {
            System.out.println(S.peek());
            S.pop();
            
        }
        



    }

}
