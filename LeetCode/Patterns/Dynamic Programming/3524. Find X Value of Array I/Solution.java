class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] x=new long[k];
        long[] y=new long[k];
        for(int n:nums){
            long[] y1=new long[k];
            int z=n%k;
            y1[z]+=1;
            for(int i=0;i<k;i++){
                if(y[i]>0){
                    int p=(i*z)%k;
                    y1[p]+=y[i];
                }
            }for(int i=0;i<k;i++){
                x[i]+=y1[i];
                y[i]=y1[i];
            }
        }return x;
    }
}