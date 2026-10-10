class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] x=new int[100001];
        long k=(long) k1+k2, y=0;
        int m=0,n=nums1.length;
        for(int i=0;i<n;i++){
            int d=Math.abs(nums1[i]-nums2[i]);
            x[d]++;
            if(d>m) m=d;
        }for(int i=m;i>0 && k>0;i--){
            long z=Math.min((long) x[i],k);
            x[i]-=z;
            x[i-1]+=z;
            k-=z;
        }for(long i=1;i<=m;i++) if(x[(int) i]>0) y+=x[(int) i]*i*i; 
        return y;
    }
}