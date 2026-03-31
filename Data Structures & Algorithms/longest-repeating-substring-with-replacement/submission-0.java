class Solution {
    public int characterReplacement(String s, int k) {
        //your code goes here
        int n = s.length();
        int max_freq = 0 ,max_len = 0;
        int l = 0 , r = 0;
        int []freq = new int[26];
        
        while(r < n){
            freq[s.charAt(r)- 'A']++;
            max_freq = Math.max(max_freq , freq[s.charAt(r)- 'A']);
            int diff = (r -l +1) - max_freq;
            if(diff <= k){
                max_len = Math.max(max_len, r-l+1);
            }else{
                freq[s.charAt(l)- 'A']--;
                l++;
            }
            r++;
        }
    return max_len;
    }

}