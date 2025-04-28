class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

                for (int i = 0; i < m; i++) {
            int pointer = n-1;
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') {
                    pointer = j - 1;
                } else if (boxGrid[i][j] == '#') {
                    boxGrid[i][j] = '.';
                    boxGrid[i][pointer] = '#';
                    pointer--;
                }
            }
        }

        return rotateClockwise(m, n, boxGrid);
    }

    private char[][] rotateClockwise(int m, int n, char[][] boxGrid) {
        char[][] newGrid = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newGrid[i][j] = boxGrid[m - j - 1][i];
            }
        }

        return newGrid;
    }
}