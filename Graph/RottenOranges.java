// https://www.geeksforgeeks.org/problems/rotten-oranges2536/1

class Pair{
   int row;
   int col;
   int time;
   Pair(int row, int col, int time){
       this.row = row;
       this.col = col;
       this.time = time;
   }
    
}
class Solution {
    // Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] vis= new int[m][n];
        int countFresh = 0;
        int tm = 0;
        
        Queue<Pair> queue = new LinkedList<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 2)
                    queue.add(new Pair(i, j, 0));
                else if(mat[i][j] == 1)
                    countFresh++;
            }
        }
        
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, -1, 0, 1};
        
        
        while(!queue.isEmpty()){
            Pair ele = queue.poll();
            int row = ele.row;
            int col = ele.col;
            int time = ele.time;
            
            tm = Math.max(tm, time);
            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1){
                    countFresh -=1;
                    vis[nrow][ncol] = 1;
                    queue.add(new Pair(nrow, ncol, time+1));
                }
            }
            
        }
        if(countFresh > 0)
            return -1;
        return tm;
        
    }
}
