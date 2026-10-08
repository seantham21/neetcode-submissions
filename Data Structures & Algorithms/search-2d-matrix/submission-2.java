class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int numElements = numRows * numCols;

        int l = 0;
        int r = numElements - 1;
        while (l <= r) {
            int mid = l + ((r - l)/2);
            int mRow = mid / numCols;
            int mCol = mid % numCols;

            if (matrix[mRow][mCol] < target) {
                l = mid + 1;
            } else if (matrix[mRow][mCol] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
