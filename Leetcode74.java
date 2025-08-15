class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length,left = 0, right = matrix.length * matrix[0].length;
        right-=1;
        while(left<=right){
            int mid = left + (right-left)/2;
            int val = matrix[mid/n][mid%n];
            if(val == target) return true;
            else if(val > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
