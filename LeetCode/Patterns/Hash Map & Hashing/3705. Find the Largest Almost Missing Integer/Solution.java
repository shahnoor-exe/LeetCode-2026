class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        int[] c=new int[51];
        for(int x:nums) c[x]++;
        if(k==1){
            for(int i=50;i>=0;i--){
                if(c[i]==1) return i;
            }return -1;
        }
        else if(k==n){
            int y=-1;
            for(int x:nums) y=Math.max(x,y);
            return y;
        }
        int y=-1;
        if(c[nums[0]]==1) y=Math.max(y,nums[0]);
        if(c[nums[n-1]]==1) y=Math.max(y,nums[n-1]);
        return y;
    }
}