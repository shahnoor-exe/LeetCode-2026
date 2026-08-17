class Solution {
    int[][] re;
    int[] s;
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        re=new int[n][n];
        s=new int[n+1];
        for(int i=0;i<n;i++){
            s[i+1]=s[i]+stoneValue[i];
        }return dp(0,n-1);
    }private int dp(int l,int r) {
        if(l==r) return 0;
        if(re[l][r]>0) return re[l][r];
        int r1= 0;
        for(int k=l;k<r;k++) {
            int ls=s[k+1]-s[l];
            int rs=s[r+1]-s[k+1];
            if(ls<rs) r1=Math.max(r1,ls+dp(l,k));
            else if(ls>rs) r1=Math.max(r1,rs+dp(k+1,r));
            else r1=Math.max(r1,ls+Math.max(dp(l,k),dp(k+1,r)));
        }return re[l][r] = r1;
    }
}