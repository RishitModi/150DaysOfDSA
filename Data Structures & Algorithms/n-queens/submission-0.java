class Solution {
    private boolean canPlace(char[][] board, int row, int col) {
        for (int r = 0; r < row; r++) {
            if (board[r][col] == 'Q') return false;
        }

        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') return false;
        }

        for (int r = row - 1, c = col + 1; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == 'Q') return false;
        }
        return true;
    }

    private void helper(char[][] board, int row, int n, List<List<String>> ans) {
        if (row == n) {
            List<String> curr = new ArrayList<>();
            for (char[] r : board) {
                curr.add(new String(r));
            }
            ans.add(curr);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (canPlace(board, row, col)) {
                board[row][col] = 'Q';
                helper(board, row + 1, n, ans);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] r : board) {
            Arrays.fill(r, '.');
        }

        List<List<String>> ans = new ArrayList<>();
        helper(board, 0, n, ans);
        return ans;
    }
}