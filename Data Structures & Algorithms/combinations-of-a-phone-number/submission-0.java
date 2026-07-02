class Solution {

    private void func(int ind, String digits, String s,
                      List<String> ans, String[] combos) {

        if (ind == digits.length()) {
            ans.add(s);
            return;
        }

        int digit = digits.charAt(ind) - '0';

        for (int i = 0; i < combos[digit].length(); i++) {
            func(ind + 1, digits,
                 s + combos[digit].charAt(i),
                 ans, combos);
        }
    }

    public List<String> letterCombinations(String digits) {

        String[] combos = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) return ans;

        func(0, digits, "", ans, combos);

        return ans;
    }
}
