class Solution {

    private boolean rulesMet(int row, int col, char[][] board, char digit) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit || board[i][col] == digit)
                return false;
        }

        int s_row = (row / 3) * 3;
        int s_col = (col / 3) * 3;

        for (int i = s_row; i < s_row + 3; i++) {
            for (int j = s_col; j < s_col + 3; j++) {
                if (board[i][j] == digit)
                    return false;
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] != '.') {
                    char temp = board[i][j];
                    board[i][j] = '.';
                    if (!rulesMet(i, j, board, temp))
                        return false;
                    board[i][j] = temp;
                }
            }
        }
        return true;
    }
}