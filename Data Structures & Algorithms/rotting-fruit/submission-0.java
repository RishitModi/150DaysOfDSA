class Solution {
    
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};

    private boolean isValid(int i, int j, int n, int m) {
        
        if(i < 0 || i >= n) return false;
        if(j < 0 || j >= m) return false;
        
        return true;
    }

    public int orangesRotting(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        int time = 0;

        
        // Step 1: Count fresh oranges and store rotten ones
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 1) {
                    fresh++;
                }

                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        
        // Step 2: Multi-source BFS
        while(!q.isEmpty() && fresh > 0) {

            int size = q.size();

            while(size-- > 0) {

                int[] cell = q.poll();

                int row = cell[0];
                int col = cell[1];

                for(int i = 0; i < 4; i++) {

                    int nRow = row + delRow[i];
                    int nCol = col + delCol[i];

                    if(isValid(nRow, nCol, n, m) &&
                       grid[nRow][nCol] == 1) {

                        grid[nRow][nCol] = 2;

                        fresh--;

                        q.add(new int[]{nRow, nCol});
                    }
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}