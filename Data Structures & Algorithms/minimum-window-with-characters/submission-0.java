class Solution {

    private int getIndex(char ch) {
        if (ch >= 'a') return ch - 'a';
        return ch - 'A' + 26;
    }

    public String minWindow(String s, String t) {
        int[] freq = new int[52];
        for (char ch : t.toCharArray()) {
            freq[getIndex(ch)]++;
        }

        int l = 0, r = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (r < s.length()) {
            int idx = getIndex(s.charAt(r));
            if (freq[idx] > 0) count--;
            freq[idx]--;
            while (count == 0) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                int idxL = getIndex(s.charAt(l));
                freq[idxL]++;
                if (freq[idxL] > 0) count++;
                l++;
            }
            r++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}