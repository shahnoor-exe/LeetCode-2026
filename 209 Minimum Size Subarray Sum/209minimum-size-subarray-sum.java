class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0, ml=nums.length+1, s=0;
        for(int r=0;r<nums.length;r++){
            s+=nums[r];
            while(s>=target){
                ml=Math.min(ml,(r-l+1));
                s-=nums[l++];
            }
        }return ml==nums.length+1?0:ml;
    }
}