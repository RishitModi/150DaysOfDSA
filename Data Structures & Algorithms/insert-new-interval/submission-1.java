class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> ans = new ArrayList<>();

        for (int[] x : intervals) {
            // Case 1: Current interval completely before newInterval
            if (x[1] < newInterval[0]) {
                ans.add(x);
            }
            // Case 2: Current interval completely after newInterval
            else if (x[0] > newInterval[1]) {
                ans.add(newInterval);
                newInterval = x;  // shift newInterval forward
            }
            // Case 3: Overlapping → merge
            else {
                newInterval[0] = Math.min(newInterval[0], x[0]);
                newInterval[1] = Math.max(newInterval[1], x[1]);
            }
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}