class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long l=1,r=(long)coins[0]*k;
        for(int c:coins)r=Math.min(r,(long)c*k);
        while(l<r){
            long m=l+(r-l)/2;
            if(count(coins,m)>=k)r=m;
            else l=m+1;
        }return l;
    }private long count(int[] coins,long m){
        int n=coins.length;
        long cnt=0;
        for(int mask=1;mask<(1<<n);mask++){
            long curLcm=1;
            int bits=0;
            for(int i=0;i<n;i++) {
                if((mask&(1<<i))!=0) {
                    curLcm=lcm(curLcm,coins[i]);
                    bits++;
                    if(curLcm>m)break;
                }
            }cnt+=(bits%2==1?1:-1)*(m/curLcm);
        }return cnt;
    }private long gcd(long a,long b) {return b==0?a:gcd(b,a%b);}
    private long lcm(long a,long b) {return (a/gcd(a,b))*b;}
}