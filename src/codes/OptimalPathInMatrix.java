package codes;

public class OptimalPathInMatrix {

    public static int maxPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int lengthY = matrix.length;
        int lengthX = matrix[0].length;
        int[][] pathMatrix = new int[lengthY][lengthX];

        pathMatrix[0][0] = matrix[0][0];

        for (int i = 1; i < lengthY; i++) {
            pathMatrix[i][0] = pathMatrix[i-1][0] + matrix[i][0];
        }

        for (int i = 1; i < lengthX; i++) {
            pathMatrix[0][i] = pathMatrix[0][i-1] + matrix[0][i];
        }

        for (int i = 1; i < lengthY; i++) {
            for (int j = 1; j < lengthX; j++) {
                pathMatrix[i][j] = matrix[i][j] + Math.max(pathMatrix[i - 1][j], pathMatrix[i][j - 1]);
            }
        }
        return pathMatrix[lengthY - 1][lengthX - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,2,1,1,1}, 
                          {4,1,4,6,2},
                          {7,6,3,1,1},
                          {2,9,6,8,3},
                          {1,5,9,4,7}};
        System.out.println(maxPath(matrix));
    }

}
