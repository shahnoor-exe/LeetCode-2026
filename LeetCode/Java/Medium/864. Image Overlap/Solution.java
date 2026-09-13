class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length,r=0;
        List<int[]> a=new ArrayList<>(),b=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(img1[i][j]==1) a.add(new int[]{i,j});
                if(img2[i][j]==1) b.add(new int[]{i,j});
            }
        }
        int[][] m=new int[2*n][2*n];
        for(int[] x:a){
            for(int[] y:b){
                r=Math.max(r,++m[y[0]-x[0]+n][y[1]-x[1]+n]);
            }
        }return r;
    }
}