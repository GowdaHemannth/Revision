import java.util.*;
  // Here You Know After the Path Compression These Rank Thing Doesnt Make Any Sense 
    // So We Can Actually Group things Or Sort Things By Size
public class DisjointSetTypeTwo {
    public static int FindUrParent(int Node,List<Integer>Parent){
        // Here these Things is the Path Compression Happens
        if(Node==Parent.get(Node)){
            return Node;
        }
        int MainParent=FindUrParent(Parent.get(Node), Parent);
        Parent.set(Node, MainParent);
        return Parent.get(Node);

    }

    public static void UnionBySize(int U,int V, List<Integer>Size, List<Integer>Parent){
        int ParentOfU=FindUrParent(U, Parent);
        int ParentOfV=FindUrParent(V, Parent);
        if(ParentOfU==ParentOfV){
            return;
        }

        if(Size.get(ParentOfU)<Size.get(ParentOfV)){
            Parent.set(ParentOfU, ParentOfV);
            Size.set(ParentOfV, Size.get(ParentOfV)+Size.get(ParentOfU));

        }else{
            // Ebven though the Parent Szie V lesss and Equal Also We Will Connect it Either Way
              Parent.set(ParentOfV, ParentOfU);
            Size.set(ParentOfU, Size.get(ParentOfV)+Size.get(ParentOfU));
        }
    }

  
    public static void main(String[] args) {
        int Nodes=7;
        List<Integer>Size=new ArrayList<>();
        List<Integer>Parent=new ArrayList<>();
        for(int i=0;i<=Nodes;i++){
            Size.add(1);
            Parent.add(i);

        }

        // Its The Same Thing Has Union By Rank But Here Instead of Rank  wE Use Size Here 

        
    }
    
}
