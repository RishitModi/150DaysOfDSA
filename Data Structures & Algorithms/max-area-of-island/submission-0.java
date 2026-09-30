class Solution {

    int[][] directions = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };

    private boolean isValid(int r, int c, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return r >= 0 && r < n && c >= 0 && c < m;
    }

    private int bfs(int row, int col, int[][] grid, boolean[][] vis) {

        Queue<int[]> q = new ArrayDeque<>();

        int size = 0;

        q.offer(new int[]{row, col});
        vis[row][col] = true;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int currR = curr[0];
            int currC = curr[1];

            size++;

            for (int[] d : directions) {

                int newR = currR + d[0];
                int newC = currC + d[1];

                if (isValid(newR, newC, grid)
                        && grid[newR][newC] == 1
                        && !vis[newR][newC]) {

                    q.offer(new int[]{newR, newC});
                    vis[newR][newC] = true;
                }
            }
        }

        return size;
    }

    public int maxAreaOfIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && !vis[i][j]) {

                    int size = bfs(i, j, grid, vis);

                    ans = Math.max(ans, size);
                }
            }
        }

        return ans;
    }
}