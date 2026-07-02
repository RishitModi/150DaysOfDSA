class Solution {
    int[][] directions = {
        {-1,0} , {0,-1} , {1,0}, {0,1}
    };

    private boolean isValid(int r , int c ,int n , int m){
        return (r>= 0 && r< n) && (c>= 0 && c<m);
    }

    private boolean checkNei(int row , int col, char[][] board,String word, int idx){
        int n = board.length;
        int m = board[0].length;
        if(idx == word.length()) return true;

        char temp = board[row][col];
        board[row][col] = '#';

        for(int[] d : directions){
            int newR = row+d[0];
            int newC = col+d[1];

            if(isValid(newR , newC , n , m) && board[newR][newC] == word.charAt(idx)){
                if(checkNei(newR, newC, board, word, idx + 1)){
                    return true;
                }
            }
        }

        board[row][col] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(board[i][j] == word.charAt(0)){
                    if(checkNei(i, j, board, word, 1))
                        return true;
                }
            }
        }

        return false;
    }
}