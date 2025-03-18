class Solution {
    public void setZeroes(int[][] matrix) {
        int rowNumber = matrix.length;
        int columnNumber = matrix[0].length;

        boolean rowFlag = false;
        boolean colFlag = false;

        for (int col = 0; col < columnNumber; col++) {
            if (matrix[0][col] == 0) {
                rowFlag = true;
                break;
            }
        }

        for (int row = 0; row < rowNumber; row++) {
            if (matrix[row][0] == 0) {
                colFlag = true;
                break;
            }
        }

        for (int row = 1; row < rowNumber; row++) {
            for (int col = 1; col < columnNumber; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < rowNumber; row++) {
            for (int col = 1; col < columnNumber; col++) {
                if (matrix[row][col] == 0) {
                    continue;
                }

                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (rowFlag) {
            for (int col = 0; col < columnNumber; col++) {
                matrix[0][col] = 0;
            }
        }

        if (colFlag) {
            for (int row = 0; row < rowNumber; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}