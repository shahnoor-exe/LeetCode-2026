class Solution {
    public int singleNumber(int[] nums) {
        int r=0;
        for(int i=0;i<nums.length; i++){
            int n=nums[i];
            r^=n;
        }
        return r;
    }
}