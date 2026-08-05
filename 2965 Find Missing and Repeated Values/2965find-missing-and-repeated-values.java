class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        long N=(long) n*n;
        long s1=N*(N+1)/2;
        long s2=N*(N+1)*(2*N+1)/6;
        long s3=0,s4=0;
        for (int[] r:grid) {
            for (int x:r) {
                s3+=x;
                s4+=(long)x*x;
            }
        }long s5=(s4-s2)/(s3-s1);
        return new int[]{(int)(((s3-s1)+s5)/2), (int)(s5-(((s3-s1)+s5)/2))};
    }
}