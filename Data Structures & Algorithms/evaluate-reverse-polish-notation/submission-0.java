class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();

        for (String token : tokens) {

            if (!isOperator(token)) {
                st.push(Integer.parseInt(token));
            } else {

                int b = st.pop();
                int a = st.pop();

                switch (token) {
                    case "+": st.push(a + b); break;
                    case "-": st.push(a - b); break;
                    case "*": st.push(a * b); break;
                    case "/": st.push(a / b); break;
                }
            }
        }

        return st.peek();
    }

    private boolean isOperator(String s) {
        return s.length() == 1 && "+-*/".contains(s);
    }
}