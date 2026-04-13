class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxi = 0;

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {

                int ind = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                int width = nse - pse - 1;
                int area = heights[ind] * width;
                maxi = Math.max(maxi, area);
            }

            st.push(i);
        }
        while (!st.isEmpty()) {
            int ind = st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            int width = nse - pse - 1;
            int area = heights[ind] * width;
            maxi = Math.max(maxi, area);
        }

        return maxi;
    }
}