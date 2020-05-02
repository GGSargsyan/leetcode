class Solution {
    public int countBattleships(char[][] board) {
        int ships = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if((i == 0 || board[i-1][j] == '.') && (j == 0 || board[i][j-1] == '.') && (board[i][j] == 'X')){
                    ships++;
                }   
            }
        }
        return ships;
    }
}