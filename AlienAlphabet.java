import java.util.*;
public class AlienAlphabet {
    public static void BFSTopoSort(ArrayList<ArrayList<Integer>>Adj, int InDegree[], int TopoSort[], Queue<Integer>Q){
        int i=0;
        while(!Q.isEmpty()){
            int Parent=Q.peek();
            TopoSort[i++]=Parent;
            Q.poll();
            for(int j =0;j<Adj.get(Parent).size();j++){
                int Child=Adj.get(Parent).get(0);
                InDegree[Child]--;
                if(InDegree[Child]==0){
                    Q.add(Child);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // Here the NUmerical Basically Tells that which Elemsnt SHould Appear Before Which Element 
        // For Example in our English Dictionary we have a Specific Order that we follow like a,b,c

        // Since its an Alien Dictinary Here we need to create those
        // baa
        // abcd    
        // abca      --->>Here the Logic is Has Simple Has That Here what we Gonna Do is we will
                       //--->> We will check each elesmyt if they are matching move forward else tae and create edge
        // caa
        // cad

        // As You In First Iteration we will take 
         // baa and abcd since in first iteration b not eual to a Create A Edge between b and a 
         String Dict[]={"baa","abcd","abca","cab","cad"};
         int n=5;
         int k=4;
         ArrayList<ArrayList<Integer>>Adj=new ArrayList<>();
         for(int i=0;i<k;i++){
            Adj.add(new ArrayList<>());

         }

         for(int i=0;i<n-1;i++){
            String s1=Dict[i];
              String s2=Dict[i];
           
           
            int Length=Math.min(s1.length(), s2.length());
            for(int j=0;j<Length;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                 Adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                 break;

                }

            }
         }

         // Now the Adjcent List is Ready So Now We have Adjcent List in Numbers Liek How do we Want its Liek that Only
         // Now lets Keep track od Indegree
         int InDegree[]=new int[k];
         int TopoSort[]=new int[k];
         for(int i=0;i<k;i++){
            for(int j=0;j<Adj.get(i).size();j++){
             InDegree[i]++;
            }
         }

         Queue<Integer>Q=new LinkedList<>();
         for(int i=0;i<k;i++){
            if(InDegree[i]==0){
                Q.add(i);
            }
         }

         // Here Once you Call the TopoSort Here 
         BFSTopoSort(Adj, InDegree, TopoSort, Q);
         // Here in the TopoSort Array youw ill having order in Numerical hence Convert it into Character 
         String ans="";
         for(int i=0;i<TopoSort.length;i++){
            int It=TopoSort[i];
            // Type Casting Going on Here 
            ans=ans+(char)(It+'a');

         }
         // So here in the ans you will have length here 
    }
    
}
