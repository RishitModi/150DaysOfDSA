class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int k = s1.length();
        int[] count = new int[26];
        Arrays.fill(count,0);

        for(char ch : s1.toCharArray()){
            count[ch - 'a']++;
        }

        int matches = 0;
        for(int i : count){
            if(i == 0) matches++;
        }

        int l = 0, r = 0;

        while(r < n){
            count[s2.charAt(r)-'a']--;
            if(count[s2.charAt(r)-'a'] == 0) matches++;
            else if(count[s2.charAt(r)-'a'] == -1) matches--;

            int length = r - l + 1;

            if(length < k){
                r++;
            } 
            else if(length == k){
                if(matches == 26) return true;

                count[s2.charAt(l) - 'a']++;

                if(count[s2.charAt(l)-'a'] == 0) matches++;
                else if(count[s2.charAt(l)-'a'] == 1) matches--;

                l++;
                r++;
            } 
            else {
                count[s2.charAt(l) - 'a']++;
                if(count[s2.charAt(l)-'a'] == 0) matches++;
                else if(count[s2.charAt(l)-'a'] == 1) matches--;

                l++;
            }
        }
        return false;
    }
}