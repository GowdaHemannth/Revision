package Pattern1BFSandDFS;

public class SurrondedRegions {
    // Here nUMICAL iS aS SIMILAR FOR pREVIOUS nUMERICALS THE ONLY dIFFERNCE IS
    // IF THE IF THE 0 IS FROM bOUNDARY bOUNDARY MENAS fROM fIRST rOW lAST Row
    // ,First Column ,last Row

    public static void Function(int Regoins[][], int n, int m, boolean Visited[][], int StartRow, int StartCol) {
        Visited[StartRow][StartCol] = true;

        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int NewRow = drow[i] + StartRow;
            int NewCol = dcol[i] + StartCol;
            if (Regoins[NewRow][NewCol] == 0 && NewRow >= 0 && NewRow < n && NewCol >= 0 && NewCol < n
                    && Visited[NewRow][NewCol] != true) {
                Visited[NewRow][NewCol] = true;
                Function(Regoins, n, m, Visited, NewRow, NewCol);

            }
        }

    }

    public static void main(String[] args) {

        int Regoins[][] = {
                { 1, 1, 1, 1, 1 },
                { 1, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 0 },
                { 1, 0, 1, 0, 1 },
                { 0, 0, 1, 1, 1 }
        };

        int n = Regoins.length;
        int m = Regoins[0].length;
        boolean Visited[][] = new boolean[n][m];

        // Here the Speciality is Weare using DFS FUNCTION JUST FOR MARKING THE THINGS LIKE IS IT VISTED OR NOT 

        // FirstRow and Last Row
        for(int i=0;i<n;i++){
            // First Row
            if(Regoins[0][i]==0&& Visited[0][i]!=true){
                Function(Regoins, n, m, Visited, 0, i);
            }

            //Last Row
            if(Regoins[n-1][i]==0&& Visited[n-1][i]!=true){
                Function(Regoins, n, m, Visited, n-1, i);
                
            }
        }

        // FirstColumn and Last Column

            for(int i=0;i<m;i++){
            // First col
            if(Regoins[i][0]==0&& Visited[i][0]!=true){
                Function(Regoins, n, m, Visited, i, 0);
            }

            //Last Row
            if(Regoins[i][m-1]==0&& Visited[i][m-1]!=true){
                Function(Regoins, n, m, Visited, n-1, i);
                
            }
        }

        // Here Comes the Actual Part 

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (Regoins[i][j]==0 && Visited[i][j]!=true) {
                    //  These Things Like Tampering the Original is Not Good Parctice hence create new one 

                    Regoins[i][j]=0;
                    
                }
            }
        }
    }

}
