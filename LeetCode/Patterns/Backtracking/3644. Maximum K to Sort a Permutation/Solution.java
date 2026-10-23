class Solution {
    public int sortPermutation(int[] nums) {
        int k=-1,c=0;
        for(int i=0;i<nums.length;i++)
        if(nums[i]!=i) k=c++==0?nums[i]:k & nums[i];
        return c==0?0:k;
    }
}