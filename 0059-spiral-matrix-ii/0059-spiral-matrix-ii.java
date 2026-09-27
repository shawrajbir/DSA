class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;
        
        while (top <= bottom && left <= right) {
            // Traverse from left to right across top row
            for (int j = left; j <= right; j++) {
                matrix[top][j] = num++;
            }
            top++;
            
            // Traverse down right column
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            
            // Traverse from right to left across bottom row
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = num++;
                }
                bottom--;
            }
            
            // Traverse up left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        
        return matrix;
    }
}