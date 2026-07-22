class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length, c=matrix[0].length;
        int r1=0,c1=c-1; 
        while(r1<r && c1>=0) {
            int m=matrix[r1][c1];
            if(target==m) return true;
            else if(target>m) r1++;
            else c1--;
        } return false;
    }
}