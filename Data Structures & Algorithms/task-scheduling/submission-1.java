class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int f : freq) {
            if (f > 0) {
                pq.offer(f);
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {

            List<Integer> remaining = new ArrayList<>();

            int cycle = n + 1;

            while (cycle > 0 && !pq.isEmpty()) {

                int count = pq.poll();

                if (count > 1) {
                    remaining.add(count - 1);
                }

                time++;
                cycle--;
            }

            for (int x : remaining) {
                pq.offer(x);
            }

            // If tasks remain, the unused slots become idle.
            if (!pq.isEmpty()) {
                time += cycle;
            }
        }

        return time;
    }
}