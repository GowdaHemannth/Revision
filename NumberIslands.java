package DisjointSets;

import java.util.*;

public class NumberIslands {
    public static int FindUrParent(int Node, List<Integer> Parent, List<Integer> Rank) {
        if (Node == Parent.get(Node)) {
            return Node;
        }
        int MainParent = FindUrParent(Parent.get(Node), Parent, Rank);
        Parent.set(Node, MainParent);
        return Parent.get(Node);

    }

    public static void UnionParent(int U, int V, List<Integer> Parent, List<Integer> Rank) {
        int ParentofU = FindUrParent(U, Parent, Rank);
        int ParentofV = FindUrParent(V, Parent, Rank);
        if (ParentofU == ParentofV) {
            return;
        }
        if (Rank.get(ParentofU) > Rank.get(ParentofV)) {
            Parent.set(ParentofV, ParentofU);
        } else if (Rank.get(ParentofU) < Rank.get(ParentofV)) {
            Parent.set(ParentofU, ParentofV);
        } else {
            Parent.set(ParentofV, ParentofU);
            int R = Rank.get(ParentofU);
            Rank.set(ParentofU, R + 1);
        }
    }

    public static List<Integer> IslandsMainFunction(int[][] operators, int n, int m,List<Integer> Parent, List<Integer> Rank) {
        int Visited[][] = new int[n][m];
        List<Integer> Ans = new ArrayList<>();
        int Count = 0;
        // Here You Need to Think of One Thing You are taking from operator
        for (int i = 0; i < operators.length; i++) {
            for (int j = 0; j < operators[0].length; j++) {
                int row = operators[i][j];
                int Column = operators[i][j];
                if (Visited[row][Column] == 1) {
                    Ans.add(Count);
                    continue;
                }

                Visited[row][Column] = 1;
                // Here Irrsepective of the THIng We will Increse the Count
                // WE will Decrease the Count onlyy when we finds out that There is Component
                // There
                Count++;

                int[] dr = { -1, 0, 1, 0 };
                int[] dc = { 0, 1, 0, -1 };


                //  Now here Comes the Mian Part
                for(int k=0;k<4;k++){
                    int NewRow=row+dr[0];
                    int NewCol=Column+dc[0];
                    //  These Can Be Made into Another Part of code these Conditiosn Only 
                    // Might be Confusing That Why Do we need to Check here Visited[NewCol][NewRow]==1
                    //  Here Only Thing is We only onsider it Has Neighbour if they have visted 
                    if(NewRow>=0&&NewRow>n&&NewCol>=0&&NewCol>m&&Visited[NewCol][NewRow]==1){
                        int PresentNodeNumber=row*n+Column;
                        int AdjcentNodeNumber=NewRow*n+NewCol;

                        // Here the These Part of Code Snippit Feels Little More 
                        //  Awkard Here Only one thing Is Clear
                        
                      if(FindUrParent(AdjcentNodeNumber, Parent, Rank)!=FindUrParent(PresentNodeNumber, Parent, Rank)){
                        // Here Since They are Nieghbour They ARE Single Component
                        Count--;
                        UnionParent(PresentNodeNumber, AdjcentNodeNumber, Parent, Rank);
                      }

                    }
                }
                Ans.add(Count);
            }
        }
        return Ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int[][] operators = {
                { 0, 0 }, { 0, 0 }, { 1, 1 }, { 1, 0 }, { 0, 1 },
                { 0, 3 }, { 1, 3 }, { 0, 4 }, { 3, 2 }, { 2, 2 }, { 1, 2 }, { 0, 2 }
        };
        List<Integer> Parent = new ArrayList<>();
        List<Integer> Rank = new ArrayList<>();

        // After These it More of the BFS TECHNIQUE THING
        IslandsMainFunction(operators, n, m, Parent, Rank);
    }

}
