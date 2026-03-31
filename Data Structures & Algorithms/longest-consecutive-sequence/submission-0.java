class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();

        for(int el : nums){
            hs.add(el);
        }
        int maxi = 0;
        for (int el : hs) {
            if (!hs.contains(el - 1)) {
            int curr = el;
            int count = 1;
            while (hs.contains(curr + 1)) {
                curr++;
                count++;
            }
            maxi = Math.max(maxi, count);
            }
        }
    return maxi;
    }
}