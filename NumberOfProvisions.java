import java.util.*;
public class NumberOfProvisions {
    public static int FinUrParent(int Node,List<Integer>Parent){
        if(Node==Parent.get(Node)){
            return Node;
        }
        int MainParent=FinUrParent(Parent.get(Node), Parent);
        Parent.set(Node, MainParent);
        return Parent.get(Node);
    }

    public static void FindBySize(int U,int V,List<Integer>Size, List<Integer>Parent){
        int ParentOfU=FinUrParent(U, Parent);
        int ParentOfV=FinUrParent(V, Parent);
        
        //Lets Compare It By Size Things All Confuse them
        if(Size.get(ParentOfV)>Size.get(ParentOfU)){
            Parent.set(ParentOfU,ParentOfV);
            Size.set(ParentOfV, Size.get(ParentOfV)+Size.get(ParentOfU));
        }else{
            Parent.set(ParentOfV, ParentOfU);
            Size.set(ParentOfU,Size.get(ParentOfV)+Size.get(ParentOfU));
        }


    }
    public static void main(String[] args) {
        // Here We Need To Find the Number of Provisions
        // After Knowing the Numerical Disjoint Set theory By Union Or by Size These is A Cake Walk Like of Numerical 
   List<Integer>Size=new ArrayList<>();
   List<Integer>Parent=new ArrayList<>();
   int Nodes=7;
   for(int i=0;i<=Nodes;i++){
    Size.add(1);
    Parent.add(i);
   }
   

   // Here After Calling Each Fucntion only We Need to DO Our Nuerical Otherwise IOt Wont Work
   // For Finding the Number of Provisons 
   // Simple COUNT++
   // tehn For Connectiong the Ropes Just Apply Samll Barin Youy Will Get itTahts All


    }
    
}
