class Solution {

    int[][] directions = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };

    private boolean isValid(int r, int c, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public void islandsAndTreasure(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        // Step 1: Put every treasure into the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        // Step 2: BFS from all treasures simultaneously
        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for (int[] d : directions) {

                int newR = r + d[0];
                int newC = c + d[1];

                // Only visit unvisited land
                if (isValid(newR, newC, grid)
                        && grid[newR][newC] == Integer.MAX_VALUE) {

                    grid[newR][newC] = grid[r][c] + 1;

                    q.offer(new int[]{newR, newC});
                }
            }
        }
    }
}