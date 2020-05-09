class Solution {
    public void rotate(int[][] matrix) {
        
        if(matrix.length == 1 && matrix[0].length == 1)
            return;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //transpose
        //mirror
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length-j-1];
                matrix[i][matrix[0].length-j-1] = temp;
            }
        }
        //return matrix;
    }
}