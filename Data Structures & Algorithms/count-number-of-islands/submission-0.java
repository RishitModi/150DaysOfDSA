class Solution {
    int[][] directions = {
        {1,0} , {0,1} , {-1,0} , {0,-1}
    };

    private boolean isValid(int r , int c , char[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        return (r >= 0) && (r < n) && (c >= 0) && (c < m);
    }
    private void dfs(int row , int col ,char[][] grid , boolean[][] vis){
        vis[row][col] = true;

        for(int[] d: directions){
            int newR = row + d[0];
            int newC = col + d[1];

            if(isValid(newR , newC , grid) && (grid[newR][newC] == '1' && !vis[newR][newC])){
                dfs(newR , newC , grid, vis);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    cnt++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        
        return cnt;
    }
}