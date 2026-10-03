class Solution {

    int m, n;
    int[][] heights;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific: top row + left column
        for(int c = 0; c < n; c++) {
            dfs(0, c, pacific);
        }

        for(int r = 0; r < m; r++) {
            dfs(r, 0, pacific);
        }

        // Atlantic: bottom row + right column
        for(int c = 0; c < n; c++) {
            dfs(m - 1, c, atlantic);
        }

        for(int r = 0; r < m; r++) {
            dfs(r, n - 1, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(pacific[r][c] && atlantic[r][c]) {
                    ans.add(Arrays.asList(r, c));
                }
            }
        }

        return ans;
    }

    private void dfs(int r, int c, boolean[][] vis) {
        if(vis[r][c]) return;

        vis[r][c] = true;

        for(int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr < 0 || nc < 0 || nr >= m || nc >= n)
                continue;

            if(vis[nr][nc])
                continue;

            // reverse flow condition
            if(heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, vis);
            }
        }
    }
}