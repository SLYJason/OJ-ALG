package LeetCode.LC_201_400.LC289;

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    int DEAD = 0;
    int LIVE = 1;
    int DEAD_TO_LIVE = 2;
    int LIVE_TO_DEAD = 3;
    public void gameOfLife(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int lives = numberOfLive(i, j, board);
                if(board[i][j] == LIVE || board[i][j] == LIVE_TO_DEAD) {
                    if(lives < 2) {
                        board[i][j] = LIVE_TO_DEAD; // rule 1.
                    } else if(lives == 2 || lives == 3) {
                        board[i][j] = LIVE; // rule 2.
                    } else {
                        board[i][j] = LIVE_TO_DEAD; // rule 3.
                    }
                } else {
                    if(lives == 3) board[i][j] = DEAD_TO_LIVE; // rule 4.
                }
            }
        }
        // set the next state of the board.
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == DEAD_TO_LIVE) board[i][j] = 1;
                if(board[i][j] == LIVE_TO_DEAD) board[i][j] = 0;
            }
        }
    }

    private int numberOfLive(int i, int j, int[][] board) {
        int lives = 0;
        for(int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length && (board[ni][nj] == LIVE || board[ni][nj] == LIVE_TO_DEAD)) lives++;
        }
        return lives;
    }
}