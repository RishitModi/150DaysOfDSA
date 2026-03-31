class Solution {
    private boolean checkArray(int[] count){
        int n = count.length;
        for(int i = 0 ; i < n ; i++){
            if(count[i] != 0) return false;
        }
        return true;
    } 

    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int k = s1.length();
        int[] count = new int[26];
        Arrays.fill(count,0);

        for(char ch : s1.toCharArray()){
            count[ch - 'a']++;
        }

       int l = 0,r = 0;
        while(r<n){
            count[s2.charAt(r)-'a']--;
            int length = r-l+1;

            if(length < k){
                r++;
            }else if(length == k){
                if(checkArray(count)) return true;
                count[s2.charAt(l) - 'a']++;
                l++;
                r++;
            }else{
                count[s2.charAt(l) - 'a']++;
                l++;
            }
        }
        return false;
    }
}