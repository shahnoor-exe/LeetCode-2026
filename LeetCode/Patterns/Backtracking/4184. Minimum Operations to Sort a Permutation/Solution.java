class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length,p=-1;
        boolean a=true, d=true;
        for(int i=0;i<n;i++){
            if(nums[i]==0) p=i;
            if(nums[(i+1)%n]!=(nums[i]+1)%n) a=false;
            if(nums[(i+1)%n]!=(nums[i]-1+n)%n) d=false;
        }if(a) return Math.min(p,p==0?0:n-p+2);
        if(d) return Math.min(p==n-1?1:p+2,n-p);
        return -1;
    }
}