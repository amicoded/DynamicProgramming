package codes;

import java.util.Arrays;

/**
 * Can travel only in down left or down right or down dir 
 *       /  |  \    
 *      /   |   \
 *      
 */
public class OptimalPathInMatrixBothDiagonal {

    public static int maxPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int lengthY = matrix.length;
        int lengthX = matrix[0].length;
        int[][] pathMatrix = new int[lengthY][lengthX];

        // Copy the first row as is from the matrix
        for (int i = 1; i < lengthX; i++) {
            pathMatrix[0][i] = matrix[0][i];
        }

        for (int i = 1; i < lengthY; i++) {
            for (int j = 1; j < lengthX; j++) {
                if(j == 0) {    //for first colm
                    pathMatrix[i][j] = matrix[i][j]
                            + Math.max(pathMatrix[i - 1][j], pathMatrix[i - 1][j + 1]);
                } else if(j == lengthX-1) { //for last colm
                    pathMatrix[i][j] = matrix[i][j]
                            + Math.max(pathMatrix[i - 1][j], pathMatrix[i - 1][j - 1]);
                } else {
                    pathMatrix[i][j] = matrix[i][j]
                            + Math.max(pathMatrix[i - 1][j], 
                                       Math.max(pathMatrix[i - 1][j - 1], pathMatrix[i - 1][j + 1]));    
                }
            }
        }
        return Arrays.stream(pathMatrix[lengthY - 1]).max().orElse(0);
    }

    public static void main(String[] args) {
        int[][] matrix = { { 3, 2, 8, 1, 1 }, 
                           { 4, 8, 4, 6, 2 },
                           { 7, 6, 8, 5, 3 }, 
                           { 2, 9, 6, 8, 3 }, 
                           { 7, 5, 9, 4, 8 } };
        System.out.println(maxPath(matrix));
    }

}
