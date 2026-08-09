class Solution {
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        int[] s=new int[n];
        s[n-1]=piles[n-1];
        for(int i=n-2;i>=0;i--) {
            s[i]=s[i+1]+piles[i];
        }int[][] x=new int[n][n+1];
        return r(0,1,piles,s,x);
    }private int r(int i,int M,int[] piles,int[] s,int[][] x) {
        int n=piles.length;
        if(i+2*M>=n) return s[i];
        if(x[i][M]!=0) return x[i][M];
        int y=0;
        for(int X=1;X<=2*M;X++) {
            int z=Math.max(M, X);
            int c=s[i]-r(i+X,z,piles,s,x);
            y=Math.max(y,c);
        }x[i][M]=y;
        return y;
    }
}