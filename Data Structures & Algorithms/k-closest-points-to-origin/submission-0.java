class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[2], a[2])  
        );

        for (int[] p : points) {
            int x = p[0];
            int y = p[1];
            int ds = (x * x) + (y * y);

            pq.offer(new int[]{x, y, ds});

            if (pq.size() > k)
                pq.poll();
        }

        int[][] ans = new int[k][2];
        int i = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            ans[i][0] = curr[0];
            ans[i][1] = curr[1];
            i++;
        }

        return ans;
    }
}