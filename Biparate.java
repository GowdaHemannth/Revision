package Pattern1BFSandDFS;

import java.util.*;

public class Biparate {
    public static boolean BiparateGrapah(int v, ArrayList<ArrayList<Integer>> Adj) {
        int Color[] = new int[v];
        for (int i = 0; i < v; i++) {
            Color[i] = -1;
        }
        for (int i = 0; i < v; i++) {
            if (Color[i] == -1) {
                if (DFS(i, 0, Color, Adj) == false) {
                    return false;
                }
            }

        }
        return true;

    }

    public static boolean DFS(int Parent, int color, int Color[], ArrayList<ArrayList<Integer>> Adj) {
        Color[Parent] = color;

        for (int i = 0; i < Adj.get(Parent).size(); i++) {
            int Child = Adj.get(Parent).get(i);
            if (Color[Child] == -1) {
                if (DFS(Child, 1 - color, Color, Adj) == false) {
                    return false;
                }
            } else if (Color[Child] == color) {
                return false;

            }
        }
        return true;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> Adj = new ArrayList<>();
        int n = 4;
        
            // Here As you can seethe
            for (int i = 0; i < n; i++) {
                Adj.add(new ArrayList<>());
            }

        
        Adj.get(0).add(1);
        Adj.get(1).add(0);
        Adj.get(3).add(0);
        Adj.get(0).add(3);

        Adj.get(3).add(2);
        Adj.get(2).add(3);

        Adj.get(2).add(1);
        Adj.get(1).add(2);
        System.out.println(BiparateGrapah(n, Adj));
    }

}
