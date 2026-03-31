class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int l = 0 , r = 0 , max_len = 0;
        int []hash = new int[256];
        Arrays.fill(hash, -1);
        while(r < n){
            if(hash[s.charAt(r)] != -1){
                if(hash[s.charAt(r)] >= l){
                    l = hash[s.charAt(r)] + 1;
                }
            }
            int len = r - l + 1;
            max_len =  Math.max(len,max_len);
            hash[s.charAt(r)] = r;
            r++;
        }
        return max_len;
    }
}
