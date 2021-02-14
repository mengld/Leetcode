class Solution {
    public int maxValue(int[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int[][] board = new int[grid.length][grid[0].length];

        board[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i ++) {
            board[0][i] += board[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i ++) {
            board[i][0] = board[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < grid.length; i ++) {
            for (int j = 1; j < grid[0].length; j ++) {
                board[i][j] = Math.max(board[i-1][j], board[i][j-1]) + grid[i][j];
            }
        }

        return board[board.length-1][board[0].length-1];
    }
}
