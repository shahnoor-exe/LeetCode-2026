class Solution {
    public int minOperations(int[] nums, int x) {
        int s=0,n=nums.length;
        for(int i:nums) s+=i;        
        int t=s-x;
        if(t<0) return -1;
        if(t==0) return n;
        int l=0,c=0,m=-1;
        for(int r=0;r<n;r++){
            c+=nums[r];
            while(c>t && l<=r){
                c-=nums[l++];
            }if(c==t) m=Math.max(m,r-l+1);
        }return m==-1?-1:n-m;
    }
}