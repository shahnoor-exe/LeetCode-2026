class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] r=new int[n];
        r[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--) r[i]=Math.min(r[i+1],nums[i]);
        int l=-1;
        for(int i=0;i<n;i++){
            l=Math.max(l,nums[i]);
            if(l-r[i]<=k) return i;
        }return -1;
    }
}