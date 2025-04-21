class Solution {
    public int minPathSum(int[][] grid) {
        int y = grid[0].length;
        for (int i = 1; i < y; i++) {
            grid[0][i] = grid[0][i] + grid[0][i - 1];
        }

        int x = grid.length;
        for (int i = 1; i < x; i++) {
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[x - 1][y - 1];
    }
}