class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0; int l=0;
        for(int n:nums){
            sum+=n;
        }
        for(int i=0;i<nums.length;i++) {
            int r=sum-l-nums[i];
            if(l==r) return i;
            else l+=nums[i];
        }return -1;
    }
}