import java.util.*;
class Pair{
    String Word;
    int Steps;
    public Pair(String Word,int Steps){
        this.Word=Word;
        this.Steps=Steps;
    }
}
public class WordLadder {
    // Ist Niether the BFS OR DFS BUT WE USE QUEUE 
    // WE ARE USING QUEU becxuase after the Word are elemsnt is present you need to make 
    // sure next itertion should start from That Particular Order
    public static int Function(String WordList[], Queue<Pair>Q,String Start,String Target){
        Q.add(new Pair(Start, 1));

        // Now We are Officially Added Every Words Into the HashSet
        HashSet<String>Set=new HashSet<>();
        for(int i=0;i<WordList.length;i++){
            Set.add(WordList[i]);
        }
        Set.remove(Start);
        

        // Now CoMES Real Word


    }
    public static void main(String[] args) {
        // Given are the two distinct words startWord and targetWord, and a list of size
        // N, denoting wordList of unique words of equal size M. Find the length of the
        // shortest transformation sequence from startWord to targetWord.

        // Keep the following conditions in mind:

        // A word can only consist of lowercase characters.
        // Only one letter can be changed in each transformation.
        // Each transformed word must exist in the wordList including the targetWord.
        // startWord may or may not be part of the wordList

        String WordList[]= {"des","der","dfr","dgt","dfs"};
        // Here lets Use Sets Because After the Each Transformation we Need to Make Sure That
        // Whther the Given Word is Present in the Lsit OR NOT
        Queue<Pair>Q=new LinkedList<>();


    }

}
