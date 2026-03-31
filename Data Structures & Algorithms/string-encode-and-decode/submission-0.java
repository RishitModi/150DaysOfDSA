class Solution {
    public String encode(List<String> strs) {
        if (strs == null) return "";
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int len = (s == null) ? 0 : s.length();
            sb.append(len).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.isEmpty()) return res;

        int i = 0;
        int n = s.length();
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) != '#') j++;
            int len = Integer.parseInt(s.substring(i, j));
            j++; 
            String str = s.substring(j, j + len);
            res.add(str);i = j + len;
        }
        return res;
    }
}