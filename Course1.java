
//  Here we are we aER Doing same thing has we did in Topological Sort Samje o same  
import java.util.*;
// Course 1 and Course 2 Are So Much Similar You Know we cant Raelly Tell the Difference 
// In COurse 1 Here yu will Just tell Wther like you have two couses 0,1 
// [1,0] 1 should come after the Completion 0 For These You Can Use the Topological Sort Like Can the Cycle Exist or Not

// Then Comes the Couse 2 like Yopu Need to Return the Arry of Ordering Like How do you Complete the Courses 

// For these Basic Thing is Just the Return the Topological Sort Thing Thats All
// Let Me jsut Solve the Numerical here 
public class Course1 {
    public static void TopoSortBFS(ArrayList<ArrayList<Integer>> Adj, int n, Queue<Integer> Q, int Indegree[],  int TopoSort[] ) {
      

        int i = 0;
        while (!Q.isEmpty()) {
            int Parent = Q.peek();
          
            TopoSort[i++] = Parent;
              Q.poll();
            // Else You can Write it Has
            // TopoSort[i]=Parent;
            // i++

            for (int j = 0; j < Adj.get(Parent).size(); j++) {
                int Child = Adj.get(Parent).get(j);
                //  System.out.println(Child);
                Indegree[Child]--;
                if (Indegree[Child] == 0) {
                    Q.add(Child);
                }

            }
        }

    }

    public static void main(String[] args) {
        int PreRequirsts[][] = { { 1, 0 }, { 2, 1 },
                { 3, 2 } };

        int n = PreRequirsts.length; // Here This is a Row Length;
        int m = PreRequirsts[0].length; // Here this a Column Length ;
        ArrayList<ArrayList<Integer>> Adj = new ArrayList<>();

        for (int i = 0; i<4; i++) {
            Adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            Adj.get(PreRequirsts[i][1]).add(PreRequirsts[i][0]); // Here IT Tells the Edges From Where It Will Go to
                                                                 // Where
        }


        // Nothing Since i Got the Thing Then its Same As Topological Sort
        // Step One Indegree
        Queue<Integer> Q = new LinkedList<>();
         int TopoSort[] = new int[4];
        int Indegree[] = new int[4];
        for (int i = 0; i <4; i++) {
            for (int it = 0; it < Adj.get(i).size(); i++) {
                int Imp=Adj.get(i).get(it);
                Indegree[Imp]++; // Or To Avoid The Confusion Indegree[it]=Indegree[it]+1;

            }

        }

        for (int i = 0; i <4; i++) {
            if (Indegree[i] == 0) {
                Q.add(i);
               
            }
        }

        TopoSortBFS(Adj, n, Q, Indegree,   TopoSort );
        for(int i=0;i<4;i++){
            System.out.println(TopoSort[i]);
        }
    }
}