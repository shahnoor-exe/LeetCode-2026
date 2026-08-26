class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix.length;j++){
                int n=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=n;
            }
        }
        for(int i=0;i<matrix.length;i++){
            int l=0, r=matrix.length-1;
            while(l<r){
                int n=matrix[i][l];
                matrix[i][l]=matrix[i][r];
                matrix[i][r]=n;
                l++;
                r--;
            }
        }
    }
}