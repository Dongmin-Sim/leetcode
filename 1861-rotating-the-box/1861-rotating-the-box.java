class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        for (int i = 0; i < m; i++) {
            int curPoint = n - 1;

            while (curPoint > 0) {
                if (boxGrid[i][curPoint] == '.') {
                    for (int nextPoint = curPoint - 1; nextPoint >= 0; nextPoint--) {
                        if (boxGrid[i][nextPoint] == '*') break;
                        if (boxGrid[i][nextPoint] == '#') {
                            boxGrid[i][curPoint] = '#';
                            boxGrid[i][nextPoint] = '.';
                            break;
                        }
                    }
                }
                curPoint--;
            }
        }

        return rotateBox(m, n, boxGrid);
    }

    private char[][] rotateBox(int m, int n, char[][] boxGrid) {
        char[][] rotatedBox = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedBox[i][j] = boxGrid[m-j-1][i];
            }
        }

        return rotatedBox;
    }
}