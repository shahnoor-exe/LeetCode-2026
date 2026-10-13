class Solution {
    public long maxAlternatingSum(int[] nums) {
        int[] x=new int[40001];
        for(int i:nums) x[Math.abs(i)]++;
        long y=0;
        int z=(nums.length+1)/2;
        for(long i=40000,t=0;i>=0;z-=t,i--)
            y+=(2*(t=Math.min(z,x[(int) i]))-x[(int) i])*i*i;
            return y;
    }
}