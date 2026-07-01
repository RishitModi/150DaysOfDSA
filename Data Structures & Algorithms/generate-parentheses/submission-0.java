class Solution {
    private void helper(int n , List<String> ans , String str,int open ,int close){
        if(str.length() == 2*n && open == close){
            ans.add(new String(str));
            return;
        }
        if(open <= n) helper(n , ans , str+'(', open+1,close);
        
        if(open > close) helper(n , ans , str+')' , open , close+1);

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n , ans , "",0,0);
        return ans;
    }
}
